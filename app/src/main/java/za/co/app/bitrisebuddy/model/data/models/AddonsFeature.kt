/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property available
 * @property description
 * @property quantity
 */
@JsonClass(generateAdapter = true)
data class AddonsFeature(
    @Json(name = "available") @field:Json(name = "available") var available: Boolean? = null,
    @Json(name = "description") @field:Json(name = "description") var description: String? = null,
    @Json(name = "quantity") @field:Json(name = "quantity") var quantity: String? = null
)
