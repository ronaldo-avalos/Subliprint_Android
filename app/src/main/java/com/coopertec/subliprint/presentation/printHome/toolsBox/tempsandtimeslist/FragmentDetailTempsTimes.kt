package com.coopertec.subliprint.presentation.printHome.toolsBox.tempsandtimeslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.coopertec.subliprint.R
import com.coopertec.subliprint.databinding.FragmentDetailTempsTimesBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentDetailTempsTimes : Fragment() {

    private var _binding: FragmentDetailTempsTimesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailTempsTimesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDetailTempsTimes_to_fragmentTempsTimesList2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}