package com.example.searchbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.searchbar.data.JustItem
import com.example.searchbar.data.MyDataBase
import com.example.searchbar.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, MyViewModelFactory(Repository(MyDataBase(this))))
            .get(MainViewModel::class.java)

        insert_btn.setOnClickListener { insert() }
        search_btn.setOnClickListener { search(String.format("*%s*", "fuc")) }
    }


    private fun insert() = scope.launch {
        val list = listOf<JustItem>(
            JustItem(null, "Hello Mark"),
            JustItem(null, "Hell from hell"),
            JustItem(null, "fuck off man"),
            JustItem(null, "your fuck"),
            JustItem(null, "good day"),
            JustItem(null, "go to Hell"),
            JustItem(null, "Hi, Hello"),
            JustItem(null, "HellCom"),
            JustItem(null, "Yesterday"),
            JustItem(null, "die but not today")
        )

        viewModel.insert(list)
    }

    private fun search(term:String) = scope.launch {
        val res = viewModel.search(term)
        Log.e("LIST", res.toString())
    }


    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}
