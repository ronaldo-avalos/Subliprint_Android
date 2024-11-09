package com.coopertec.subliprint.presentation.printHome.mainScreen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coopertec.subliprint.presentation.printHome.iaTools.GraphicEditingActivity
import com.coopertec.subliprint.databinding.FragmentPrintHomeBinding
import com.coopertec.subliprint.presentation.printHome.toolsBox.tempsandtimeslist.TempsAndTimesActivity

class PrintHomeFragment : Fragment() {
    private var _binding: FragmentPrintHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrintHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.generateImageButton.setOnClickListener {
            val intent = Intent(requireContext(), GraphicEditingActivity::class.java)
            requireActivity().startActivity(intent)
        }
        binding.tempsTimesListCard.setOnClickListener {
            val intent = Intent(requireContext(), TempsAndTimesActivity::class.java)
            requireActivity().startActivity(intent)
        }
    }

}