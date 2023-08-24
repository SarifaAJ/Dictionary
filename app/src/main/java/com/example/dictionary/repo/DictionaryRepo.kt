package com.example.dictionary.repo

import com.example.dictionary.base.BaseHelper
import com.example.dictionary.base.BaseResponse
import com.example.dictionary.model.KanjiResponseItem
import com.example.dictionary.model.KosaResponseItem
import com.example.dictionary.model.SubbunpoResponseItem
import com.example.dictionary.model.SubkosaResponseItem
import io.reactivex.Observable


class DictionaryRepo: BaseHelper() {

    // subkosa
    fun getSubkosa(idLevel: String): Observable<BaseResponse<List<SubkosaResponseItem>>> {
        return  ApiServiceServer.getSubkosa(idLevel)
    }

    // kosa
    fun getKosa(idSub: String): Observable<BaseResponse<List<KosaResponseItem>>> {
        return  ApiServiceServer.getKosa(idSub)
    }
    // subbunpo
    fun getSubbunpo(idLevel: String): Observable<BaseResponse<List<SubbunpoResponseItem>>> {
        return  ApiServiceServer.getSubbunpo(idLevel)
    }
    // kanji
    fun getKanji(idLevel: String): Observable<BaseResponse<List<KanjiResponseItem>>> {
        return  ApiServiceServer.getKanji(idLevel)
    }


}