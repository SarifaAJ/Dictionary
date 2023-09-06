package com.can.belajarbahasajepang.repo

import com.can.belajarbahasajepang.base.BaseHelper
import com.can.belajarbahasajepang.base.BaseResponse
import com.can.belajarbahasajepang.model.BunpoResponseItem
import com.can.belajarbahasajepang.model.KanjiResponseItem
import com.can.belajarbahasajepang.model.KosaResponseItem
import com.can.belajarbahasajepang.model.PenjelasanResponseItem
import com.can.belajarbahasajepang.model.SubbunpoResponseItem
import com.can.belajarbahasajepang.model.SubkosaResponseItem
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

    // bunpo
    fun getBunpo(idSub: String): Observable<BaseResponse<List<BunpoResponseItem>>> {
        return  ApiServiceServer.getBunpo(idSub)
    }

    // kanji
    fun getKanji(idLevel: String): Observable<BaseResponse<List<KanjiResponseItem>>> {
        return  ApiServiceServer.getKanji(idLevel)
    }

    // penjelasan
    fun getPenjelasan(idLevel: String): Observable<BaseResponse<List<PenjelasanResponseItem>>> {
        return  ApiServiceServer.getPenjelasan(idLevel)
    }
}