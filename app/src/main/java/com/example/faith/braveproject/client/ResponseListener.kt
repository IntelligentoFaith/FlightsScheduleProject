package com.example.faith.braveproject.client

import com.example.faith.braveproject.pojo.MyModelClass

import retrofit2.Call
import retrofit2.http.*

interface ResponseListener {

    @GET(EndPoints.pilotURL)
    fun listPilot(
        @Query("lang") lang: String ,
        @Query("limit") limit: String ,
        @Query("offset") offset: String ,
        @Query("LHoperated") LHoperated: String
        ): Call<MyModelClass>


}
