/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.ui.search


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mya.bookdbcodetest.R
import com.mya.bookdbcodetest.databinding.ItemBookBinding
import com.mya.bookdbcodetest.model.Book

class BookAdapter : ListAdapter<Book, BookAdapter.BookViewHolder>(BookDiffCallback()) {
    private var favoriteClickListener: OnFavoriteClickListener? = null

    fun setOnFavoriteClickListener(listener: OnFavoriteClickListener) {
        favoriteClickListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }



    interface OnFavoriteClickListener {
        fun onFavoriteClick(book: Book, position: Int)
    }


    inner class BookViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var isFavorite = false

        fun bind(book: Book) {
            binding.bookTitle.text = book.title
            binding.bookAuthor.text = book.authors
            binding.bookSubtitle.text = book.subtitle
            Glide.with(itemView.context).load(book.image).into(binding.bookImage)

            binding.favoriteButton.setOnClickListener {
                isFavorite = !isFavorite
                binding.favoriteButton.setImageResource(
                    if (isFavorite) R.drawable.favorite_filled else R.drawable.favorite
                )
                favoriteClickListener?.onFavoriteClick(book, adapterPosition)

            }
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

