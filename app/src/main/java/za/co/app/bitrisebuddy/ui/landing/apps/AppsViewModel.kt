package za.co.app.bitrisebuddy.ui.landing.apps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import za.co.app.bitrisebuddy.model.repository.IAppsRepository
import javax.inject.Inject

@HiltViewModel
class AppsViewModel @Inject constructor(val appsRepository: IAppsRepository) : ViewModel() {

    val viewState = MutableLiveData<AppsViewState>()

    init {
        viewState.value = AppsViewState.Loading
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            val response = appsRepository.getAppsAsync().await()
            val state = if (response.isValidResponse()) {
                val apps = response.body()?.data

                if (apps == null) {
                    AppsViewState.Error("No applications found")
                } else {
                    AppsViewState.AppsLoaded(apps)
                }
            } else {
                if (response.code() == 401) {
                    AppsViewState.AuthenticationError
                } else {
                    AppsViewState.Error(response.errorBody().toString())
                }
            }
            viewState.postValue(state)
        }
    }
}

fun <T> Response<T>.isValidResponse(): Boolean {
    return this.isSuccessful && this.body() != null
}