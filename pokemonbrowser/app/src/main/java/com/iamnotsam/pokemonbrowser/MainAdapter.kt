package com.iamnotsam.pokemonbrowser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iamnotsam.pokemonbrowser.databinding.AdapterCardBinding
import com.iamnotsam.pokemonbrowser.pojo.Card

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    private var cards = mutableListOf<Card>()

    fun setCardList(cards: List<Card>) {
        this.cards = cards.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding =AdapterCardBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val card = cards[position]
        holder.binding.name.text = card.name
        Glide.with(holder.itemView.context).load(card.images.large).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return cards.size
    }
}

class MainViewHolder(val binding: AdapterCardBinding) : RecyclerView.ViewHolder(binding.root) {
    // how can i assign number of columns dynamically? Depending on orientation?
}
