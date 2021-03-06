/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property certificatePassword
 * @property downloadUrl
 * @property isExpose
 * @property isProtected
 * @property processed
 * @property slug
 * @property uploadFileName
 * @property uploadFileSize
 * @property uploadUrl
 */
@JsonClass(generateAdapter = true)
data class V0BuildCertificateResponseItemModel(
    @Json(name = "certificate_password") @field:Json(name = "certificate_password") var certificatePassword: String? = null,
    @Json(name = "download_url") @field:Json(name = "download_url") var downloadUrl: String? = null,
    @Json(name = "is_expose") @field:Json(name = "is_expose") var isExpose: Boolean? = null,
    @Json(name = "is_protected") @field:Json(name = "is_protected") var isProtected: Boolean? = null,
    @Json(name = "processed") @field:Json(name = "processed") var processed: Boolean? = null,
    @Json(name = "slug") @field:Json(name = "slug") var slug: String? = null,
    @Json(name = "upload_file_name") @field:Json(name = "upload_file_name") var uploadFileName: String? = null,
    @Json(name = "upload_file_size") @field:Json(name = "upload_file_size") var uploadFileSize: Int? = null,
    @Json(name = "upload_url") @field:Json(name = "upload_url") var uploadUrl: String? = null
)
