package za.co.app.bitrisebuddy.model.repository

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import retrofit2.Response
import za.co.app.bitrisebuddy.model.data.apis.UserApi
import za.co.app.bitrisebuddy.model.data.models.V0UserProfileRespModel

class UserRepository(private val userApi: UserApi, private val context: Context) : IUserRepository {

    override suspend fun getUserAsync(accessToken : String): Deferred<Response<V0UserProfileRespModel>> {
        return CoroutineScope(IO).async {
            userApi.userProfile(accessToken)
        }
    }
}