package com.example.multicampproje.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.multicampproje.R
import com.example.multicampproje.model.CommunityModelItem
import com.example.multicampproje.viewModel.DetailFragmentViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment(), View.OnClickListener {
    private  lateinit var viewModel:DetailFragmentViewModel

    private lateinit  var bilgi:CommunityModelItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            bilgi = DetailFragmentArgs.fromBundle(it).bilgi
        }
        viewModel = ViewModelProviders.of(this).get(DetailFragmentViewModel::class.java)

        viewModel.veriYukleniyor(bilgi)

        observeLiveData()

        meetupIcon.setOnClickListener(this)
        instagramIcon.setOnClickListener(this)
        twitterIcon.setOnClickListener(this)
        youtubeIcon.setOnClickListener(this)
    }
    fun observeLiveData(){
        viewModel.yukleniyor.observe(viewLifecycleOwner, Observer { progresBar ->
            progresBar?.let {
                if (it) {
                    detailBannerImageView.visibility = View.GONE
                    liderImageView.visibility = View.GONE
                    titleTextView.visibility = View.GONE
                    descriptionTextView.visibility = View.GONE
                    bottomLinearLayout.visibility = View.GONE
                } else {
                    detailProgresBar.visibility = View.GONE
                    detailBannerImageView.visibility = View.VISIBLE
                    liderImageView.visibility = View.VISIBLE
                    titleTextView.visibility = View.VISIBLE
                    descriptionTextView.visibility = View.VISIBLE
                    bottomLinearLayout.visibility = View.VISIBLE
                }
            }
        })
        viewModel.communityModel.observe(viewLifecycleOwner, Observer { model ->
            model?.let {
                detailSayfaKayit(it)
            }

        })
    }
    private fun detailSayfaKayit(bilgi: CommunityModelItem){
        var imageUrl = bilgi.banner
        Glide.with(this).load(imageUrl).centerCrop().fitCenter().into(detailBannerImageView)

        var leaderImage = bilgi.leader.photo
        Glide.with(this).load(leaderImage).circleCrop().into(liderImageView)

        titleTextView.text = bilgi.leader.name
        descriptionTextView.text = bilgi.description
    }

    override fun onClick(v: View?) {
       v?.let {
            when(v.id){
                R.id.meetupIcon -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(bilgi.links.participation))
                    startActivity(intent)
                }
                R.id.twitterIcon -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(bilgi.links.twitter))
                    startActivity(intent)
                }
                R.id.youtubeIcon -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(bilgi.links.youtube))
                    startActivity(intent)
                }
                R.id.instagramIcon -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(bilgi.links.instagram))
                    startActivity(intent)
                }
            }
       }
    }


}