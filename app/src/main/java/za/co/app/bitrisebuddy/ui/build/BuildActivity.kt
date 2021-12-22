package za.co.app.bitrisebuddy.ui.build

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import za.co.app.bitrisebuddy.databinding.ActivityBuildBinding
import za.co.app.bitrisebuddy.model.data.models.V0BuildListAllResponseItemModel
import java.net.URL

class BuildActivity : AppCompatActivity() {

    lateinit var binding: ActivityBuildBinding

    companion object {

        private const val EXTRA_BUILD = "EXTRA_BUILD"

        fun getStartIntent(context: Context, build: V0BuildListAllResponseItemModel): Intent {
            return Intent(context, BuildActivity::class.java).also { intent ->
                intent.putExtra(
                    EXTRA_BUILD,
                    build
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuildBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        intent.getParcelableExtra<V0BuildListAllResponseItemModel>(EXTRA_BUILD).also { build ->
            if (build != null) {
                populateBuild(build)
            }
        }
    }

    private fun populateBuild(build: V0BuildListAllResponseItemModel) {
        binding.apply {
            textBranch.text = build.branch
            textBuildTags.text = "${build.stackIdentifier}, ${build.machineTypeId}"
            textStatus.text = build.statusText
            textStartedOn.text = build.startedOnWorkerAt
            textFinishedAt.text = build.finishedAt
            textTriggeredWorkflow.text = build.triggeredWorkflow
            textCommitMessage.text = build.commitMessage
            build.status
            val url = URL(build.repository?.avatarUrl)
            loadAppImage(url)
            buttonAbort.visibility = toggleActionButtons(build)
        }
    }

    private fun loadAppImage(url: URL) {
        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {
                //todo add loading when images are being retreived
                val image = BitmapFactory.decodeStream(url.openStream())
                withContext(Dispatchers.Main) {
                    binding.imageAppIcon.setImageBitmap(image)
                }
            }
        }
    }

    private fun ActivityBuildBinding.toggleActionButtons(build: V0BuildListAllResponseItemModel) =
        if (build.status == BUILD_STATUS.IN_PROGRESS.code) {
            buttonRebuild.visibility = View.GONE
            View.VISIBLE
        } else {
            buttonRebuild.visibility = View.VISIBLE
            View.GONE
        }
}