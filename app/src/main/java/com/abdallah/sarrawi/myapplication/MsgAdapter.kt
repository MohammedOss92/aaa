package com.abdallah.sarrawi.myapplication

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter(var msg_list:List<Msg>, var context: Context,var fontFamily: Typeface?=null): RecyclerView.Adapter<MsgAdapter.MyHolder>() {

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var tv: TextView =itemView.findViewById(R.id.textView2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pager,parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val msg: Msg = msg_list.get(position)
        holder.tv.text =msg.Con_Name
        fontFamily?.let {
            holder.tv.typeface = it
        }
    }

    override fun getItemCount(): Int {
        return msg_list.size
    }

    fun setFont(font: Typeface?) {
        this.fontFamily = font
        notifyDataSetChanged()
    }

}
