package com.example.faith.braveproject.activites

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner

import com.example.faith.braveproject.adapter.AirportDorpDownAdapter

//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.faith.braveproject.*
import com.example.faith.braveproject.extra.DestinationAirportAdapter
import com.example.faith.braveproject.extra.OriginAirportItemAdapter
import com.example.faith.braveproject.pojo.Airport
import com.example.faith.braveproject.pojo.MyModelClass
import com.example.faith.braveproject.util.Constant
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var originAirportAdapter: OriginAirportItemAdapter
    lateinit var destinationAirportAdapter: DestinationAirportAdapter
    lateinit var pickUpSpinner: Spinner
    lateinit var dropUpSpinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUsers()

        pickUpSpinner = findViewById<Spinner>(R.id.RVoriginAirport)
        dropUpSpinner = findViewById<Spinner>(R.id.RVdestinationAirport)
    findViewById<Button>(R.id.btnSubmit).setOnClickListener{
                        startActivity(Intent(this, ShowFlightActivity::class.java))

    }

    }

    fun getUsers() {
        val linkTrang = "https://api.lufthansa.com/v1/references/airports/?lang=en&limit=100&offset=0&LHoperated=0"

        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(Request.Method.GET, linkTrang,
            Response.Listener<String> { response ->
                Log.d("A", "Response is: " + response.toString().replace("$", "port"))
                var currentResponse = response.toString().replace("$", "port")
                var myValue = Gson().fromJson(currentResponse, MyModelClass::class.java)
                Constant.sourceList = myValue?.airportResource?.airports?.airport
                Constant.destinationList = myValue?.airportResource?.airports?.airport
                populateSoursePort(Constant.sourceList)
            },
            Response.ErrorListener { }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Accept"] = "application/json"
                headers["Authorization"] = "Bearer ftnx4g6f88bswwkyrup2amut"
                return headers
            }
        }

        queue.add(stringRequest)
    }



    fun populateSoursePort(dropdownList: List<Airport?>?) {
        val array_adapter = AirportDorpDownAdapter(this, android.R.layout.simple_spinner_item, dropdownList)
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        pickUpSpinner.adapter = array_adapter

        val array_adapter2 = AirportDorpDownAdapter(this, android.R.layout.simple_spinner_item, dropdownList)
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dropUpSpinner.adapter = array_adapter

        pickUpSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, id: Long) {
                Constant.picUpAirport = p0?.getAdapter()?.getItem(p2) as Airport


            }

        }
            dropUpSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, id: Long) {
                    Constant.dropUpAirport= p0?.getAdapter()?.getItem(p2) as Airport


                }

        }


    }


//    fun callAirportList(){
//
//
//            val call = ApiClient.newApiClientInstance.getServerAPI().listPilot("en", "100", "0", "0")
//            call.enqueue(object : Callback<MyModelClass> {
//                override fun onFailure(call: Call<MyModelClass>?, t: Throwable?) {
//
//
//                }
//
//                override fun onResponse(call: Call<MyModelClass>, response: Response<MyModelClass>) {
//
//                    Log.d("whatisMyResp", response.body().toString())
////                    if(response != null) {
////                     if(response!!.body() != null) {
////                         if (response!!.body()?.airportResource != null) {
////                             if(response.body()?.airportResource?.airports != null) {
////                                 if(response.body()?.airportResource?.airports?.airport !=null && response.body()?.airportResource?.airports?.airport!!.isNotEmpty() ) {
//                                   //  populateSoursePort(response?.body()!!.airportResource?.airports?.airport)
////                                 }
////                                 }
////                             }
////                     }
////                     }
//                    }
//                })
//
//    }
}









