package za.co.app.bitrisebuddy.ui.build.build_configuration

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

private const val BASIC_TAB = 0
private const val ADVANCED_BUILDS = 1
private const val NUMBER_OF_PAGES = 2

class BuildConfigurationAdapter(
    val availableWorkflows: List<String>,
    val availableBranches: List<String>,
    fragmentManager: FragmentManager,
    behavior: Int
) : FragmentPagerAdapter(fragmentManager, behavior) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            BASIC_TAB -> BasicBuildFragment(availableWorkflows ,availableBranches)
            ADVANCED_BUILDS -> BasicBuildFragment(availableWorkflows ,availableBranches)
            else -> {
                throw Throwable("Position $position is invalid")
            }
        }
    }

    override fun getCount() = NUMBER_OF_PAGES

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            BASIC_TAB -> "Basic"
            ADVANCED_BUILDS -> "Advanced"
            else -> {
                throw Throwable("Position $position is invalid")
            }
        }
    }
}
