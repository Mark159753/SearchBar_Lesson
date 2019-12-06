package com.example.searchbar.activitys.main

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.example.searchbar.R
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

        viewModel = ViewModelProviders.of(this,
            MyViewModelFactory(
                Repository(
                    MyDataBase(this)
                )
            )
        )
            .get(MainViewModel::class.java)

        val toolbar = findViewById<Toolbar>(R.id.actionBar)
        setSupportActionBar(toolbar)

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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.menu_search)
        val searchView = searchItem?.actionView as androidx.appcompat.widget.SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.e("TEXT", newText)
                return false
            }
        })
        return true
    }



    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}
