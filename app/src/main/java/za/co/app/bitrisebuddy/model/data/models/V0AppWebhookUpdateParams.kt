/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property events
 * @property headers
 * @property url
 */
@JsonClass(generateAdapter = true)
data class V0AppWebhookUpdateParams(
    @Json(name = "events") @field:Json(name = "events") var events: List<String>,
    @Json(name = "url") @field:Json(name = "url") var url: String,
    @Json(name = "headers") @field:Json(name = "headers") var headers: List<Int>? = null
)
