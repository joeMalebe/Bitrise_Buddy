/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property createdAt
 * @property events
 * @property headers
 * @property registeredByAddon
 * @property slug
 * @property updatedAt
 * @property url
 */
@JsonClass(generateAdapter = true)
data class V0AppWebhookResponseItemModel(
    @Json(name = "created_at") @field:Json(name = "created_at") var createdAt: String? = null,
    @Json(name = "events") @field:Json(name = "events") var events: List<String>? = null,
    @Json(name = "headers") @field:Json(name = "headers") var headers: List<Int>? = null,
    @Json(name = "registered_by_addon") @field:Json(name = "registered_by_addon") var registeredByAddon: Boolean? = null,
    @Json(name = "slug") @field:Json(name = "slug") var slug: String? = null,
    @Json(name = "updated_at") @field:Json(name = "updated_at") var updatedAt: String? = null,
    @Json(name = "url") @field:Json(name = "url") var url: String? = null
)
