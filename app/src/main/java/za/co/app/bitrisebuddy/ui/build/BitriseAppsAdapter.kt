package za.co.app.bitrisebuddy.ui.build

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import za.co.app.bitrisebuddy.databinding.ItemAppBuildBinding
import za.co.app.bitrisebuddy.model.data.models.V0BuildResponseItemModel

class BitriseAppsAdapter(val builds: List<V0BuildResponseItemModel>) :
    RecyclerView.Adapter<BitriseAppsAdapter.AppViewHolder>() {

    lateinit var binding: ItemAppBuildBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        binding = ItemAppBuildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.display(builds[position])
    }

    override fun getItemCount() = builds.size

    inner class AppViewHolder(val binding: ItemAppBuildBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun display(build: V0BuildResponseItemModel) {
            binding.textBranch.text = build.branch
            binding.textCommitMessage.text = build.commitMessage
            binding.textTriggeredWorkflow.text = build.triggeredWorkflow
        }
    }
}