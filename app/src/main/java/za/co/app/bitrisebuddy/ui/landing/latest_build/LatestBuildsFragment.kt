package za.co.app.bitrisebuddy.ui.landing.latest_build

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import za.co.app.bitrisebuddy.databinding.LayoutLatestBuildsBinding

class LatestBuildsFragment : Fragment() {

    lateinit var binding: LayoutLatestBuildsBinding
    val viewModel: BuildsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutLatestBuildsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, { viewState ->
            when (viewState) {
                is BuildsViewState.Loading -> {

                }
                is BuildsViewState.Error -> {

                }
                is BuildsViewState.AuthenticationError -> {

                }

                is BuildsViewState.BuildsLoaded -> {
                    binding.recyclerBuilds.layoutManager = LinearLayoutManager(context)
                    binding.recyclerBuilds.adapter = LatestBuildsAdapter(viewState.builds)
                }

            }
        })

        viewModel.loadAllBuilds()

    }


}