/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property config Which config to use &#x60;default-android-config&#x60;, &#x60;default-cordova-config&#x60;, &#x60;default-fastlane-config&#x60;, &#x60;default-ionic-config&#x60;, &#x60;default-ios-config&#x60;,&#x60;default-macos-config&#x60;, &#x60;default-react-native-config&#x60;, &#x60;default-xamarin-config&#x60;, &#x60;other-config&#x60; (default if parameter is not speficied)
 * @property envs Environment variables for the application workflows, e.g. {\&quot;env1\&quot;:\&quot;val1\&quot;,\&quot;env2\&quot;:\&quot;val2\&quot;}
 * @property mode config specification mode, has to be specified with &#x60;manual&#x60; value
 * @property organizationSlug The slug of the organization, who will be the owner of the application, if it&#39;s not specified, then the authenticated user will be the owner
 * @property projectType The type of your project (&#x60;android&#x60;, &#x60;ios&#x60;, &#x60;cordova&#x60;, &#x60;other&#x60;, &#x60;xamarin&#x60;, &#x60;macos&#x60;, &#x60;ionic&#x60;, &#x60;react-native&#x60;, &#x60;fastlane&#x60;, null)
 * @property stackId The id of the stack the application will be built (these can be found in the [system report](https://github.com/bitrise-io/bitrise.io/tree/master/system_reports) file names)
 */
@JsonClass(generateAdapter = true)
data class V0AppFinishParams(
    @Json(name = "project_type") @field:Json(name = "project_type") var projectType: String,
    @Json(name = "stack_id") @field:Json(name = "stack_id") var stackId: String,
    @Json(name = "config") @field:Json(name = "config") var config: String? = null,
    @Json(name = "envs") @field:Json(name = "envs") var envs: Map<String, String>? = null,
    @Json(name = "mode") @field:Json(name = "mode") var mode: String? = null,
    @Json(name = "organization_slug") @field:Json(name = "organization_slug") var organizationSlug: String? = null
)