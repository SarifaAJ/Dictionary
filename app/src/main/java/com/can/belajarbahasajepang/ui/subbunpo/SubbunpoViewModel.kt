package com.can.belajarbahasajepang.ui.subbunpo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.can.belajarbahasajepang.base.BaseViewModel
import com.can.belajarbahasajepang.model.SubbunpoResponseItem
import com.can.belajarbahasajepang.network.getErrorMessage
import com.can.belajarbahasajepang.repo.DictionaryRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class SubbunpoViewModel : ViewModel(), BaseViewModel<List<SubbunpoResponseItem>> {
    override val response = MutableLiveData<List<SubbunpoResponseItem>>()
    override val isLoading = MutableLiveData<Boolean>()
    override val errorMsg = MutableLiveData<String>()
    override var subscription: Disposable? = null

    private val repo = DictionaryRepo()

    fun getSubbunpo(idLevel: String) {
        isLoading.value = true
        subscription?.dispose()

        subscription = repo.getSubbunpo(idLevel)
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
