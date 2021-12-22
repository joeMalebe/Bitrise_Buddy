/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property description
 * @property documentationUrl
 * @property hasUi
 * @property icon
 * @property id
 * @property isBeta
 * @property isEnabled
 * @property loginUrl
 * @property plan
 * @property scopes
 * @property setupGuide
 * @property summary
 * @property termsUrl
 * @property title
 */
@JsonClass(generateAdapter = true)
data class V0AppAddOnResponseItemModel(
    @Json(name = "description") @field:Json(name = "description") var description: String? = null,
    @Json(name = "documentation_url") @field:Json(name = "documentation_url") var documentationUrl: String? = null,
    @Json(name = "has_ui") @field:Json(name = "has_ui") var hasUi: Boolean? = null,
    @Json(name = "icon") @field:Json(name = "icon") var icon: String? = null,
    @Json(name = "id") @field:Json(name = "id") var id: String? = null,
    @Json(name = "is_beta") @field:Json(name = "is_beta") var isBeta: Boolean? = null,
    @Json(name = "is_enabled") @field:Json(name = "is_enabled") var isEnabled: Boolean? = null,
    @Json(name = "login_url") @field:Json(name = "login_url") var loginUrl: String? = null,
    @Json(name = "plan") @field:Json(name = "plan") var plan: AddonsPlan? = null,
    @Json(name = "scopes") @field:Json(name = "scopes") var scopes: List<String>? = null,
    @Json(name = "setup_guide") @field:Json(name = "setup_guide") var setupGuide: AddonsSetupGuide? = null,
    @Json(name = "summary") @field:Json(name = "summary") var summary: String? = null,
    @Json(name = "terms_url") @field:Json(name = "terms_url") var termsUrl: String? = null,
    @Json(name = "title") @field:Json(name = "title") var title: String? = null
)