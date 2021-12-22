package za.co.app.bitrisebuddy.ui.build.build_configuration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import za.co.app.bitrisebuddy.R
import za.co.app.bitrisebuddy.databinding.FragmentBasicBuildBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BasicBuildFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BasicBuildFragment(private val availableBranches: List<String>, private val availableWorkflows: List<String>) : Fragment() {
    // TODO: Rename and change types of parameters
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BasicBuild.
         */
        // TODO: Rename and change types and number of parameters
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