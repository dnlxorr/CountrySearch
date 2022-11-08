package com.example.countrysearch.app.list.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.countrysearch.R
import com.example.countrysearch.app.list.data.remote.CountriesRemoteRepository
import com.example.countrysearch.app.list.data.remote.GetCountriesDataSource
import com.example.countrysearch.app.list.domain.usecase.GetCountries
import com.example.countrysearch.app.list.view.adapter.CountriesAdapter
import com.example.countrysearch.app.list.view.adapter.viewmodels.CountryViewModel
import com.example.countrysearch.app.list.viewmodel.CountriesViewModel
import com.example.countrysearch.databinding.FragmentCountriesBinding
import kotlinx.coroutines.*

class CountriesFragment : Fragment() {

    private lateinit var viewModel: CountriesViewModel
    private var _binding:FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCountriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel =
            CountriesViewModel(GetCountries(CountriesRemoteRepository(GetCountriesDataSource())))
        coroutineScope.launch(Dispatchers.IO) {
            val data = viewModel.getData()
            val adapter = CountriesAdapter { model ->
                val country = (model as CountryViewModel).country
                Log.d("TAG", "onViewCreated: " + country.name)
                val borders = country.borders ?: emptyList()
                val directions =
                    CountriesFragmentDirections.actionCountriesFragmentToCountriesDetailFragment(
                        country.flag, country.capital,TextUtils.join(",", borders), country.name, country.region
                    )
                goTo(directions, R.id.action_countriesFragment_to_countriesDetailFragment)
            }.apply {
                addItems(data)
            }

            binding.etFilter.addTextChangedListener { filterText ->
              (binding.rvCountries.adapter as CountriesAdapter).filterCountries().filter(filterText.toString())
            }

            withContext(Dispatchers.Main){
                binding.rvCountries.adapter = adapter
                binding.progressBar.visibility=View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.coroutineContext.cancelChildren()
    }

    fun goTo(direction: NavDirections, destinationId: Int){
        val navController = findNavController()

        navController.popBackStack(destinationId, false).let{ wasPopped ->
            if(!wasPopped){
                navController.navigate(direction)
            }
        }
    }


}