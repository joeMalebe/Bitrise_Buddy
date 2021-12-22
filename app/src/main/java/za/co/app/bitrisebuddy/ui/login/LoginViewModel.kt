package za.co.app.bitrisebuddy.ui.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import za.co.app.bitrisebuddy.model.repository.IUserRepository
import za.co.app.bitrisebuddy.model.repository.RepositoryUtil.ACCESS_TOKEN
import za.co.app.bitrisebuddy.model.repository.RepositoryUtil.UNAUTHORIZED
import za.co.app.bitrisebuddy.model.repository.RepositoryUtil.USER_PREFERENCES
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: IUserRepository,  @ApplicationContext val context: Context) :
    ViewModel() {

    var viewState: MutableLiveData<LoginViewState> = MutableLiveData()

    fun authenticateUser(accessToken: String) {
        viewState.value = LoginViewState.Loading

        viewModelScope.launch {
            val response = userRepository.getUserAsync(accessToken).await()
            if (response.isSuccessful && response.body() != null && response.body()!!.data != null) {
                updatePrefs(accessToken)
                viewState.postValue(LoginViewState.UserAuthenticated(response.body()!!.data!!))
            } else if (response.code() == UNAUTHORIZED) {
                viewState.postValue(LoginViewState.AuthenticationError)
            } else {
                viewState.postValue(LoginViewState.Error(response.message()))
            }
        }
    }

    fun updatePrefs(accessToken: String) {
        context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE).also { it.edit().
            putString(
                ACCESS_TOKEN,
                accessToken
            ).apply()
        }
    }
}