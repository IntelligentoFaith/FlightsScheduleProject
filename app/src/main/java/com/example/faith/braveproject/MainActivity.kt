package com.example.faith.braveproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: AirportItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerAdapter = AirportItemAdapter(this)
        RVaiports.layoutManager = LinearLayoutManager(this)
        RVaiports.adapter = recyclerAdapter

        val apiInterface = AirportsApi.create().getAirports()

        apiInterface.enqueue(object : Callback<List<Airport>> {
            override fun onResponse(call: Call<List<Airport>>?, response: Response<List<Airport>>?) {

                if (response?.body() != null)
                    recyclerAdapter.setAirportListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Airport>>?, t: Throwable?) {
                Log.d("#################!!!","OnFailure: Something went wrong!!!    "+t)

            }
        })
    }
}
