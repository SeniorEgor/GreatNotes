package com.example.greatnotes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.greatnotes.database.firebase.AppFirebaseRepository
import com.example.greatnotes.database.room.AppRoomDatabase
import com.example.greatnotes.database.room.AppRoomRepository
import com.example.greatnotes.utilits.REPOSITORY
import com.example.greatnotes.utilits.TYPE_FIREBASE
import com.example.greatnotes.utilits.TYPE_ROOM
import com.example.greatnotes.utilits.showToast

class StartFragmentViewModel(application: Application):AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }

            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({ onSuccess() }, { showToast(it) })
            }
        }
    }
}