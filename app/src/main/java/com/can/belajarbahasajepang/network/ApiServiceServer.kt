package com.can.belajarbahasajepang.network

import com.can.belajarbahasajepang.base.BaseResponse
import com.can.belajarbahasajepang.model.BunpoResponseItem
import com.can.belajarbahasajepang.model.KanjiResponseItem
import com.can.belajarbahasajepang.model.KosaResponseItem
import com.can.belajarbahasajepang.model.LevelResponseItem
import com.can.belajarbahasajepang.model.PenjelasanResponseItem
import com.can.belajarbahasajepang.model.SubbunpoResponseItem
import com.can.belajarbahasajepang.model.SubkosaResponseItem
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceServer {
    // level
    @GET("getlevel")
    fun getLevel(): Call<List<LevelResponseItem>>

    // subkosa
    @GET("getsubkosa/{id_level}")
    fun getSubkosa(@Path("id_level") idLevel: String): Observable<BaseResponse<List<SubkosaResponseItem>>>

    // kosa
    @GET("kosa/{id_sub}")
    fun getKosa(@Path("id_sub") idSub: String): Observable<BaseResponse<List<KosaResponseItem>>>

    // subbunpo
    @GET("getsubbunpo/{id_level}")
    fun getSubbunpo(@Path("id_level") idLevel: String): Observable<BaseResponse<List<SubbunpoResponseItem>>>

    // bunpo
    @GET("bunpo/{id_sub}")
    fun getBunpo(@Path("id_sub") idSub: String): Observable<BaseResponse<List<BunpoResponseItem>>>

    // detail bunpo
    @GET("bunpo/{id_sub}/{id}")
    fun getDetailBunpo(@Path("id_sub") idSub: String, @Path("id") id: String): Observable<BaseResponse<BunpoResponseItem>>

    // kanji
    @GET("kanji/{id_level}")
    fun getKanji(@Path("id_level") idLevel: String): Observable<BaseResponse<List<KanjiResponseItem>>>

    // penjelasan
    @GET("penjelasan/{id_level}")
    fun getPenjelasan(@Path("id_level") idLevel: String): Observable<BaseResponse<List<PenjelasanResponseItem>>>

    // detail penjelasan
    @GET("penjelasan/{id}")
    fun getDetailPenjelasan(@Path("id") id: String): Observable<BaseResponse<PenjelasanResponseItem>>
}
