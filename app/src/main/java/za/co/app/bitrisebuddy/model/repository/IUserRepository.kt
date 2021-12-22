package za.co.app.bitrisebuddy.model.repository

import kotlinx.coroutines.Deferred
import retrofit2.Response
import za.co.app.bitrisebuddy.model.data.models.V0UserProfileRespModel

interface IUserRepository {
    suspend fun getUserAsync(accessToken: String): Deferred<Response<V0UserProfileRespModel>>
}