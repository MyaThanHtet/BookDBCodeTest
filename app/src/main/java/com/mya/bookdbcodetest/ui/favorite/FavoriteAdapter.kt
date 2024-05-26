/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.ui.favorite


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mya.bookdbcodetest.R
import com.mya.bookdbcodetest.databinding.ItemFavoriteBinding
import com.mya.bookdbcodetest.model.Book

class FavoriteAdapter : ListAdapter<Book, FavoriteAdapter.BookViewHolder>(BookDiffCallback()) {
    private var removeFavoriteClickListener: OnRemoveFavoriteClickListener? = null

    fun setOnRemoveFavoriteClickListener(listener: OnRemoveFavoriteClickListener) {
        removeFavoriteClickListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface OnRemoveFavoriteClickListener {
        fun onRemoveFavoriteClick(favorite: Book, position: Int)
    }

    inner class BookViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var isFavorite = false

        fun bind(favorite: Book) {
            binding.bookTitle.text = favorite.title
            binding.bookAuthor.text = favorite.authors
            binding.bookSubtitle.text = favorite.subtitle
            Glide.with(itemView.context).load(favorite.image).into(binding.bookImage)

            binding.favoriteButton.setOnClickListener {
                isFavorite = !isFavorite
                binding.favoriteButton.setImageResource(
                    if (isFavorite) R.drawable.favorite_filled else R.drawable.favorite
                )
                removeFavoriteClickListener?.onRemoveFavoriteClick(favorite, adapterPosition)

            }
            binding.favoriteButton.setImageResource(R.drawable.favorite_filled)

        }
    }
}

class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.identity == newItem.identity
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}
