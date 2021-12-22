/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property string
 * @property valid Valid is true if String is not NULL
 */
@JsonClass(generateAdapter = true)
data class NullsString(
    @Json(name = "string") @field:Json(name = "string") var string: String? = null,
    @Json(name = "valid") @field:Json(name = "valid") var valid: Boolean? = null
)
