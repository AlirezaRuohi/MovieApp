package com.example.composeApp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeApp.model.DataModel
import com.example.composeApp.Retrofit.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

typealias listModel = List<DataModel>

@HiltViewModel
class ViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    var movieListResponse: listModel by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            try {
                movieListResponse = apiService.getQuotes()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}