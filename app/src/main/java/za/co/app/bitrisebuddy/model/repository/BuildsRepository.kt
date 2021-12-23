package za.co.app.bitrisebuddy.model.repository

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Response
import za.co.app.bitrisebuddy.model.data.apis.BuildsApi
import za.co.app.bitrisebuddy.model.data.models.V0BuildListAllResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0BuildListResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0BuildTriggerRespModel
import javax.inject.Inject

class BuildsRepository @Inject constructor(private val buildsApi: BuildsApi,private val context: Context) :
    IBuildsRepository {

    override suspend fun getLatestBuildsAsync(): Deferred<Response<V0BuildListAllResponseModel>> {
        return CoroutineScope(Dispatchers.IO).async() {
            val sharedPreferences = context.getSharedPreferences(RepositoryUtil.USER_PREFERENCES, Context.MODE_PRIVATE)

            val token = sharedPreferences.getString(RepositoryUtil.ACCESS_TOKEN, "none") ?: "none"
            buildsApi.buildListAll("",null,null,"",null, token)
        }

    }

    override suspend fun getAppBuildsAsync(appSlug: String): Deferred<Response<V0BuildListResponseModel>> {
        return CoroutineScope(Dispatchers.IO).async() {
            val sharedPreferences =
                context.getSharedPreferences(RepositoryUtil.USER_PREFERENCES, Context.MODE_PRIVATE)

            val token = sharedPreferences.getString(RepositoryUtil.ACCESS_TOKEN, "none") ?: "none"
            buildsApi.buildList(
                appSlug,
                null,
                null,
                "",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                token
            )
        }
    }

    override suspend fun triggerBuild(
        appSlug: String,
        branch: String,
        workflow: String,
        message: String
    ): Response<V0BuildTriggerRespModel> {
        TODO("Not yet implemented")
    }
}