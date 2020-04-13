package com.pemt.hplc.op.user.api

import com.pemt.hplc.op.config.Configs
//import com.pemt.hplc.op.home.model.ReceivedEventModel
//import com.pemt.hplc.op.repos.model.ReposItemModel
import com.pemt.hplc.op.user.model.*
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

//请求用户登陆的接口
interface UserApi {

    @PUT("authorizations/clients/{client_id}/{fingerprint}")
    suspend fun createOrGetAuthorization(
        @Body authorizationReqModel: AuthorizationReqModel, @Path("client_id") client_id: String, @Path("fingerprint") fingerprint: String
    ): AuthorizationRespModel

    @DELETE("authorizations/{id}")
    suspend fun deleteAuthorization(@Path("id") id: Int): Response<ResponseBody>

    @GET("user")
    suspend fun getUser(): UserModel

    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String, @Query("sort") sort: String, @Query("order") order: String, @Query("page") page: Int, @Query("per_page") per_page: Int = Configs.PAGE_SIZE): UserListModel

    @GET("users/{user}")
    suspend fun getUserInfo(@Path("user") user: String): UserInfoModel

//    @GET("users/{user}/repos")
//    suspend fun getUserPublicRepos(@Path("user") user: String, @Query("page") page: Int, @Query("per_page") per_page: Int = Configs.PAGE_SIZE): List<ReposItemModel>
//
//    @GET("users/{user}/starred")
//    suspend fun getStarredRepos(@Path("user") user: String, @Query("page") page: Int, @Query("per_page") per_page: Int = Configs.PAGE_SIZE): List<ReposItemModel>
//
//    @GET("users/{username}/received_events?")
//    suspend fun queryReceivedEvents(@Path("username") username: String,
//                                    @Query("page") page: Int,
//                                    @Query("per_page") perPage: Int = Configs.PAGE_SIZE): List<ReceivedEventModel>

}