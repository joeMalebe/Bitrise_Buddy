package za.co.app.bitrisebuddy.ui.landing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import dagger.hilt.android.AndroidEntryPoint
import za.co.app.bitrisebuddy.databinding.ActivityLandingBinding
import za.co.app.bitrisebuddy.model.data.models.V0AppResponseItemModel
import za.co.app.bitrisebuddy.ui.landing.apps.AppsViewModel

@AndroidEntryPoint
class LandingActivity : AppCompatActivity() {

    val viewModel: AppsViewModel by viewModels()
    lateinit var binding: ActivityLandingBinding

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
        binding = ActivityLandingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val transactionViewPager = binding.pager
        val transactionTabs = binding.tabLayout
        transactionViewPager.adapter =
            LandingPageAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        transactionTabs.setupWithViewPager(transactionViewPager)

    }
}