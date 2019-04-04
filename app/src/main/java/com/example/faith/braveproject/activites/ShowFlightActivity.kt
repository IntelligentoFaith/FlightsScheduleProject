package com.example.faith.braveproject.activites

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.faith.braveproject.pojo.MyModelClass
import com.example.faith.braveproject.R
import com.example.faith.braveproject.adapter.FlightAdapter
import com.example.faith.braveproject.adapter.FlightLisntenr
import com.example.faith.braveproject.pojo.Flight
import com.example.faith.braveproject.pojo.FlightDetail
import com.example.faith.braveproject.util.Constant
import com.google.gson.Gson

class ShowFlightActivity : AppCompatActivity() {
    lateinit var  flightAdapter:FlightAdapter
    lateinit var mirecyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_flight)
        mirecyclerView = findViewById(R.id.tcPilot);
        populateList()
        getAPICALL()

    }

    fun getAPICALL() {
        val linkTrang = "https://api.lufthansa.com/v1/operations/schedules/" +Constant.picUpAirport?.airportCode +"/"+Constant.dropUpAirport?.airportCode+"/"+Constant.pickedDate
        //+"?directFlights=false"

        Log.d("#####Schedules api#####","$linkTrang")

        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.GET, linkTrang,
            Response.Listener<String> { response ->
                Log.d("############", "Response is: " + response.toString().replace("$", "port"))
                var currentResponse = response.toString().replace("$", "port")
                var myValue = Gson().fromJson(currentResponse, FlightDetail::class.java)
                flightAdapter.updateList(myValue.scheduleResource!!.schedule!![0]?.flight as ArrayList<Flight?>?)

            },
            Response.ErrorListener { }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                headers["Authorization"] = "Bearer jg9ryug2qscbjp6bxayyd3sm"
                return headers
            }
        }

        queue.add(stringRequest)
    }

    fun  populateList(){
        flightAdapter = FlightAdapter(this, arrayListOf() ,object  : FlightLisntenr {
            override fun FlightClick(Bid: Flight?) {
                startActivity(Intent(this@ShowFlightActivity, MapsActivity::class.java))

            }




        })
        mirecyclerView.apply {
            adapter = flightAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

}
