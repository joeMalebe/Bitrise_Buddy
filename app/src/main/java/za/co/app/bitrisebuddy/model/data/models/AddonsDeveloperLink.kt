/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property title
 * @property url
 */
@JsonClass(generateAdapter = true)
data class AddonsDeveloperLink(
    @Json(name = "title") @field:Json(name = "title") var title: String? = null,
    @Json(name = "url") @field:Json(name = "url") var url: String? = null
)
