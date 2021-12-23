package za.co.app.bitrisebuddy.ui.landing.latest_build

import za.co.app.bitrisebuddy.model.data.models.V0BuildListAllResponseItemModel
import za.co.app.bitrisebuddy.model.data.models.V0BuildResponseItemModel
import za.co.app.bitrisebuddy.model.data.models.V0BuildTriggerRespModel
import za.co.app.bitrisebuddy.model.data.models.V0BuildWorkflowListResponseModel

interface BuildsViewState {
    object Loading : BuildsViewState
    class BuildsLoaded(val builds: List<V0BuildListAllResponseItemModel>) : BuildsViewState
    class AppBuildsLoaded(val builds: List<V0BuildResponseItemModel>) : BuildsViewState
    object AuthenticationError : BuildsViewState
    class Error(val errorMessage: String) : BuildsViewState
    class BuildTriggered(val buildTriggered: V0BuildTriggerRespModel) : BuildsViewState
    class WorkflowsLoaded(val workflows: V0BuildWorkflowListResponseModel) : BuildsViewState
}