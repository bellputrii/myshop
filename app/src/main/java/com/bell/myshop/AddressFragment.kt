package com.bell.myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bell.myshop.R
import com.bell.myshop.databinding.FragmentAddressBinding
import androidx.navigation.fragment.findNavController


class AddressFragment : Fragment() {
    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val provinces =
                resources.getStringArray(R.array.provinces)
            val adapterProvinces = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, provinces
            )

            adapterProvinces.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )
            spinnerProvinces.adapter = adapterProvinces
            btnDone.setOnClickListener {
                findNavController().apply {
                    previousBackStackEntry
                        ?.savedStateHandle?.set("address",
                            spinnerProvinces.selectedItem.toString())
                }.navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}