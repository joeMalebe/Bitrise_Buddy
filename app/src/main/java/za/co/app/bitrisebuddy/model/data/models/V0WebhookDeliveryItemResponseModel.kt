/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import za.co.app.bitrisebuddy.model.data.models.NullsInt64
import za.co.app.bitrisebuddy.model.data.models.NullsString

/**
 * @property createdAt
 * @property requestHeaders
 * @property requestPayload
 * @property requestUrl
 * @property responseBody
 * @property responseHeaders
 * @property responseHttpStatus
 * @property responseSeconds
 * @property slug
 * @property updatedAt
 */
@JsonClass(generateAdapter = true)
data class V0WebhookDeliveryItemResponseModel(
    @Json(name = "created_at") @field:Json(name = "created_at") var createdAt: String? = null,
    @Json(name = "request_headers") @field:Json(name = "request_headers") var requestHeaders: String? = null,
    @Json(name = "request_payload") @field:Json(name = "request_payload") var requestPayload: String? = null,
    @Json(name = "request_url") @field:Json(name = "request_url") var requestUrl: String? = null,
    @Json(name = "response_body") @field:Json(name = "response_body") var responseBody: NullsString? = null,
    @Json(name = "response_headers") @field:Json(name = "response_headers") var responseHeaders: NullsString? = null,
    @Json(name = "response_http_status") @field:Json(name = "response_http_status") var responseHttpStatus: NullsInt64? = null,
    @Json(name = "response_seconds") @field:Json(name = "response_seconds") var responseSeconds: NullsInt64? = null,
    @Json(name = "slug") @field:Json(name = "slug") var slug: String? = null,
    @Json(name = "updated_at") @field:Json(name = "updated_at") var updatedAt: String? = null
)
