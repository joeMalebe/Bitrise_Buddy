/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package za.co.app.bitrisebuddy.model.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property abortReason
 * @property branch
 * @property buildNumber
 * @property commitHash
 * @property commitMessage
 * @property commitViewUrl
 * @property creditCost
 * @property environmentPrepareFinishedAt
 * @property finishedAt
 * @property isOnHold
 * @property isProcessed
 * @property machineTypeId
 * @property originalBuildParams
 * @property pullRequestId
 * @property pullRequestTargetBranch
 * @property pullRequestViewUrl
 * @property slug
 * @property stackIdentifier
 * @property startedOnWorkerAt
 * @property status
 * @property statusText
 * @property tag
 * @property triggeredAt
 * @property triggeredBy
 * @property triggeredWorkflow
 */
@JsonClass(generateAdapter = true)
data class V0BuildResponseItemModel(
    @Json(name = "abort_reason") @field:Json(name = "abort_reason") var abortReason: String? = null,
    @Json(name = "branch") @field:Json(name = "branch") var branch: String? = null,
    @Json(name = "build_number") @field:Json(name = "build_number") var buildNumber: Int? = null,
    @Json(name = "commit_hash") @field:Json(name = "commit_hash") var commitHash: String? = null,
    @Json(name = "commit_message") @field:Json(name = "commit_message") var commitMessage: String? = null,
    @Json(name = "commit_view_url") @field:Json(name = "commit_view_url") var commitViewUrl: String? = null,
    @Json(name = "credit_cost") @field:Json(name = "credit_cost") var creditCost: NullsInt64? = null,
    @Json(name = "environment_prepare_finished_at") @field:Json(name = "environment_prepare_finished_at") var environmentPrepareFinishedAt: String? = null,
    @Json(name = "finished_at") @field:Json(name = "finished_at") var finishedAt: String? = null,
    @Json(name = "is_on_hold") @field:Json(name = "is_on_hold") var isOnHold: Boolean? = null,
    @Json(name = "is_processed") @field:Json(name = "is_processed") var isProcessed: Boolean? = null,
    @Json(name = "machine_type_id") @field:Json(name = "machine_type_id") var machineTypeId: String? = null,
    //@Json(name = "original_build_params") @field:Json(name = "original_build_params") var originalBuildParams: List<Int>? = null,
    @Json(name = "pull_request_id") @field:Json(name = "pull_request_id") var pullRequestId: Int? = null,
    @Json(name = "pull_request_target_branch") @field:Json(name = "pull_request_target_branch") var pullRequestTargetBranch: String? = null,
    @Json(name = "pull_request_view_url") @field:Json(name = "pull_request_view_url") var pullRequestViewUrl: String? = null,
    @Json(name = "slug") @field:Json(name = "slug") var slug: String? = null,
    @Json(name = "stack_identifier") @field:Json(name = "stack_identifier") var stackIdentifier: String? = null,
    @Json(name = "started_on_worker_at") @field:Json(name = "started_on_worker_at") var startedOnWorkerAt: String? = null,
    @Json(name = "status") @field:Json(name = "status") var status: Int? = null,
    @Json(name = "status_text") @field:Json(name = "status_text") var statusText: String? = null,
    @Json(name = "tag") @field:Json(name = "tag") var tag: String? = null,
    @Json(name = "triggered_at") @field:Json(name = "triggered_at") var triggeredAt: String? = null,
    @Json(name = "triggered_by") @field:Json(name = "triggered_by") var triggeredBy: String? = null,
    @Json(name = "triggered_workflow") @field:Json(name = "triggered_workflow") var triggeredWorkflow: String? = null
)
