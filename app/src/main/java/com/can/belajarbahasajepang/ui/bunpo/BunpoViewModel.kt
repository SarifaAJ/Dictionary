package com.can.belajarbahasajepang.ui.bunpo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.can.belajarbahasajepang.base.BaseViewModel
import com.can.belajarbahasajepang.model.BunpoResponseItem
import com.can.belajarbahasajepang.network.getErrorMessage
import com.can.belajarbahasajepang.repo.DictionaryRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class BunpoViewModel : ViewModel(), BaseViewModel<List<BunpoResponseItem>> {
    override val response = MutableLiveData<List<BunpoResponseItem>>()
    override val isLoading = MutableLiveData<Boolean>()
    override val errorMsg = MutableLiveData<String>()
    override var subscription: Disposable? = null

    private val repo = DictionaryRepo()

    fun getBunpo(idSub: String) {
        isLoading.value = true
        subscription?.dispose()

        subscription = repo.getBunpo(idSub)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    isLoading.value = false
                    if (!result.error) {
                        response.value = result.data ?: emptyList()
                    } else {
                        errorMsg.value = result.message
                    }
                },
                { error ->
                    isLoading.value = false
                    if (error is HttpException) {
                        val code = error.code()
                        errorMsg.value = getErrorMessage(code)
                    } else {
                        errorMsg.value = "Error: ${error.message}"
                    }
                }
            )
    }
}
