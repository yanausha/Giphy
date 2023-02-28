package com.example.giphy.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.giphy.R
import com.example.giphy.databinding.FragmentGifListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GifListFragment: Fragment(R.layout.fragment_gif_list) {

    private var _binding: FragmentGifListBinding? = null
    private val binding: FragmentGifListBinding
        get() = _binding ?: throw RuntimeException("FragmentGifListBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGifListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}