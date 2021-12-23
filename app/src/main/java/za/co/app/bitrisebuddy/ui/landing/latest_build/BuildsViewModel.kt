package za.co.app.bitrisebuddy.ui.landing.latest_build

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import za.co.app.bitrisebuddy.model.repository.IBuildsRepository
import za.co.app.bitrisebuddy.model.repository.RepositoryUtil.UNAUTHORIZED
import javax.inject.Inject

@HiltViewModel
class BuildsViewModel @Inject constructor(private val buildsRepository: IBuildsRepository) : ViewModel() {

    val viewState = MutableLiveData<BuildsViewState>()

    init {
        viewState.value = BuildsViewState.Loading
    }

    fun loadAllBuilds() {

        viewModelScope.launch {

            val response = buildsRepository.getLatestBuildsAsync().await()
            val currentViewState = if (response.isSuccessful && response.body() != null && response.body()!!.data != null) {
                BuildsViewState.BuildsLoaded(response.body()!!.data!!)
            } else if (response.code() == UNAUTHORIZED) {
                BuildsViewState.AuthenticationError
            } else {
                BuildsViewState.Error(response.message())
            }
            viewState.postValue(currentViewState)
        }
    }

    fun loadAppBuilds(appSlug : String) {
        viewModelScope.launch {
            val response = buildsRepository.getAppBuildsAsync(appSlug).await()
            val currentViewState = if (response.isSuccessful && response.body() != null && response.body()!!.data != null) {
                BuildsViewState.AppBuildsLoaded(response.body()!!.data!!)
            } else if (response.code() == UNAUTHORIZED) {
                BuildsViewState.AuthenticationError
            } else {
                BuildsViewState.Error(response.message())
            }
            viewState.postValue(currentViewState)
        }
    }

    fun triggerBuild(appSlug: String, branch: String, workflowId: String) {
        viewState.value = BuildsViewState.Loading
        viewModelScope.launch {
            val response = buildsRepository.triggerBuild(appSlug, branch, workflowId)
            if (response.isSuccessful && response.body() != null) {
                viewState.postValue(BuildsViewState.BuildTriggered(response.body()!!))
            } else if (response.code() == UNAUTHORIZED) {
                BuildsViewState.AuthenticationError
            } else {
                BuildsViewState.Error(response.message())
            }
        }
    }
}