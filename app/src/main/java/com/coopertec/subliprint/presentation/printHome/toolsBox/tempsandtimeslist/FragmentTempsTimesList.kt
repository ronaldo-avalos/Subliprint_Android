package com.coopertec.subliprint.presentation.printHome.toolsBox.tempsandtimeslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coopertec.subliprint.R
import com.coopertec.subliprint.databinding.FragmentTempsTimesLististBinding
import com.coopertec.subliprint.databinding.ItemTempsTimesBinding
import com.coopertec.subliprint.presentation.printHome.toolsBox.tempsandtimeslist.model.TempsTimesItem

class FragmentTempsTimesList : Fragment() {

    private var _binding: FragmentTempsTimesLististBinding? = null
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
        val items = listOf(
            TempsTimesItem(12, R.drawable.product_taza_img, "Tazas", "180ºC", "120/60 seg", "Moderada"),
            TempsTimesItem(13,R.drawable.product_cap_img, "Gorras", "180ºC", "120/60 seg", "Moderada"),
            TempsTimesItem(13,R.drawable.product_cap_img, "Gorras", "180ºC", "120/60 seg", "Moderada"),
            TempsTimesItem(13,R.drawable.product_cap_img, "Gorras", "180ºC", "120/60 seg", "Moderada"),
            TempsTimesItem(13,R.drawable.product_cap_img, "Gorras", "180ºC", "120/60 seg", "Moderada"),
            TempsTimesItem(13,R.drawable.product_cap_img, "Gorras", "180ºC", "120/60 seg", "Moderada"),
            TempsTimesItem(13,R.drawable.product_cap_img, "Gorras", "180ºC", "120/60 seg", "Moderada"),
            TempsTimesItem(13,R.drawable.product_cap_img, "Gorras", "180ºC", "120/60 seg", "Moderada"),
        )

        val adapter = TempsTimesAdapter(items,this)
        binding.recyclerViewTempsTimes.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTempsTimes.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class TempsTimesAdapter(private val items: List<TempsTimesItem>, val fragment:FragmentTempsTimesList) : RecyclerView.Adapter<TempsTimesAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemTempsTimesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTempsTimesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            imageViewProduct.setImageResource(item.imageResId)
            titleItem.text = item.title
            tempItemText.text = item.temperature
            timeItemText.text = item.time
            pressureItemText.text = item.pressure
        }.itemCard.setOnClickListener {
            findNavController(fragment).navigate(
                FragmentTempsTimesListDirections.actionFragmentTempsTimesList2ToFragmentDetailTempsTimes(item.id)
            )
        }
    }
    override fun getItemCount(): Int = items.size
}
