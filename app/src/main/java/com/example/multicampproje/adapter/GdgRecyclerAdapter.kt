package com.example.multicampproje.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multicampproje.R
import com.example.multicampproje.model.CommunityModelItem

class GdgRecyclerAdapter(var gdgList: ArrayList<CommunityModelItem>):RecyclerView.Adapter<GdgRecyclerAdapter.GdgViewHolder>() {
    class GdgViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GdgViewHolder {
        val inflater = LayoutInflater.from(parent.context)
       val view= inflater.inflate(R.layout.banner_layout,parent,false)

        return GdgViewHolder(view)
    }

    override fun onBindViewHolder(holder: GdgViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
            return gdgList.size
    }
}