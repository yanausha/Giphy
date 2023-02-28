package com.example.giphy.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphy.domain.entity.Gif
import com.example.giphy.domain.usecases.GetGifListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GifViewModel @Inject constructor(
    private val getGifListUseCase: GetGifListUseCase
) : ViewModel() {

    private val _gifList = MutableLiveData<List<Gif>>()
    val gifList: LiveData<List<Gif>>
        get() = _gifList

    init {
        getGifList()
    }

    private fun getGifList() {
        viewModelScope.launch {
            getGifListUseCase.invoke().let {
                _gifList.value = it
            }
        }
    }
}