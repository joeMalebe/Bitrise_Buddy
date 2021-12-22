package za.co.app.bitrisebuddy.ui.landing.apps

import za.co.app.bitrisebuddy.model.data.models.V0AppResponseItemModel

interface AppsViewState {
    object Loading : AppsViewState
    class AppsLoaded(val apps: List<V0AppResponseItemModel>) : AppsViewState
    class Error(val message: String) : AppsViewState
    object AuthenticationError : AppsViewState

}