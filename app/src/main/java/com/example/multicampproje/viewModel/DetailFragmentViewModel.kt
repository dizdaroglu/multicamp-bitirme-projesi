package com.example.multicampproje.viewModel

import android.app.Application
import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.example.multicampproje.model.CommunityModelItem

class DetailFragmentViewModel(application: Application):BaseViewModel(application) {
    var yukleniyor = MutableLiveData<Boolean>()
    var communityModel = MutableLiveData<CommunityModelItem>()


    fun veriYukleniyor(bilgi: CommunityModelItem){
            yukleniyor.value = true
            communityModel.value=bilgi

            Handler().postDelayed({
                yukleniyor.value=false
            },400)

    }
}