package com.example.countrysearch.app.detail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countrysearch.R
import com.example.countrysearch.app.detail.viewmodel.CountriesDetailViewModel
import com.example.countrysearch.databinding.FragmentCountriesBinding
import com.example.countrysearch.databinding.FragmentCountryDetailBinding

class CountriesDetailFragment : Fragment() {

    private lateinit var viewModel: CountriesDetailViewModel
    private var _binding:FragmentCountryDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }


}