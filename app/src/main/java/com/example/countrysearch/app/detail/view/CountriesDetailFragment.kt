package com.example.countrysearch.app.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.countrysearch.R
import com.example.countrysearch.databinding.FragmentCountryDetailBinding
import com.squareup.picasso.Picasso

class CountriesDetailFragment : Fragment() {

    private var _binding:FragmentCountryDetailBinding? = null
    private val binding get() = _binding!!

    private val args: CountriesDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Picasso.get().load(args.flag).into(binding.ivFlag)
        binding.tvCapital.text=getString(R.string.text_capital,args.capital)
        binding.tvName.text=getString(R.string.Text_name,args.name)
        binding.tvBorders.text=getString(R.string.text_borders, args.borders)
        binding.tbDetail.navigationIcon = ContextCompat.getDrawable(requireContext(),
            R.drawable.ic_back_button)
        binding.tvRegion.text=getString(R.string.text_region,args.region)
        binding.tbDetail.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }



}