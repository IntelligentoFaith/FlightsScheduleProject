package com.example.faith.braveproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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
        RVaiports.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        RVaiports.adapter = recyclerAdapter

        val apiInterface = AirportsApi.create().getAirports()

        apiInterface.enqueue(object : Callback<MyModelClass> {
            override fun onResponse(call: Call<MyModelClass>, response: Response<MyModelClass>) {
                val result = response.body()!!
                Log.d("#################!!!","OnSuccess!!!    "+result)

                if (result != null)
                    recyclerAdapter.setAirportListItems(result)
            }

            override fun onFailure(call: Call<MyModelClass>?, t: Throwable?) {
                Log.d("#################!!!","OnFailure: Something went wrong!!!    "+t)

            }
        })
    }
}
