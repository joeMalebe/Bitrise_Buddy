package za.co.app.bitrisebuddy.model.repository

import kotlinx.coroutines.Deferred
import retrofit2.Response
import za.co.app.bitrisebuddy.model.data.models.V0AppListResponseModel

interface IAppsRepository {

    suspend fun getAppsAsync(
        sortby: String = "",
        next: String = "",
        limit: Int = 50
    ): Deferred<Response<V0AppListResponseModel>>
}
