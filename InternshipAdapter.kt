package com.example.vedatechnologyinternshipcompanionapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class InternshipAdapter(
    private val onItemClick: (InternshipItem) -> Unit
) : ListAdapter<InternshipItem, InternshipAdapter.InternshipViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InternshipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_internship, parent, false)
        return InternshipViewHolder(view)
    }

    override fun onBindViewHolder(holder: InternshipViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    class InternshipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvCompany: TextView = itemView.findViewById(R.id.tvCompany)
        private val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)

        fun bind(item: InternshipItem) {
            tvTitle.text = item.title
            tvCompany.text = item.company
            tvDescription.text = item.description
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<InternshipItem>() {
        override fun areItemsTheSame(oldItem: InternshipItem, newItem: InternshipItem): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: InternshipItem, newItem: InternshipItem): Boolean = oldItem == newItem
    }
}