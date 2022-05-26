package com.example.waytooquick.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.waytooquick.databinding.ListItemCatogoriesBinding
import com.example.waytooquick.models.Category

class CategoryAdapter :
    ListAdapter<Category, CategoryAdapter.CategoryAdapterViewHolder>(CategoryDiffCallback()) {

    class CategoryAdapterViewHolder(val binding: ListItemCatogoriesBinding) : RecyclerView.ViewHolder(binding.root) {}

    class CategoryDiffCallback: DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem === newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapterViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemCatogoriesBinding.inflate(inflater, parent, false)

        return CategoryAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapterViewHolder, position: Int) {
        val category = getItem(position)

        holder.binding.tvCategoryLabel.text = category.name
        holder.binding.ivCategoryItem.load(category.icon)

        holder.binding.ivCategoryItem.borderColor = category.color.toInt()
    }

}