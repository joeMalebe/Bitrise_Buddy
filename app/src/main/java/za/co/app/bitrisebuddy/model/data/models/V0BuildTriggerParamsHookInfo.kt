/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property type Should be \&quot;bitrise\&quot;
 */
@JsonClass(generateAdapter = true)
data class V0BuildTriggerParamsHookInfo(
    @Json(name = "type") @field:Json(name = "type") var type: String? = null
)