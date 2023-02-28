package com.example.giphy.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphy.R
import com.example.giphy.databinding.FragmentGifListBinding
import com.example.giphy.presentation.adapters.GifListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GifListFragment : Fragment(R.layout.fragment_gif_list) {

    private val viewModel: GifViewModel by viewModels()

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

        val adapter = GifListAdapter()
        binding.recyclerViewGifList.adapter = adapter
        binding.recyclerViewGifList.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.gifList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}