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
 * @property paging pagination
 */
@JsonClass(generateAdapter = true)
data class V0ProjectFileStorageListResponseModel(
    @Json(name = "data") @field:Json(name = "data") var `data`: List<V0ProjectFileStorageResponseItemModel>? = null,
    @Json(name = "paging") @field:Json(name = "paging") var paging: V0PagingResponseModel? = null
)
