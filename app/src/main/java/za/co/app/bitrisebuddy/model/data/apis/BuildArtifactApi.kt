/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.apis

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import za.co.app.bitrisebuddy.model.data.models.V0ArtifactDeleteResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0ArtifactListResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0ArtifactShowResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0ArtifactUpdateParams

@JvmSuppressWildcards
interface BuildArtifactApi {
    /**
     * Delete a build artifact
     * Delete a build artifact of an app's build. The required parameters are app slug, build slug and artifact slug. You can fetch the build artifact slug if you first list all build artifacts of an app with the [/apps/](https://api-docs.bitrise.io/#/build-artifact/artifact-list) endpoint.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param buildSlug Build slug (required)
     * @param artifactSlug Artifact slug (required)
     */
    @Headers(
        "X-Operation-ID: artifact-delete"
    )
    @DELETE("apps/{app-slug}/builds/{build-slug}/artifacts/{artifact-slug}")
    suspend fun artifactDelete(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("build-slug") buildSlug: String,
        @retrofit2.http.Path("artifact-slug") artifactSlug: String
    ): V0ArtifactDeleteResponseModel
    /**
     * Get a list of all build artifacts
     * List all build artifacts that have been generated for an app's build. You can use the created build artifact slugs from the response output to retrieve data of a specific build artifact with the [GET/apps/](https://api-docs.bitrise.io/#/build-artifact/artifact-show) endpoint or update a build artifact with the [PATCH/apps](https://api-docs.bitrise.io/#/build-artifact/artifact-update) endpoint.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param buildSlug Build slug (required)
     * @param next Slug of the first build artifact in the response (optional)
     * @param limit Max number of build artifacts per page is 50. (optional)
     */
    @Headers(
        "X-Operation-ID: artifact-list"
    )
    @GET("apps/{app-slug}/builds/{build-slug}/artifacts")
    suspend fun artifactList(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("build-slug") buildSlug: String,
        @retrofit2.http.Query("next") next: String?,
        @retrofit2.http.Query("limit") limit: Int?
    ): V0ArtifactListResponseModel
    /**
     * Get a specific build artifact
     * Retrieve data of a specific build artifact. The response output contains a time-limited download url (expires in 10 minutes) and a public install page URL. You can view the build artifact with both URLs, but the public install page url will not work unless you [enable it](https://devcenter.bitrise.io/tutorials/deploy/bitrise-app-deployment/#enabling-public-page-for-the-app).
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param buildSlug Build slug (required)
     * @param artifactSlug Artifact slug (required)
     * @param download Setting this will result in a redirect to the artifact download location (optional)
     */
    @Headers(
        "X-Operation-ID: artifact-show"
    )
    @GET("apps/{app-slug}/builds/{build-slug}/artifacts/{artifact-slug}")
    suspend fun artifactShow(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("build-slug") buildSlug: String,
        @retrofit2.http.Path("artifact-slug") artifactSlug: String,
        @retrofit2.http.Query("download") download: Int?
    ): V0ArtifactShowResponseModel
    /**
     * Update a build artifact
     * Update the `is_public_page_enabled` attribute of your app's build. The required parameters are app slug, build slug and artifact slug. You can fetch the build artifact slug if you first list all build artifacts of an app with the [GET /apps/](https://api-docs.bitrise.io/#/build-artifact/artifact-list) endpoint.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param buildSlug Build slug (required)
     * @param artifactSlug Artifact slug (required)
     * @param artifactParams Artifact parameters (required)
     */
    @Headers(
        "X-Operation-ID: artifact-update",
      "Content-Type: application/json"
    )
    @PATCH("apps/{app-slug}/builds/{build-slug}/artifacts/{artifact-slug}")
    suspend fun artifactUpdate(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("build-slug") buildSlug: String,
        @retrofit2.http.Path("artifact-slug") artifactSlug: String,
        @retrofit2.http.Body artifactParams: V0ArtifactUpdateParams
    ): V0ArtifactShowResponseModel
}
