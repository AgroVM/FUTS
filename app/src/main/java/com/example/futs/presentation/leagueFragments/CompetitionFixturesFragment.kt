package com.example.futs.presentation.leagueFragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.futs.databinding.FragmentCompetitionFixturesBinding


class CompetitionFixturesFragment : Fragment(){



    private var _binding: FragmentCompetitionFixturesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCompetitionFixturesBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }
}