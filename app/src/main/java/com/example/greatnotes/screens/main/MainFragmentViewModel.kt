package com.example.greatnotes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.greatnotes.utilits.REPOSITORY


class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
}
