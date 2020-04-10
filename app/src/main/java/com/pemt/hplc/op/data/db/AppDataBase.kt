package com.pemt.hplc.op.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pemt.hplc.op.user.model.db.User
import com.pemt.hplc.op.user.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun getUserDao(): UserDao
}