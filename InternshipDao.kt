package com.example.vedatechnologyinternshipcompanionapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InternshipDao {
    @Query("SELECT * FROM internships")
    fun getAllInternships(): LiveData<List<InternshipItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: InternshipItem)
}