package com.example.futs.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.futs.R
import com.example.futs.data.model.Table

class TableAdapter() : ListAdapter<Table, TableAdapter.TableViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TableViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TableViewHolder(inflater.inflate(R.layout.item_table, parent, false))
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val team = getItem(position)

        if (position == 0) {
            holder.header.visibility = View.VISIBLE
            holder.competitionName.visibility = View.VISIBLE
        } else {
            holder.header.visibility = View.GONE
            holder.competitionName.visibility = View.GONE
        }

        holder.team.text = team.name
        holder.rank.text = team.rank
        holder.games_played.text = team.matches
        holder.games_won.text = team.won
        holder.games_drawn.text = team.drawn
        holder.games_lost.text = team.lost
        holder.points.text = team.points

    }

    private class DiffCallback: DiffUtil.ItemCallback<Table>() {
        override fun areItemsTheSame(oldItem: Table, newItem: Table): Boolean {
            return oldItem.team_id == newItem.team_id
        }

        override fun areContentsTheSame(oldItem: Table, newItem: Table): Boolean {
            return oldItem == newItem
        }

    }

    inner class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val header = itemView.findViewById(R.id.rv_header) as LinearLayout
        val competitionName = itemView.findViewById(R.id.tv_competition) as TextView
        val rank = itemView.findViewById(R.id.tv_rank) as TextView
        val team = itemView.findViewById(R.id.tv_name) as TextView
        val games_played = itemView.findViewById(R.id.tv_played) as TextView
        val games_won = itemView.findViewById(R.id.tv_won) as TextView
        val games_drawn = itemView.findViewById(R.id.tv_drawn) as TextView
        val games_lost = itemView.findViewById(R.id.tv_lost) as TextView
        val points = itemView.findViewById(R.id.tv_points) as TextView
    }

}