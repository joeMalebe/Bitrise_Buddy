/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property `data`
 */
@JsonClass(generateAdapter = true)
data class V0OrganizationRespModel(
    @Json(name = "data") @field:Json(name = "data") var `data`: V0OrganizationDataModel? = null
)
