package com.example.faith.braveproject.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.faith.braveproject.R
import com.example.faith.braveproject.pojo.Flight
import kotlinx.android.synthetic.main.holder_filght.view.*


class FlightAdapter(private var mContext: Context?, private var mList:ArrayList<Flight?>?, var flightLisntenr:FlightLisntenr) :
    RecyclerView.Adapter<FlightAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return mList!!.size
    }

    fun getAllItem(): ArrayList<Flight?>? {
        return mList
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (mContext != null) {
            holder.tvDropup.text = "Airport Code: "+mList!![position]?.departure?.airportCode+ "\nDeparturetime: "+mList!![position]?.departure?.scheduledTimeLocal?.dateTime
            holder.tvpickUp.text =  "Arrivaltime: "+mList!![position]?.arrival?.scheduledTimeLocal?.dateTime+"\nTermial: "+mList!![position]?.arrival?.terminal?.name

//  holder.tvDetail.text =   "Departure :"  + mList[position]?.details +""





            holder.itemView.setOnClickListener {
                flightLisntenr.FlightClick(mList!![position])

            }

        }
    }

    fun updateList(mList: ArrayList<Flight?>?) {
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_filght, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvpickUp: TextView = itemView.tvpickUp
        val tvDropup: TextView = itemView.tvDropup
        val tvDetail: TextView = itemView.tvDetail

    }

}
interface FlightLisntenr {
    fun FlightClick(Bid: Flight?)
}