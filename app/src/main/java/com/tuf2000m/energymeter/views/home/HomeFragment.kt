package com.tuf2000m.energymeter.views.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.tuf2000m.energymeter.R
import com.tuf2000m.energymeter.databinding.FragmentTabsBinding
import com.tuf2000m.energymeter.utils.SharedPreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentTabsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sharedPreferences: SharedPreferenceManager
    private lateinit var animalsArray : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animalsArray = arrayOf(
            getString(R.string.latestReading),
            getString(R.string.recentHistory)
        )

        setTabs()
        setupLogoutButton()
    }

    /**
     * Sets up the tabs in the UI using a ViewPager and TabLayout.
     */
    private fun setTabs() {
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)

        viewPager.adapter = adapter
        // Attach the TabLayout with the ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = animalsArray[position]
        }.attach()
    }

    /**
     * Sets up the logout button to handle logout logic.
     */
    private fun setupLogoutButton() {
        // Handle logout button click
        binding.imageLogout.setOnClickListener {
            // Clear data and navigate back to previous screen
            sharedPreferences.clearData()
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
