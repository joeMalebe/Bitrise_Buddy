package za.co.app.bitrisebuddy.ui.build.build_configuration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import dagger.hilt.android.AndroidEntryPoint
import za.co.app.bitrisebuddy.databinding.ActivityBuildConfigurationBinding
import za.co.app.bitrisebuddy.model.data.models.V0BuildResponseItemModel
import za.co.app.bitrisebuddy.ui.landing.latest_build.BuildsViewModel
import za.co.app.bitrisebuddy.ui.landing.latest_build.BuildsViewState

@AndroidEntryPoint
class BuildConfigurationActivity : AppCompatActivity() {
    lateinit var binding: ActivityBuildConfigurationBinding
    val viewModel: BuildsViewModel by viewModels()

    companion object {
        const val EXTRA_APPS = "EXTRA_APPS"
        const val EXTRA_APP_SLUG = "EXTRA_APP_SLUG"

        @JvmStatic
        fun getStartIntent(context: Context, apps: List<V0BuildResponseItemModel>, appSlug: String?): Intent {
            with(Intent(context, BuildConfigurationActivity::class.java)) {
                putParcelableArrayListExtra(EXTRA_APPS, apps as ArrayList<out Parcelable>?)
                putExtra(EXTRA_APP_SLUG, appSlug)
                return this
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuildConfigurationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val builds = intent.getParcelableArrayListExtra<V0BuildResponseItemModel>(EXTRA_APPS)
        val appSlug = intent.getStringExtra(EXTRA_APP_SLUG)



        if (builds != null && appSlug != null) {
            viewModel.loadWorkflows(appSlug)

            viewModel.viewState.observe(this, { viewState ->
                when (viewState) {
                    is BuildsViewState.WorkflowsLoaded -> {
                        val availableBranches = builds.map { build -> build.branch }.groupBy { it ?: "null" }
                        val availableWorkflows = viewState.workflows.data
                        val transactionViewPager = setupTabs()
                        transactionViewPager.adapter =
                            BuildConfigurationAdapter(
                                availableWorkflows ?: mutableListOf(),
                                availableBranches.keys.toList(),
                                supportFragmentManager,
                                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
                            )
                    }
                    is BuildsViewState.Loading -> {

                    }

                    is Error -> {

                    }
                }
            })
        }
    }

    private fun setupTabs(): ViewPager {
        val transactionViewPager = binding.pager
        val transactionTabs = binding.tabLayout
        transactionTabs.setupWithViewPager(transactionViewPager)
        return transactionViewPager
    }
}