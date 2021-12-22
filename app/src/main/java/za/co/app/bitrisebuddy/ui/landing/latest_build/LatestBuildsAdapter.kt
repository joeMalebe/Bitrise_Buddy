package za.co.app.bitrisebuddy.ui.landing.latest_build

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import za.co.app.bitrisebuddy.databinding.ItemBuildBinding
import za.co.app.bitrisebuddy.model.data.models.V0BuildListAllResponseItemModel
import za.co.app.bitrisebuddy.ui.build.BuildActivity

class LatestBuildsAdapter(private val builds: List<V0BuildListAllResponseItemModel>) :
    RecyclerView.Adapter<LatestBuildsAdapter.LatestBuildsViewHolder>() {

    inner class LatestBuildsViewHolder(private val binding: ItemBuildBinding) : RecyclerView.ViewHolder(binding.root) {

        fun display(build: V0BuildListAllResponseItemModel) {
            binding.textAppTitle.text = build.repository?.title
            binding.textBranch.text = build.branch
            binding.textCommitMessage.text = build.commitMessage
            binding.textTriggeredWorkflow.text = build.triggeredWorkflow
            binding.root.setOnClickListener {
                it.context.startActivity(BuildActivity.getStartIntent(it.context, build))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestBuildsViewHolder {
        val binding = ItemBuildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LatestBuildsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestBuildsViewHolder, position: Int) {
        holder.display(builds[position])
    }

    override fun getItemCount() = builds.size

}
