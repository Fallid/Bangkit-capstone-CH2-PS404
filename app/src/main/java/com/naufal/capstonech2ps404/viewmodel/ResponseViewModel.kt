package com.naufal.capstonech2ps404.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufal.capstonech2ps404.data.retrofit.ApiConfig
import com.naufal.capstonech2ps404.model.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResponseViewModel : ViewModel(){
    private val apiService = ApiConfig.getVacations()
    fun getItems(callback:(Response) -> Unit){
        viewModelScope.launch (Dispatchers.IO ){
            val response = apiService.getPlaces()
            callback(response)
        }
    }
}