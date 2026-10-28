package com.example.vedatechnologyinternshipcompanionapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InternshipViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).internshipDao()
    val allInternships: LiveData<List<InternshipItem>> = dao.getAllInternships()

    fun insert(item: InternshipItem) = viewModelScope.launch(Dispatchers.IO) {
        dao.insert(item)
    }
}