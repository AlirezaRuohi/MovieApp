package com.example.composeApp.Retrofit


import com.example.composeApp.model.DataModel
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("movielist.json")
    suspend fun getQuotes(): List<DataModel>
}