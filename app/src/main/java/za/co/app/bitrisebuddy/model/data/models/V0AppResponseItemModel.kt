/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * @property avatarUrl
 * @property isDisabled
 * @property isPublic
 * @property owner
 * @property projectType
 * @property provider
 * @property repoOwner
 * @property repoSlug
 * @property repoUrl
 * @property slug
 * @property status
 * @property title
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class V0AppResponseItemModel(
    @Json(name = "avatar_url") @field:Json(name = "avatar_url") var avatarUrl: String? = null,
    @Json(name = "is_disabled") @field:Json(name = "is_disabled") var isDisabled: Boolean? = null,
    @Json(name = "is_public") @field:Json(name = "is_public") var isPublic: Boolean? = null,
    @Json(name = "owner") @field:Json(name = "owner") var owner: V0OwnerAccountResponseModel? = null,
    @Json(name = "project_type") @field:Json(name = "project_type") var projectType: String? = null,
    @Json(name = "provider") @field:Json(name = "provider") var provider: String? = null,
    @Json(name = "repo_owner") @field:Json(name = "repo_owner") var repoOwner: String? = null,
    @Json(name = "repo_slug") @field:Json(name = "repo_slug") var repoSlug: String? = null,
    @Json(name = "repo_url") @field:Json(name = "repo_url") var repoUrl: String? = null,
    @Json(name = "slug") @field:Json(name = "slug") var slug: String? = null,
    @Json(name = "status") @field:Json(name = "status") var status: Int? = null,
    @Json(name = "title") @field:Json(name = "title") var title: String? = null
) : Parcelable
