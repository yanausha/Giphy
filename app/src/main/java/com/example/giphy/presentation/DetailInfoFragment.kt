package com.example.giphy.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.giphy.R
import com.example.giphy.databinding.FragmentDetailInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailInfoFragment : Fragment() {

    private val args by navArgs<DetailInfoFragmentArgs>()

    private var _binding: FragmentDetailInfoBinding? = null
    private val binding: FragmentDetailInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailInfoBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(args.gif.imageUrl).into(binding.imageViewPoster)
        with(binding) {
            textViewWebSite.text = args.gif.giphyUrl
            textViewType.text = String.format(getString(R.string.type), args.gif.type)
            textViewRating.text= String.format(getString(R.string.rating), args.gif.rating)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}