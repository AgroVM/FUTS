package com.example.footballapi.presentation.leagueFragments

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
import com.example.futs.data.cb.TableRetrieved
import com.example.futs.data.model.Table
import com.example.futs.presentation.adapters.TableAdapter


class TableFragment : Fragment() , TableRetrieved {


    private val _tableViewModel = MutableLiveData<List<Table>>()
    val _tableLiveData = _tableViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val competitionId = activity?.intent?.getStringExtra(EXTRA_COMPETITION_ID)
        if (competitionId != null) {
            FootballAPIClient.getCompetitionTable(competitionId, this)
        }
        return inflater.inflate(R.layout.fragment_table, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }


    private fun setup() {

        requireView().findViewById<RecyclerView>(R.id.rv_table).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = TableAdapter()
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        _tableLiveData.observe(viewLifecycleOwner) {
            val adapter = requireView().findViewById<RecyclerView>(R.id.rv_table).adapter as TableAdapter
            adapter.submitList(it)
        }
    }

    override fun onTableFetchedSuccess(table: List<Table>) {
        Log.d("tableData", "${table.size}")
        _tableViewModel.postValue(table)
    }

    override fun onTableFetchedFailed() {
        Log.e("tableData", "Unable to retrieve new data")
        _tableViewModel.postValue(emptyList())
    }


}