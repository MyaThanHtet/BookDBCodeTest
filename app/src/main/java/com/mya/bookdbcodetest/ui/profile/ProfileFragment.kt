/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mya.bookdbcodetest.databinding.FragmentProfileBinding
import com.mya.bookdbcodetest.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null


    private val binding get() = _binding!!

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpProfile()
        logOut()
    }

    private fun setUpProfile() {
        profileViewModel.getUser()
        profileViewModel.user.observe(viewLifecycleOwner) { user ->
            binding.userNameTv.text = user?.username
        }
    }

    private fun logOut() {
        binding.logoutBtn.setOnClickListener {
            profileViewModel.logOut()
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}