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
import com.example.futs.data.model.Goalscorers

class GoalscorerAdapter : ListAdapter<Goalscorers, GoalscorerAdapter.GoalscorerViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GoalscorerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GoalscorerViewHolder(inflater.inflate(R.layout.item_goals, parent, false))
    }

    override fun onBindViewHolder(holder: GoalscorerAdapter.GoalscorerViewHolder, position: Int) {
        val player = getItem(position)
        val num = position + 1

        if (position == 0) {
            holder.header.visibility = View.VISIBLE
        } else {
            holder.header.visibility = View.GONE
        }

        holder.rank.text = num.toString()
        holder.playerName.text = player.name
        holder.team.text = player.team.name
        holder.goals.text = player.goals
        holder.assists.text = player.assists
        holder.games_played.text = player.played

    }

    private class DiffCallback: DiffUtil.ItemCallback<Goalscorers>() {
        override fun areItemsTheSame(oldItem: Goalscorers, newItem: Goalscorers): Boolean {
            return oldItem.player_id == newItem.player_id
        }

        override fun areContentsTheSame(oldItem: Goalscorers, newItem: Goalscorers): Boolean {
            return oldItem == newItem
        }

    }

    inner class GoalscorerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val header = itemView.findViewById(R.id.rv_header) as LinearLayout
        val rank = itemView.findViewById(R.id.tv_rank) as TextView
        val playerName = itemView.findViewById(R.id.tv_player_name) as TextView
        val team = itemView.findViewById(R.id.team) as TextView
        val goals = itemView.findViewById(R.id.goals_scored) as TextView
        val assists = itemView.findViewById(R.id.assists) as TextView
        val games_played = itemView.findViewById(R.id.games_played) as TextView
    }
}