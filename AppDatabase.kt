package com.example.vedatechnologyinternshipcompanionapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [InternshipItem::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun internshipDao(): InternshipDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "internship_database"
                )
                    .fallbackToDestructiveMigration() // Rebuilds database cleanly when schema updates
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}