package com.example.chapter7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter7.databinding.ItemWordBinding

class WordAdapter(val list: MutableList<Word>, val itemClickListener: ItemClickListener?=null): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    class WordViewHolder(val binding: ItemWordBinding) : RecyclerView.ViewHolder(binding.root)

    interface ItemClickListener {
        fun onClick(word: Word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemWordBinding.inflate(inflater, parent,  false)
        return WordViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.binding.apply {
            val word = list[position]
            textTextView.text = word.text
            meanTextView.text = word.mean
            typeChip.text = word.type
        }
        holder.itemView.setOnClickListener { itemClickListener?.onClick(list[position]) }
    }
}