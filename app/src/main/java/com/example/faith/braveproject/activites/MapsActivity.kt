package com.example.faith.braveproject.activites

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.faith.braveproject.R
import com.example.faith.braveproject.util.Constant

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions



class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val options = PolylineOptions().width(5f).color(Color.BLUE).geodesic(true)
        var list =ArrayList<LatLng>()
        list.add(LatLng(Constant.picUpAirport?.position?.coordinate?.latitude.toString().toDouble(),Constant?.picUpAirport?.position?.coordinate?.latitude.toString().toDouble()))
        list.add(LatLng(Constant.dropUpAirport?.position?.coordinate?.latitude.toString().toDouble(),Constant?.dropUpAirport?.position?.coordinate?.latitude.toString().toDouble()))
        for (z in 0 until list.size) {
            val point = list.get(z)
            options.add(point)
        }
         mMap.addPolyline(options)

        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(Constant.picUpAirport?.position?.coordinate?.latitude.toString().toDouble(),Constant?.picUpAirport?.position?.coordinate?.latitude.toString().toDouble())))


    }
}
