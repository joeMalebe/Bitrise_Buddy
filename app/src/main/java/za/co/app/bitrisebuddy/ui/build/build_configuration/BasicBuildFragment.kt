package za.co.app.bitrisebuddy.ui.build.build_configuration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import za.co.app.bitrisebuddy.R
import za.co.app.bitrisebuddy.databinding.FragmentBasicBuildBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BasicBuildFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BasicBuildFragment(private val availableBranches: List<String>, private val availableWorkflows: List<String>) : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentBasicBuildBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBasicBuildBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.spinnerBranches.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, availableBranches)
        binding.spinnerWorkflows.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, availableWorkflows)
    }

    companion object {

        @JvmStatic
        fun newInstance(availableBranches: List<String>) =
            BasicBuildFragment(availableBranches, availableBranches).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}