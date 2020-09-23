package com.example.multicampproje.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.multicampproje.R
import com.example.multicampproje.model.CommunityModelItem
import com.example.multicampproje.view.HomeFragmentDirections
import kotlinx.android.synthetic.main.banner_layout.view.*

class GdgRecyclerAdapter(var gdgList: ArrayList<CommunityModelItem>):RecyclerView.Adapter<GdgRecyclerAdapter.GdgViewHolder>() {
    class GdgViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GdgViewHolder {
        val inflater = LayoutInflater.from(parent.context)
       val view= inflater.inflate(R.layout.banner_layout,parent,false)

        return GdgViewHolder(view)
    }

    override fun onBindViewHolder(holder: GdgViewHolder, position: Int) {
            val imageUrl = gdgList[position].banner
          Glide.with(holder.itemView.context).load(imageUrl).centerCrop().fitCenter().into(holder.itemView.bannerImageView)
         holder.itemView.setOnClickListener {
             val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(gdgList[position])
             Navigation.findNavController(it).navigate(action)
         }

    }

    override fun getItemCount(): Int {
            return gdgList.size
    }
    fun dataUpdate(gelenVeri:List<CommunityModelItem>){

        gdgList.clear()
        gdgList.addAll(gelenVeri)
        notifyDataSetChanged()
    }
}