package com.example.multicampproje.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.multicampproje.model.CommunityModel
import com.example.multicampproje.model.CommunityModelItem
import com.example.multicampproje.service.ServiceBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HomeFragmentViewModel(application: Application):BaseViewModel(application) {

    var gdgList = MutableLiveData<List<CommunityModelItem>>()

    private val disposable = CompositeDisposable()

    fun veriCek(){
        disposable.add(
            ServiceBuilder.buildService().getGDG()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(object :DisposableSingleObserver<List<CommunityModelItem>>(){
                    override fun onSuccess(t: List<CommunityModelItem>) {
                      gdgList.value=t
                    }
                    override fun onError(e: Throwable) {
                        println("hata!!")
                        e.printStackTrace()
                    }
                })
        )
    }
}