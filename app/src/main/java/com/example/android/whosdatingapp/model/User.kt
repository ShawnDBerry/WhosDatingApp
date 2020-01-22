package com.example.android.whosdatingapp.model

class User {
    var usersId: Int? = null
    var userName: String = ""
    var userAge: String = ""
    var userLocation: String = ""
    var occupation: String = ""
    var gender: String = ""
    var matches: List<User>? = null
    var messages: List<Message>? = null
}