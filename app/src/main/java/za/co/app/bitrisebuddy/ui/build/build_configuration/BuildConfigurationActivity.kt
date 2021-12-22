package za.co.app.bitrisebuddy.ui.build.build_configuration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import za.co.app.bitrisebuddy.databinding.ActivityBuildConfigurationBinding
import za.co.app.bitrisebuddy.model.data.models.V0BuildResponseItemModel


class BuildConfigurationActivity : AppCompatActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_configuration)
    }*/

    lateinit var binding : ActivityBuildConfigurationBinding


    companion object {
        const val EXTRA_APPS = "EXTRA_APPS"

        @JvmStatic
        fun getStartIntent(context: Context, apps: List<V0BuildResponseItemModel>): Intent {
            with(Intent(context, BuildConfigurationActivity::class.java)) {
                putParcelableArrayListExtra(EXTRA_APPS, apps as ArrayList<out Parcelable>?)
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
        val transactionViewPager = binding.pager
        val transactionTabs = binding.tabLayout
        transactionTabs.setupWithViewPager(transactionViewPager)

        if(builds != null) {
            val availableBranches = builds.map { build -> build.branch  }.groupBy { it ?: "null" }


            val availableWorkflows = builds.map { build -> build.triggeredWorkflow }.groupBy { it ?: "null" }
            transactionViewPager.adapter =
                BuildConfigurationAdapter(availableWorkflows.keys.toList(), availableBranches.keys.toList(), supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)

        }



    }
}