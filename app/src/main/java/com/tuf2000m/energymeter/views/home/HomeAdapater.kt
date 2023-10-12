package com.tuf2000m.energymeter.views.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tuf2000m.energymeter.views.home.latest.LatestReadingFragment
import com.tuf2000m.energymeter.views.home.recenthistory.RecentHistoryFragment


/**
 * The ViewPagerAdapter for managing fragments in a ViewPager.
 *
 * @param fragmentManager The fragment manager.
 * @param lifecycle The lifecycle.
 */

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val numOfTabs = 2

    /**
     * Get the number of tabs.
     *
     * @return The number of tabs.
     */
    override fun getItemCount(): Int {
        return numOfTabs
    }

    /**
     * Create a fragment based on the position.
     *
     * @param position The position of the fragment.
     * @return The corresponding fragment.
     */
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LatestReadingFragment()
            else -> RecentHistoryFragment()
        }
    }
}
