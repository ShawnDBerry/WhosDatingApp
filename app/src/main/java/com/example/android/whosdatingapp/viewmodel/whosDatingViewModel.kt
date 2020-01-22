package com.example.android.whosdatingapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.android.whosdatingapp.model.Message
import com.example.android.whosdatingapp.model.User
import com.example.android.whosdatingapp.util.Contstants
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class whosDatingViewModel(application: Application) : AndroidViewModel(application) {

    private var userReference = FirebaseDatabase
        .getInstance().getReference(Contstants().DATA_BASE)

    private var userMutableLiveData = MutableLiveData<User>()
    private var messageMutableLiveData = MutableLiveData<Message>()

    init {
        userReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(databaseSnapshot: DataSnapshot) {
                Log.d("TAG_Q", "log message: " + databaseSnapshot.children)
                for(currentData: DataSnapshot in databaseSnapshot.children) {
                    Log.d("TAG_Q", "log message: " + 100)
                    userMutableLiveData.value = currentData.getValue(User::class.java)
                    messageMutableLiveData.value = currentData.getValue(Message::class.java)
                }
            }

            override fun onCancelled(dataError: DatabaseError) {
                Log.d("TAG_Q", "log error message: " + dataError.message)
            }
        })
    }

    fun createUser(user: User){
        val childKey = userReference.push().key
        if(childKey != null){
            userReference.child(childKey).setValue(user)
        }
    }

    fun getLiveDataUser(): MutableLiveData<User>{
        return userMutableLiveData
    }

}