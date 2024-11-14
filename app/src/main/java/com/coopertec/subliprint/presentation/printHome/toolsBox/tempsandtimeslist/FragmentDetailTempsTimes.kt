package com.coopertec.subliprint.presentation.printHome.toolsBox.tempsandtimeslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.coopertec.subliprint.R
import com.coopertec.subliprint.databinding.FragmentDetailTempsTimesBinding
import kotlin.concurrent.fixedRateTimer

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentDetailTempsTimes : Fragment() {

    private var _binding: FragmentDetailTempsTimesBinding? = null
    private val args: FragmentDetailTempsTimesArgs by navArgs()
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
       val productID = args.productID
        getProductById()
    }

    private fun getProductById() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}