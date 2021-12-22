package za.co.app.bitrisebuddy.ui.landing.apps

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import za.co.app.bitrisebuddy.R
import za.co.app.bitrisebuddy.databinding.LayoutAppsBinding
import za.co.app.bitrisebuddy.ui.build.BitriseAppsActivity

class AppsFragment : Fragment(R.layout.layout_apps) {
    lateinit var binding: LayoutAppsBinding

    val viewModel: AppsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutAppsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, {
            when (it) {
                is AppsViewState.Loading -> {
                    Log.d("AppsFragment", "Loading")
                }
                is AppsViewState.Error -> {
                    Log.d("AppsFragment", "Error : ${it.message}")
                }
                is AppsViewState.AuthenticationError -> {
                    Log.d("AppsFragment", "Auth Error")
                }
                is AppsViewState.AppsLoaded -> {
                    Log.d("AppsFragment", "Success : ${it.toString()}")
                    binding.recyclerApps.layoutManager = LinearLayoutManager(activity)
                    binding.recyclerApps.adapter = AppsRecyclerAdapter(
                        it.apps,
                        ({ appSlug, appTitle ->
                            startActivity(
                                BitriseAppsActivity.getStartIntent(
                                    this.context,
                                    appSlug,
                                    appTitle
                                )
                            )
                        })
                    )
                }
            }

        })
    }
}