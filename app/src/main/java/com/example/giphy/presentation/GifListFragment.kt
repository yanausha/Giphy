package com.example.giphy.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.giphy.R
import com.example.giphy.databinding.FragmentGifListBinding
import com.example.giphy.presentation.adapters.GifListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GifListFragment : Fragment(R.layout.fragment_gif_list) {

    private lateinit var adapter: GifListAdapter

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

        initAdapter()
        setTrendingGifList()
        setFoundGifList()
        useProgress()
    }

    private fun useProgress() {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            when (it) {
                true -> binding.progressBar.visibility = View.VISIBLE
                false -> binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun setFoundGifList() {
        var job: Job? = null
        binding.editText.addTextChangedListener {
            job?.cancel()
            job = MainScope().launch {
                val str = it?.trim()?: ""
                if (str.toString().isNotEmpty()) {
                    Log.d("Test", str.toString())
                    viewModel.searchGifList(it.toString())
                    viewModel.gifList.observe(viewLifecycleOwner) {
                        adapter.submitList(it)
                    }
                }
            }
        }
    }

    private fun setTrendingGifList() {
        viewModel.gifList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun initAdapter() {
        adapter = GifListAdapter()
        binding.recyclerViewGifList.adapter = adapter
        binding.recyclerViewGifList.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )
    }
}
