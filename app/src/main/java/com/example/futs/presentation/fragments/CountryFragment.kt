package com.example.futs.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.futs.EXTRA_COUNTRY_ID
import com.example.futs.R
import com.example.futs.data.model.Country
import com.example.futs.databinding.FragmentCountryBinding
import com.example.futs.presentation.CompetitionActivity
import com.example.futs.presentation.adapters.CountryAdapter


class CountryFragment : Fragment() {

    private val viewModel by viewModels<CountryViewModel>()
    private var _binding: FragmentCountryBinding ?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCountryBinding.inflate(LayoutInflater.from(context), container, false)
        val rootView = binding.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        viewModel.loadLeague()
    }

    private fun setup() {
        requireView().findViewById<RecyclerView>(R.id.rv_country).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CountryAdapter(::openCompetitionScreen)
        }

        viewModel.leagueLiveData.observe(viewLifecycleOwner) {
            val adapter = requireView().findViewById<RecyclerView>(R.id.rv_country).adapter as CountryAdapter
            adapter.submitList(it)
        }
    }

    private fun openCompetitionScreen(country: Country) {
        val intent = Intent(requireContext(), CompetitionActivity::class.java)
        intent.putExtra(EXTRA_COUNTRY_ID, country.id)
        Log.d("CFRA", country.id)
        startActivity(intent)
    }
}