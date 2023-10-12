package com.tuf2000m.energymeter.views.home.recenthistory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.tuf2000m.energymeter.data.model.recent.RecentData
import com.tuf2000m.energymeter.data.remote.NetworkResult
import com.tuf2000m.energymeter.databinding.FragmentRecentBinding
import com.tuf2000m.energymeter.views.home.latest.LatestReadingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentHistoryFragment : Fragment() {

    private var _binding: FragmentRecentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LatestReadingViewModel by activityViewModels()
    private lateinit var recentAdapter: RecentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe recent data to update UI accordingly
        observeRecentData()
    }

    /**
     * Observes recent data and updates the UI accordingly.
     */
    private fun observeRecentData() {
        viewModel.recentData.observe(viewLifecycleOwner) { result ->
            when (result) {
                // Handle network failure and loading states if needed...

                is NetworkResult.Success -> {
                    // Set recycler data with the recent list from the result
                    setRecyclerData(result.data.recentList)
                }

                else -> { /* Handle other cases if needed */
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        // Request recent data from the ViewModel
        viewModel.getRecent()
    }

    /**
     * Sets the recycler data based on the provided recent list.
     *
     * @param recentDataList The list of recent items.
     */
    private fun setRecyclerData(recentDataList: List<RecentData.RecentList>) {
        if (recentDataList.isNotEmpty()) {
            recentAdapter = RecentAdapter(recentDataList, object : OnItemClickListener {
                override fun onItemClick(position: Int) {
                    // Handle item click if needed
                }
            })
            binding.rvRecent.adapter = recentAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Clean up the binding instance
        _binding = null
    }
}
