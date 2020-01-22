package com.example.android.whosdatingapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.whosdatingapp.R
import com.example.android.whosdatingapp.adapter.ActiveUsersAdapter
import com.example.android.whosdatingapp.model.User
import com.example.android.whosdatingapp.viewmodel.whosDatingViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userList = mutableListOf<User>()

    private var viewModel: whosDatingViewModel? = null

    private lateinit var userObserver: Observer<User>

    private var activeUserAdapter: ActiveUsersAdapter? = null

    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        userObserver = Observer { user ->
            userList.add(user)
            Log.d("TAG_Q", "in the observer")
            setUpRV(userList)
        }

        viewModel = ViewModelProviders.of(this).get(whosDatingViewModel::class.java)






       viewModel!!.getLiveDataUser().observe(this, userObserver!!)
        /*val user = User()
        user.userName = "Ian"
        user.userAge = "24"
        user.userLocation = "Colorodo, CO"
        user.occupation = "Android Developer"
        viewModel!!.createUser(user)*/



    }

    private fun setUpRV(userList: List<User>){
        Log.d("TAG_Q", "in the recyclerview")
        activeUserAdapter = ActiveUsersAdapter(userList, this)
        layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        active_user_recyclerview.adapter = activeUserAdapter
        active_user_recyclerview.layoutManager = layoutManager
        val decorater: RecyclerView.ItemDecoration = DividerItemDecoration(this, RecyclerView.HORIZONTAL)
        active_user_recyclerview.addItemDecoration(decorater)

    }

    fun addUser(user: User){
        Log.d("TAG_Q", "logUser "+ user)
    }
}
