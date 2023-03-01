package com.example.giphy.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphy.domain.entity.Gif
import com.example.giphy.domain.usecases.GetGifListUseCase
import com.example.giphy.domain.usecases.SearchGifListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GifViewModel @Inject constructor(
    private val getGifListUseCase: GetGifListUseCase,
    private val searchGifListUseCase: SearchGifListUseCase
) : ViewModel() {

    private val _gifList = MutableLiveData<List<Gif>>()
    val gifList: LiveData<List<Gif>>
        get() = _gifList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getGifList()
    }

    private fun getGifList() {
        viewModelScope.launch {
            getGifListUseCase().let {
                _gifList.value = it
            }
        }
    }

    fun searchGifList(str: String) {
        viewModelScope.launch {
            _isLoading.value = true
            delay(500L)
            searchGifListUseCase(str).let {
                if (checkNotNull(it).isNotEmpty()) {
                    _gifList.value = it
                }
                _isLoading.value = false
            }
        }
    }
}