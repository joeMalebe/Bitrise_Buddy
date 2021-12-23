package za.co.app.bitrisebuddy.model.repository

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import okhttp3.MediaType
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import za.co.app.bitrisebuddy.model.data.apis.BuildsApi
import za.co.app.bitrisebuddy.model.data.models.*
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
        workflowId: String
    ): Response<V0BuildTriggerRespModel> {

        val sharedPreferences =
            context.getSharedPreferences(RepositoryUtil.USER_PREFERENCES, Context.MODE_PRIVATE)

        val token = sharedPreferences.getString(RepositoryUtil.ACCESS_TOKEN, "none") ?: "none"
        val buildParams = V0BuildTriggerParamsBuildParams(branch = branch, workflowId = workflowId)
        val request = V0BuildTriggerParams(buildParams = buildParams)
        val response = CoroutineScope(IO).async {

            buildsApi.buildTrigger(appSlug, request, token)
        }
        return try {
            response.await()
        } catch (ex: Exception) {
            Response.error(500, (ex.message ?: "error").toResponseBody())
        }
    }
}