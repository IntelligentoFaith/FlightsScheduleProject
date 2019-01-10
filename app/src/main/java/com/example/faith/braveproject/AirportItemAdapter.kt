package com.example.faith.braveproject

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.aiports_item.view.*

class AirportItemAdapter(val context: Context):RecyclerView.Adapter<AirportItemAdapter.ViewHolder>() {
    var airportList :List<MyModelClass> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aiports_item,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return airportList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.airportNameTv.text = airportList[position].airportResource.toString()

    }
    fun setAirportListItems(airportList: MyModelClass){
        this.airportList = listOf(airportList)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val airportNameTv = itemView.TVairportName


        init{

        }





    }

}