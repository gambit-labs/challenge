package com.tuf2000m.energymeter.views.home.latest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.tuf2000m.energymeter.data.remote.NetworkResult
import com.tuf2000m.energymeter.data.model.meterdata.TimeStamp
import com.tuf2000m.energymeter.databinding.FragmentLatestBinding
import com.tuf2000m.energymeter.utils.Constant
import com.tuf2000m.energymeter.views.home.recenthistory.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LatestReadingFragment : Fragment() {
    private var _binding: FragmentLatestBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LatestReadingViewModel by activityViewModels()
    private var currentIndex = 0
    private var timeStamps = mutableListOf<TimeStamp>()
    private lateinit var latestReadingAdapter: LatestReadingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLatestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupUI()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTimeStamps()
    }

    /**
     * Sets up UI event handling for buttons and input fields.
     */
    private fun setupUI() {
        binding.imageView.setOnClickListener {
            handleNextButtonClick()
        }

        binding.appCompatEditText.doOnTextChanged { text, _, _, _ ->
            handleSearchTextChange(text)
        }
    }

    /**
     * Handles the logic when the user clicks the "Next" button to display the next set of data.
     */
    private fun handleNextButtonClick() {
        if (currentIndex < timeStamps.size - 1) {
            currentIndex += 1
            binding.tvTimespam.text =
                Constant.TimeFormatter.convertUTCFormat(timeStamps[currentIndex].timeStamp)
            latestReadingAdapter.setContentData(timeStamps[currentIndex].data)

        } else {
            Toast.makeText(context, "No More Records", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Handles changes in the search text input.
     *
     * If the search text is blank or null, it resets the current index and displays the initial data.
     * If there's a non-blank search text, it triggers a search using the ViewModel.
     *
     * @param text The search text input.
     */
    private fun handleSearchTextChange(text: CharSequence?) {
        if (text.isNullOrBlank()) {
            currentIndex = 0
            latestReadingAdapter.setContentData(timeStamps[currentIndex].data)
        } else {
            viewModel.searchData(timeStamps, text.toString())
        }
    }

    /**
     * Sets up observers for LiveData to update UI based on ViewModel updates.
     */
    private fun setupObservers() {
        viewModel.meterData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is NetworkResult.Failure -> {
                    Toast.makeText(requireContext(), result.errorMessage, Toast.LENGTH_SHORT).show()
                }

                is NetworkResult.Loading -> {
                    // Handle loading here
                }

                is NetworkResult.Success -> {
                    result.data.let {
                        timeStamps.addAll(it.timeStamp)
                        setRecyclerData()
                    }
                }
            }
        }

        viewModel.searchData.observe(viewLifecycleOwner) {
            it?.let {
                latestReadingAdapter.setContentData(it)
            }
        }
    }

    private fun setRecyclerData() {
        if (timeStamps.isNotEmpty()) {
            binding.tvTimespam.text =
                Constant.TimeFormatter.convertUTCFormat(timeStamps[currentIndex].timeStamp)
            latestReadingAdapter = LatestReadingAdapter(timeStamps[currentIndex].data, object : OnItemClickListener {
                override fun onItemClick(position: Int) {
                    // Handle item click
                }
            })
            binding.rvLatest.adapter = latestReadingAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
