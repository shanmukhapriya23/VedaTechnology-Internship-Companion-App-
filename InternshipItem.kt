package com.example.vedatechnologyinternshipcompanionapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "internships")
data class InternshipItem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val company: String,
    val description: String,        // Short summary for the list view
    val fullDescription: String     // Detailed 15-line info for the detail view
)