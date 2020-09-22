package com.example.multicampproje.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.multicampproje.R
import com.example.multicampproje.adapter.GdgRecyclerAdapter
import com.example.multicampproje.viewModel.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private  val gdgRecyclerAdapter = GdgRecyclerAdapter(arrayListOf())
    private lateinit var viewModel:HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel::class.java)
        viewModel.veriCek()

        bannerRecyclerView.adapter = gdgRecyclerAdapter

        observeLiveData()
    }

    fun observeLiveData(){
            viewModel.gdgList.observe(viewLifecycleOwner, Observer {liste->
                liste?.let {
                    gdgRecyclerAdapter.dataUpdate(it)
                }
            })
    }


}