/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property added
 * @property modified
 * @property removed
 */
@JsonClass(generateAdapter = true)
data class V0CommitPaths(
    @Json(name = "added") @field:Json(name = "added") var added: List<String>? = null,
    @Json(name = "modified") @field:Json(name = "modified") var modified: List<String>? = null,
    @Json(name = "removed") @field:Json(name = "removed") var removed: List<String>? = null
)
