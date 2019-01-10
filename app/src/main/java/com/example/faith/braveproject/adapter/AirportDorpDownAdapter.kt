package com.example.faith.braveproject.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.faith.braveproject.pojo.Airport
import com.example.faith.braveproject.pojo.MyModelClass
import com.example.faith.braveproject.R


class AirportDorpDownAdapter internal constructor(var activity: Activity, val rescouces:Int, val dropdownList: List<Airport?>?): ArrayAdapter<Airport>(activity,rescouces,dropdownList
){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val viewHolder: ViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.spinner_layout, parent, false)
            viewHolder = ViewHolder()
            viewHolder.name = convertView!!.findViewById(R.id.tv_spinner_item) as TextView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        if(dropdownList!![position] != null){
            viewHolder.name?.text = dropdownList[position]?.names?.name?.port
//            viewHolder.name?.text = dropdownList[position]?.names?.name
        }else {
            viewHolder.name?.text=""
        }
        return convertView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_layout, parent, false)
            viewHolder = ViewHolder()
            viewHolder.name = convertView!!.findViewById(R.id.tv_spinner_item) as TextView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        if(dropdownList!![position] != null){
            viewHolder.name?.text = dropdownList[position]?.names?.name?.port
        }else {
            viewHolder.name?.text=""
        }
        return convertView
    }

    private inner class ViewHolder {
        internal var name: TextView? = null
    }


    public interface selectSpinnerInterface
    {
        fun selectItem(value: MyModelClass);
    }
}