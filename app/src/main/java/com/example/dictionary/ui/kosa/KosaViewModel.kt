package com.example.dictionary.ui.kosa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.base.BaseViewModel
import com.example.dictionary.model.KosaResponseItem
import com.example.dictionary.model.SubbunpoResponseItem
import com.example.dictionary.model.SubkosaResponseItem
import com.example.japanesedictionary.network.getErrorMessage
import com.example.dictionary.repo.DictionaryRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class KosaViewModel : ViewModel(), BaseViewModel<List<KosaResponseItem>> {
    override val response = MutableLiveData<List<KosaResponseItem>>()
    override val isLoading = MutableLiveData<Boolean>()
    override val errorMsg = MutableLiveData<String>()
    override var subscription: Disposable? = null

    private val repo = DictionaryRepo()

    fun getKosa(idSub: String) {
        isLoading.value = true
        subscription?.dispose()

        subscription = repo.getKosa(idSub)
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
