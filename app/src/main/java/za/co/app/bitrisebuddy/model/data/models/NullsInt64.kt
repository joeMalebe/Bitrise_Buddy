/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property int64
 * @property valid Valid is true if Int64 is not NULL
 */
@JsonClass(generateAdapter = true)
data class NullsInt64(
    @Json(name = "int64") @field:Json(name = "int64") var int64: Int? = null,
    @Json(name = "valid") @field:Json(name = "valid") var valid: Boolean? = null
)
