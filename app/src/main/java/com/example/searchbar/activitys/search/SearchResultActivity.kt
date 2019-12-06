package com.example.searchbar.activitys.search

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import com.example.searchbar.R

class SearchResultActivity : AppCompatActivity() {

    private lateinit var textViewSearchResult:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        textViewSearchResult = findViewById(R.id.search_result)
        if (Intent.ACTION_SEARCH == intent.action){
            Log.e("SS", "SS")
            handleSearch(intent.getStringExtra(SearchManager.QUERY))
        }
    }


    private fun handleSearch(searchQuery:String){
        Log.e("SEARCH", searchQuery)
    }
}
