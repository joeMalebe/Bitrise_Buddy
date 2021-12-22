package za.co.app.bitrisebuddy.model.repository

import kotlinx.coroutines.Deferred
import retrofit2.Response
import za.co.app.bitrisebuddy.model.data.models.V0BuildListAllResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0BuildListResponseModel

interface IBuildsRepository {
    suspend fun getLatestBuildsAsync(): Deferred<Response<V0BuildListAllResponseModel>>
    suspend fun getAppBuildsAsync(appSlug: String): Deferred<Response<V0BuildListResponseModel>>
}