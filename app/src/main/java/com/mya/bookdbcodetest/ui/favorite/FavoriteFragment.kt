/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mya.bookdbcodetest.databinding.FragmentFavoriteBinding
import com.mya.bookdbcodetest.model.Book
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment(), FavoriteAdapter.OnRemoveFavoriteClickListener {

    private var _binding: FragmentFavoriteBinding? = null
    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private val adapter by lazy { FavoriteAdapter() }


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteViewModel.getFavorites()

        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        binding.favoriteRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter.setOnRemoveFavoriteClickListener(this)
        binding.favoriteRecyclerView.adapter = adapter
    }

    private fun setupObservers() {
        favoriteViewModel.favorites.observe(viewLifecycleOwner) { result ->
            (binding.favoriteRecyclerView.adapter as FavoriteAdapter).submitList(result)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onRemoveFavoriteClick(favorite: Book, position: Int) {
        favoriteViewModel.removeFavorite(favorite)
        Toast.makeText(context, "Removed from Favorites!!", Toast.LENGTH_SHORT).show()

    }
}