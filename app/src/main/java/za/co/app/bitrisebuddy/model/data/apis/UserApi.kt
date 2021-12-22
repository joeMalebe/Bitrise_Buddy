/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.apis

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import za.co.app.bitrisebuddy.model.data.models.V0UserPlanRespModel
import za.co.app.bitrisebuddy.model.data.models.V0UserProfileRespModel

@JvmSuppressWildcards
interface UserApi {
    /**
     * The active addon tokens of the user
     * Lists the active addon tokens of the user with some extra details.
     * The endpoint is owned by defaultname service owner
     */
    @Headers(
        "X-Operation-ID: user-addon-tokens"
    )
    @GET("me/addon-tokens")
    suspend fun userAddonTokens(): List<String>
    /**
     * Removes an active addon token of the user
     * Removes the active addon token of the user.
     * The endpoint is owned by defaultname service owner
     */
    @Headers(
        "X-Operation-ID: user-addon-tokens-delete"
    )
    @DELETE("me/addon-tokens/{addon-id}")
    suspend fun userAddonTokensDelete(): Unit
    /**
     * The subscription plan of the user
     * Get the subscription of the user: the current plan, any pending plans, and the duration of a trial period if applicable
     * The endpoint is owned by defaultname service owner
     */
    @Headers(
        "X-Operation-ID: user-plan"
    )
    @GET("me/plan")
    suspend fun userPlan(): V0UserPlanRespModel
    /**
     * Get your profile data
     * Shows the authenticated users profile data
     * The endpoint is owned by defaultname service owner
     */
    @Headers(
        "X-Operation-ID: user-profile"
    )
    @GET("me")
    suspend fun userProfile(@Header("Authorization") accessToken: String): Response<V0UserProfileRespModel>

    /**
     * Get a specific user
     * Show information about a specific user
     * The endpoint is owned by defaultname service owner
     * @param userSlug User slug (required)
     */
    @Headers(
        "X-Operation-ID: user-show"
    )
    @GET("users/{user-slug}")
    suspend fun userShow(
        @retrofit2.http.Path("user-slug") userSlug: String
    ): V0UserProfileRespModel
}