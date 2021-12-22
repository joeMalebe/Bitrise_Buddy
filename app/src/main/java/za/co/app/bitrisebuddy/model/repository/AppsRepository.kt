package za.co.app.bitrisebuddy.model.repository

import android.content.Context
import android.util.Log
import kotlinx.coroutines.*
import retrofit2.Response
import za.co.app.bitrisebuddy.model.data.apis.ApplicationApi
import za.co.app.bitrisebuddy.model.data.models.V0AppListResponseModel
import za.co.app.bitrisebuddy.model.repository.RepositoryUtil.ACCESS_TOKEN
import za.co.app.bitrisebuddy.model.repository.RepositoryUtil.USER_PREFERENCES
import javax.inject.Inject

class AppsRepository @Inject constructor (private val applicationApi: ApplicationApi, private val context : Context) : IAppsRepository {

    override suspend fun getAppsAsync(
        sortby: String,
        next: String,
        limit: Int
    ): Deferred<Response<V0AppListResponseModel>> {

        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.e("Test error", throwable.message ?: "")
        }
        return CoroutineScope(Dispatchers.IO).async(exceptionHandler) {
            val sharedPreferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

            val token = sharedPreferences.getString(ACCESS_TOKEN, "none") ?: "none"
            val response = applicationApi
                .appList(
                    "",
                    "",
                    50,
                    token
                )

            Log.d("Test success", response.message())
            response
        }
    }
}