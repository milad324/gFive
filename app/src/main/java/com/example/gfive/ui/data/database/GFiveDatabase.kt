package com.example.gfive.ui.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gfive.ui.data.database.entities.GroupEntity
import com.example.gfive.util.Constants.Companion.DATABASE_NAME


@Database(
    entities = [GroupEntity::class], version = 1, exportSchema = false
)
abstract class GFiveDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: GFiveDatabase? = null
        fun getInstance(context: Context): GFiveDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GFiveDatabase::class.java,
                        DATABASE_NAME
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}