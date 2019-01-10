package com.example.faith.braveproject.extra

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.faith.braveproject.R
import com.example.faith.braveproject.pojo.MyModelClass
import kotlinx.android.synthetic.main.airports_item.view.*

class DestinationAirportAdapter(val context: Context):RecyclerView.Adapter<DestinationAirportAdapter.ViewHolder>() {
    var airportList :List<MyModelClass> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.airports_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return airportList.size


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.airportNameTv.text = airportList[position].airportResource.toString()

    }
    fun setDestinationAirport(airportList: MyModelClass){
        this.airportList = listOf(airportList)
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val airportNameTv = itemView.TVairportName


        init{

        }





    }


}
