package com.pemt.hplc.op.user.repository
//
//import com.pemt.hplc.op.home.model.ReceivedEventModel
//import com.pemt.hplc.op.repos.model.ReposItemModel
import com.pemt.hplc.op.user.api.UserApi
import com.pemt.hplc.op.user.model.db.User
import com.pemt.hplc.op.user.dao.UserDao
import com.pemt.hplc.op.user.model.AuthorizationReqModel
import com.pemt.hplc.op.user.model.UserInfoModel
import com.pemt.hplc.op.user.model.UserListModel
import com.pemt.hplc.op.user.model.UserModel

class UserRepository(private val mUserApi: UserApi, private val mUserDao: UserDao) {

    suspend fun createOrGetAuthorization(
        authorizationReqModel: AuthorizationReqModel,
        client_id: String, fingerprint: String
    ) =
        mUserApi.createOrGetAuthorization(authorizationReqModel, client_id, fingerprint)

    suspend fun deleteAuthorization(id: Int) = mUserApi.deleteAuthorization(id)

    suspend fun getUser(): UserModel = mUserApi.getUser()

    suspend fun searchUsers(query: String, sort: String, order: String, page: Int): UserListModel =
        mUserApi.searchUsers(query, sort, order, page)

    suspend fun getUserInfo(user: String): UserInfoModel =
        mUserApi.getUserInfo(user)

//    suspend fun getUserPublicRepos(user: String, page: Int): List<ReposItemModel> =
//        mUserApi.getUserPublicRepos(user, page)
//
//    suspend fun getStarredRepos(user: String, page: Int): List<ReposItemModel> =
//        mUserApi.getStarredRepos(user, page)
//
//    suspend fun queryReceivedEvents(user: String, page: Int): List<ReceivedEventModel> =
//        mUserApi.queryReceivedEvents(user, page)

    suspend fun saveLocalUser(user: User) = mUserDao.insertAll(user)

    suspend fun getLocalUsers(): List<User> = mUserDao.getAll()

    suspend fun deleteLocalUser(user: User) = mUserDao.deleteAll(user)

}
