package com.can.belajarbahasajepang.ui.kanji

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.can.belajarbahasajepang.base.BaseViewModel
import com.can.belajarbahasajepang.model.KanjiResponseItem
import com.can.belajarbahasajepang.network.getErrorMessage
import com.can.belajarbahasajepang.repo.DictionaryRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class KanjiViewModel : ViewModel(), BaseViewModel<List<KanjiResponseItem>> {
    override val response = MutableLiveData<List<KanjiResponseItem>>()
    override val isLoading = MutableLiveData<Boolean>()
    override val errorMsg = MutableLiveData<String>()
    override var subscription: Disposable? = null

    private val repo = DictionaryRepo()

    fun getKanji(idLevel: String) {
        isLoading.value = true
        subscription?.dispose()

        subscription = repo.getKanji(idLevel)
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
