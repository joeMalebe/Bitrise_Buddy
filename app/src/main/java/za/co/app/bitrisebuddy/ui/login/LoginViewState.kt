package za.co.app.bitrisebuddy.ui.login

import za.co.app.bitrisebuddy.model.data.models.V0UserProfileDataModel

interface LoginViewState {
    object Loading : LoginViewState
    class UserAuthenticated(val v0UserProfileDataModel: V0UserProfileDataModel) : LoginViewState
    object AuthenticationError : LoginViewState
    class Error(val errorMessage: String) : LoginViewState

}