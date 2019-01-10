package com.example.faith.braveproject.extra

import com.example.faith.braveproject.pojo.MyModelClass
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers


interface AirportsApi {
    @Headers("Accept:application/json",
        "Authorization:Bearer y5tfk73v3aey97qvzeweg5r2",
        "X-Origination-IP:105.161.103.162")
    @GET("v1/references/airports/?lang=en&limit=100&offset=0&LHoperated=0")

    fun getAirports() : Call<MyModelClass>

    companion object {

        var BASE_URL = "https://api.lufthansa.com/"

        fun create(): AirportsApi {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(AirportsApi::class.java)

        }
    }
}