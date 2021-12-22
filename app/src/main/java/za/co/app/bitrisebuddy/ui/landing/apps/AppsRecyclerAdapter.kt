package za.co.app.bitrisebuddy.ui.landing.apps

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import za.co.app.bitrisebuddy.databinding.ItemAppBinding
import za.co.app.bitrisebuddy.model.data.models.V0AppResponseItemModel
import java.net.URL

class AppsRecyclerAdapter(
    val apps: List<V0AppResponseItemModel>,
    val clickListener: (appSlug: String, appTitle: String) -> Unit
) :
    RecyclerView.Adapter<AppsRecyclerAdapter.AppsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AppsRecyclerAdapter.AppsViewHolder {
        val binding = ItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppsViewHolder(binding)
    }

    inner class AppsViewHolder(val binding: ItemAppBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun display(
            app: V0AppResponseItemModel,
            clickListener: (appSlug: String, appTitle: String) -> Unit
        ) {
            if (app.slug != null) {
                binding.root.setOnClickListener { clickListener(app.slug!!, app.title ?: "App") }
            }
            binding.textAppName.setText(app.title)
            val url = URL(app.avatarUrl)
            CoroutineScope(IO).launch {
                kotlin.runCatching {
                    //todo add loading when images are being retreived
                    val image = BitmapFactory.decodeStream(url.openStream())
                    withContext(Main) {
                        binding.imageAppIcon.setImageBitmap(image)
                    }
                }

            }
        }
    }

    override fun onBindViewHolder(holder: AppsRecyclerAdapter.AppsViewHolder, position: Int) {

        holder.display(apps[position], clickListener)
    }

    override fun getItemCount(): Int {
        return apps.size
    }

}
