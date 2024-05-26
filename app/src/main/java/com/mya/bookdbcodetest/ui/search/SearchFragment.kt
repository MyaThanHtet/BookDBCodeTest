/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */


package com.mya.bookdbcodetest.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mya.bookdbcodetest.databinding.FragmentSearchBinding
import com.mya.bookdbcodetest.model.Book
import com.mya.bookdbcodetest.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment(), BookAdapter.OnFavoriteClickListener {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val searchViewModel: SearchViewModel by viewModels()
    private val adapter by lazy { BookAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel.getBooks("query")

        setupRecyclerView()
        setupSearchView()
        setupObservers()


    }

    private fun setupRecyclerView() {
        binding.bookRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter.setOnFavoriteClickListener(this)
        binding.bookRecyclerView.adapter = adapter
        binding.bookRecyclerView.scrollToPosition(0)

    }

    private fun setupSearchView() {
        binding.searchView.queryHint = "Search books..."
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    searchViewModel.getBooks(it)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })
    }


    private fun setupObservers() {
        searchViewModel.books.observe(viewLifecycleOwner) { result ->
            when (result) {
                is NetworkResult.Success -> {
                    (binding.bookRecyclerView.adapter as BookAdapter).submitList(result.data?.books)
                }

                is NetworkResult.Error -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
                }

                is NetworkResult.Loading -> {
                    // Show a loading indicator
                }

                else -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onFavoriteClick(book: Book, position: Int) {

        searchViewModel.insertToFavorite(favorite = book)

        Toast.makeText(context, "Added to Favorite!!", Toast.LENGTH_SHORT).show()
    }
}