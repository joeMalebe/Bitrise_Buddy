/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property containerCount
 * @property expiresAt
 * @property id
 * @property name
 * @property price
 */
@JsonClass(generateAdapter = true)
data class V0PlanDataModel(
    @Json(name = "container_count") @field:Json(name = "container_count") var containerCount: Int? = null,
    @Json(name = "expires_at") @field:Json(name = "expires_at") var expiresAt: String? = null,
    @Json(name = "id") @field:Json(name = "id") var id: String? = null,
    @Json(name = "name") @field:Json(name = "name") var name: String? = null,
    @Json(name = "price") @field:Json(name = "price") var price: NullsInt64? = null
)
