package com.example.dictionary.ui.penjelasan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.base.BaseViewModel
import com.example.dictionary.model.PenjelasanResponseItem
import com.example.japanesedictionary.network.getErrorMessage
import com.example.dictionary.repo.DictionaryRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class PenjelasanViewModel : ViewModel(), BaseViewModel<List<PenjelasanResponseItem>> {
    override val response = MutableLiveData<List<PenjelasanResponseItem>>()
    override val isLoading = MutableLiveData<Boolean>()
    override val errorMsg = MutableLiveData<String>()
    override var subscription: Disposable? = null

    private val repo = DictionaryRepo()

    fun getPenjelasan(idLevel: String) {
        isLoading.value = true
        subscription?.dispose()

        subscription = repo.getPenjelasan(idLevel)
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
