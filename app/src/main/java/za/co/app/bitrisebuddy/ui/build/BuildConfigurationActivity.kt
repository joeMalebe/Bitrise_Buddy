package za.co.app.bitrisebuddy.ui.build

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import za.co.app.bitrisebuddy.databinding.ActivityBuildConfigurationBinding
import za.co.app.bitrisebuddy.model.data.models.V0AppResponseItemModel
import za.co.app.bitrisebuddy.ui.landing.LandingActivity


class BuildConfigurationActivity : AppCompatActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_configuration)
    }*/

    lateinit var binding : ActivityBuildConfigurationBinding


    companion object {
        const val EXTRA_APPS = "EXTRA_APPS"

        @JvmStatic
        fun getStartIntent(context: Context, apps: List<V0AppResponseItemModel>): Intent {
            with(Intent(context, LandingActivity::class.java)) {
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

        val transactionViewPager = binding.pager
        val transactionTabs = binding.tabLayout
        transactionViewPager.adapter =
            BuildConfigurationAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        transactionTabs.setupWithViewPager(transactionViewPager)

    }
}