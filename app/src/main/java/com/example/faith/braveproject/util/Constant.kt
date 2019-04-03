package com.example.faith.braveproject.util

import com.example.faith.braveproject.pojo.Airport

object Constant {

 var BaseURL =   "https://api.lufthansa.com/"
 var sourceList :List<Airport?>? = null
 var destinationList :List<Airport?>? = null

 var picUpAirport : Airport?= null
 var dropUpAirport : Airport?= null
 var pickedDate:String = ""

 var myLat:Double?= null
 var myLong:Double ?= null
}