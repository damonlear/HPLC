package com.pemt.hplc.op.user.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.pemt.hplc.op.user.model.db.User

@Dao
interface UserDao {

    @Query("select * from user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertAll(vararg user: User)

    @Delete
    suspend fun deleteAll(vararg user: User)

}