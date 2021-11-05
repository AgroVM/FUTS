package com.example.futs.presentation.leagueFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.futs.EXTRA_COMPETITION_ID
import com.example.futs.R
import com.example.futs.data.FootballAPIClient
import com.example.futs.data.cb.GoalscorerRetrieved
import com.example.futs.data.model.Goalscorers
import com.example.futs.presentation.adapters.GoalscorerAdapter


class GoalsFragment : Fragment() , GoalscorerRetrieved {

    private val _goalViewModel = MutableLiveData<List<Goalscorers>>()
    val _goalLivedata = _goalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val competitionId = activity?.intent?.getStringExtra(EXTRA_COMPETITION_ID)
        if (competitionId != null) {
            FootballAPIClient.getGoalscorersTable(competitionId, this)
        }
        return inflater.inflate(R.layout.fragment_goals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun setup() {
        requireView().findViewById<RecyclerView>(R.id.rv_goals).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = GoalscorerAdapter()
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        _goalLivedata.observe(viewLifecycleOwner) {
            val adapter = requireView().findViewById<RecyclerView>(R.id.rv_goals).adapter as GoalscorerAdapter
            adapter.submitList(it)
        }

    }


    override fun onGoalScorerFetchedSuccess(goalscorers: List<Goalscorers>) {
        Log.d("goalData", "${goalscorers.size}")
        _goalViewModel.postValue(goalscorers)
    }

    override fun onGoalScorerFetchedFailed() {
        Log.d("goalData", "Unable to retrieve new data")
        _goalViewModel.postValue(emptyList())
    }
}