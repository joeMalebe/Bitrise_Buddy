/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.apis

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import za.co.app.bitrisebuddy.model.data.models.ServiceStandardErrorRespModel
import za.co.app.bitrisebuddy.model.data.models.V0WebhookDeliveryItemResponseModel
import za.co.app.bitrisebuddy.model.data.models.V0WebhookDeliveryItemShowResponseModel

@JvmSuppressWildcards
interface WebhookDeliveryItemApi {
    /**
     * List the webhook delivery items of an app
     * List all the delivery items of an outgoing webhook of a Bitrise application
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param appWebhookSlug App webhook slug (required)
     * @param next Slug of the first delivery item in the response (optional)
     * @param limit Max number of elements per page (default: 50) (optional)
     */
    @Headers(
        "X-Operation-ID: webhook-delivery-item-list"
    )
    @GET("apps/{app-slug}/outgoing-webhooks/{app-webhook-slug}/delivery-items")
    suspend fun webhookDeliveryItemList(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("app-webhook-slug") appWebhookSlug: String,
        @retrofit2.http.Query("next") next: String?,
        @retrofit2.http.Query("limit") limit: Int?
    ): V0WebhookDeliveryItemShowResponseModel
    /**
     * Re-deliver the webhook delivery items of an app
     * Re-deliver the delivery item of a specified webhook of a Bitrise application
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param appWebhookSlug App webhook slug (required)
     * @param webhookDeliveryItemSlug Webhook delivery item slug (required)
     */
    @Headers(
        "X-Operation-ID: webhook-delivery-item-redeliver"
    )
    @POST("apps/{app-slug}/outgoing-webhooks/{app-webhook-slug}/delivery-items/{webhook-delivery-item-slug}/redeliver")
    suspend fun webhookDeliveryItemRedeliver(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("app-webhook-slug") appWebhookSlug: String,
        @retrofit2.http.Path("webhook-delivery-item-slug") webhookDeliveryItemSlug: String
    ): ServiceStandardErrorRespModel
    /**
     * Get a specific delivery item of a webhook
     * Get the specified delivery item of an outgoing webhook of a Bitrise application
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param appWebhookSlug App webhook slug (required)
     * @param webhookDeliveryItemSlug Webhook delivery item slug (required)
     */
    @Headers(
        "X-Operation-ID: webhook-delivery-item-show"
    )
    @GET("apps/{app-slug}/outgoing-webhooks/{app-webhook-slug}/delivery-items/{webhook-delivery-item-slug}")
    suspend fun webhookDeliveryItemShow(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("app-webhook-slug") appWebhookSlug: String,
        @retrofit2.http.Path("webhook-delivery-item-slug") webhookDeliveryItemSlug: String
    ): V0WebhookDeliveryItemResponseModel
}
