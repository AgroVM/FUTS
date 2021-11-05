package com.example.futs.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.futs.data.model.Competition
import com.example.futs.R


class CompetitionAdapter(
    private val clickAction: (Competition) -> Unit
) : ListAdapter<Competition, CompetitionAdapter.LeagueViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
        ) : LeagueViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LeagueViewHolder(inflater.inflate(R.layout.item_competition, parent, false))
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val competition = getItem(position)
        holder.competition.text = competition!!.name
        holder.competition.setOnClickListener {
            clickAction(competition)
        }
    }

    private class DiffCallback: DiffUtil.ItemCallback<Competition>() {
        override fun areItemsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem == newItem
        }

    }

    inner class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val competition = itemView.findViewById(R.id.tv_competition) as TextView
    }
}