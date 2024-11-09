package com.coopertec.subliprint.presentation.printHome.toolsBox.tempsandtimeslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.coopertec.subliprint.R
import com.coopertec.subliprint.databinding.FragmentTempsTimesLististBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FragmentTempsTimesList : Fragment() {

    private var _binding: FragmentTempsTimesLististBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTempsTimesLististBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentTempsTimesList2_to_fragmentDetailTempsTimes)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}