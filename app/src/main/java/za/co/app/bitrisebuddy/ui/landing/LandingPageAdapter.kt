package za.co.app.bitrisebuddy.ui.landing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import za.co.app.bitrisebuddy.ui.landing.apps.AppsFragment
import za.co.app.bitrisebuddy.ui.landing.latest_build.LatestBuildsFragment

private const val APPS_TAB = 0
private const val LATEST_BUILDS = 1
private const val NUMBER_OF_PAGES = 2

class LandingPageAdapter(fragmentManager: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fragmentManager, behavior) {
    override fun getCount(): Int {
        return NUMBER_OF_PAGES
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            APPS_TAB -> AppsFragment()
            LATEST_BUILDS -> LatestBuildsFragment()
            else -> {
                throw Throwable("Position $position is invalid")
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            APPS_TAB -> "Apps"
            LATEST_BUILDS -> "Latest builds"
            else -> {
                throw Throwable("Position $position is invalid")
            }
        }
    }
}