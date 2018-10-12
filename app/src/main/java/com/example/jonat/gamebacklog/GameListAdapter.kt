package com.example.jonat.gamebacklog

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class GameListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var games = emptyList<Game>() // Cached copy of games

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameItemViewTitle: TextView = itemView.findViewById(R.id.textTitle)
        val gameItemViewStatus: TextView = itemView.findViewById(R.id.textStatus)
        val gameItemViewPlatform: TextView = itemView.findViewById(R.id.textPlatform)
    //    val gameItemViewTitle: TextView = itemView.findViewById(R.id.textTitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = inflater.inflate(R.layout.game_item, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val current = games[position]
        holder.gameItemViewTitle.text = current.title
      //  holder.gameItemViewStatus.text = current.status.toString()
    //    holder.gameItemViewPlatform.text = current.platform
    }

    internal fun setGames(games: List<Game>) {
        this.games = games
        notifyDataSetChanged()
    }

    override fun getItemCount() = games.size
}