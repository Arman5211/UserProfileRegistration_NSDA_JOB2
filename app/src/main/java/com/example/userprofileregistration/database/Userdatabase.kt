package com.example.userprofileregistration.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userprofileregistration.dao.UserProfileDao
import com.example.userprofileregistration.model.UserProfile

@Database(entities = [UserProfile::class], version = 1)
abstract class Userdatabase : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao

    companion object {
        @Volatile
        private var INSTANCE: Userdatabase? = null

        fun getDatabase(context: Context): Userdatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Userdatabase::class.java,
                    "user_profile_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}