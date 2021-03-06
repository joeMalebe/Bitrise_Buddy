package za.co.app.bitrisebuddy.model.repository

import kotlinx.coroutines.Deferred
import retrofit2.Response
import za.co.app.bitrisebuddy.model.data.models.V0BuildListAllResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0BuildListResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0BuildTriggerRespModel
import za.co.app.bitrisebuddy.model.data.models.V0BuildWorkflowListResponseModel

interface IBuildsRepository {
    suspend fun getLatestBuildsAsync(): Deferred<Response<V0BuildListAllResponseModel>>
    suspend fun getAppBuildsAsync(appSlug: String): Deferred<Response<V0BuildListResponseModel>>
    suspend fun triggerBuild(
        appSlug: String,
        branch: String,
        workflowId: String,
        message: String
    ): Response<V0BuildTriggerRespModel>
    suspend fun workflows(appSlug: String): Response<V0BuildWorkflowListResponseModel>
}