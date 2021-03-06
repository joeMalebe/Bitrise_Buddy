/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property filename
 * @property filesize
 * @property slug
 * @property uploadUrl
 */
@JsonClass(generateAdapter = true)
data class V0AvatarCandidateCreateResponseItem(
    @Json(name = "filename") @field:Json(name = "filename") var filename: String? = null,
    @Json(name = "filesize") @field:Json(name = "filesize") var filesize: Int? = null,
    @Json(name = "slug") @field:Json(name = "slug") var slug: String? = null,
    @Json(name = "upload_url") @field:Json(name = "upload_url") var uploadUrl: String? = null
)
