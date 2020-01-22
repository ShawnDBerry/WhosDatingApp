package com.example.android.whosdatingapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.whosdatingapp.R
import com.example.android.whosdatingapp.model.User
import kotlinx.android.synthetic.main.user_item_view.view.*

class ActiveUsersAdapter(private var userList: List<User>, private var applicationContext: Context) : RecyclerView.Adapter<ActiveUsersAdapter.ActiveUserHolder>() {

    class ActiveUserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: ImageView = itemView.user_image
        val userName: TextView = itemView.user_name
        val userAge: TextView = itemView.user_age
        val userLocation: TextView = itemView.user_location
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveUserHolder {
        Log.d("TAG_Q", "in the create view holder")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_view, parent, false)
        return ActiveUserHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ActiveUserHolder, position: Int) {

        holder.userName.text = userList[position].userName
        holder.userAge.text = userList[position].userAge
        holder.userLocation.text = userList[position].userLocation
    }

}