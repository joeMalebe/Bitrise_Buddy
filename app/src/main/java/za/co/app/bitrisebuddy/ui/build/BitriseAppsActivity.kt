package za.co.app.bitrisebuddy.ui.build

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import za.co.app.bitrisebuddy.databinding.ActivityBitriseAppsBinding
import za.co.app.bitrisebuddy.ui.landing.latest_build.BuildsViewModel
import za.co.app.bitrisebuddy.ui.landing.latest_build.BuildsViewState.*

@AndroidEntryPoint
class BitriseAppsActivity : AppCompatActivity() {

    lateinit var binding: ActivityBitriseAppsBinding
    val viewModel: BuildsViewModel by viewModels()

    companion object {
        const val EXTRA_APP_SLUG = "EXTRA_APP_SLUG"
        const val EXTRA_APP_TITLE = "EXTRA_APP_TITLE"
        fun getStartIntent(context: Context?, appSlug: String, title: String?): Intent {
            return Intent(context, BitriseAppsActivity::class.java).also {
                it.putExtra(
                    EXTRA_APP_SLUG,
                    appSlug
                )
                it.putExtra(EXTRA_APP_TITLE, title)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBitriseAppsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(intent.hasExtra(EXTRA_APP_TITLE)) {
            binding.pageHeader.textTitle.text = intent.getStringExtra(EXTRA_APP_TITLE)

        }
        if (intent.hasExtra(EXTRA_APP_SLUG)) {
            val appSlug = intent.getStringExtra(EXTRA_APP_SLUG)
            viewModel.loadAppBuilds(appSlug ?: "")

            viewModel.viewState.observe(this, { viewState ->
            when (viewState) {
                    is Error -> {

                    }
                    is AppBuildsLoaded -> {
                        binding.pageHeader.buttonStartBuild.setOnClickListener {
                            startActivity(BuildConfigurationActivity.getStartIntent(this, viewState.builds))
                        }
                        binding.recyclerBuilds.adapter = BitriseAppsAdapter(viewState.builds)
                        binding.recyclerBuilds.layoutManager = LinearLayoutManager(this)
                    }
                    is Loading -> {

                    }
                }
            })
        }
    }
}