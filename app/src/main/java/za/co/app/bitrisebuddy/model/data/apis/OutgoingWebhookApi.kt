/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.apis

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import za.co.app.bitrisebuddy.model.data.models.V0AppWebhookCreateParams
import za.co.app.bitrisebuddy.model.data.models.V0AppWebhookCreatedResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0AppWebhookDeletedResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0AppWebhookListResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0AppWebhookResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0AppWebhookUpdateParams

@JvmSuppressWildcards
interface OutgoingWebhookApi {
    /**
     * Create an outgoing webhook for an app
     * Create an outgoing webhook for a specified Bitrise app: this can be used to send build events to a specified URL with custom headers. Currently, only build events can trigger outgoing webhooks.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param appWebhookCreateParams App webhook creation params (required)
     */
    @Headers(
        "X-Operation-ID: outgoing-webhook-create"
    )
    @POST("apps/{app-slug}/outgoing-webhooks")
    suspend fun outgoingWebhookCreate(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Body appWebhookCreateParams: V0AppWebhookCreateParams
    ): V0AppWebhookCreatedResponseModel
    /**
     * Delete an outgoing webhook of an app
     * Delete an existing outgoing webhook for a specified Bitrise app.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param appWebhookSlug App webhook slug (required)
     */
    @Headers(
        "X-Operation-ID: outgoing-webhook-delete"
    )
    @DELETE("apps/{app-slug}/outgoing-webhooks/{app-webhook-slug}")
    suspend fun outgoingWebhookDelete(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("app-webhook-slug") appWebhookSlug: String
    ): V0AppWebhookDeletedResponseModel
    /**
     * List the outgoing webhooks of an app
     * List all the outgoing webhooks registered for a specified Bitrise app. This returns all the relevant data of the webhook, including the slug of the webhook and its URL.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param next Slug of the first webhook in the response (optional)
     * @param limit Max number of elements per page (default: 50) (optional)
     */
    @Headers(
        "X-Operation-ID: outgoing-webhook-list"
    )
    @GET("apps/{app-slug}/outgoing-webhooks")
    suspend fun outgoingWebhookList(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Query("next") next: String?,
        @retrofit2.http.Query("limit") limit: Int?
    ): V0AppWebhookListResponseModel
    /**
     * Update an outgoing webhook of an app
     * Update an existing outgoing webhook (URL, events, secrets and headers) for a specified Bitrise app. Even if you do not want to change one of the parameters, you still have to provide that parameter as well: simply use its existing value.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param appWebhookSlug App webhook slug (required)
     * @param appWebhookUpdateParams App webhook update params (required)
     */
    @Headers(
        "X-Operation-ID: outgoing-webhook-update"
    )
    @PUT("apps/{app-slug}/outgoing-webhooks/{app-webhook-slug}")
    suspend fun outgoingWebhookUpdate(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("app-webhook-slug") appWebhookSlug: String,
        @retrofit2.http.Body appWebhookUpdateParams: V0AppWebhookUpdateParams
    ): V0AppWebhookResponseModel
}