package com.example.searchbar.activitys.search

import android.app.SearchManager
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.example.searchbar.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

class SearchResultActivity : AppCompatActivity() {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private lateinit var textViewSearchResult:ListView
    private val cursor = MutableLiveData<Cursor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        textViewSearchResult = findViewById(R.id.search_result)
        if (Intent.ACTION_SEARCH == intent.action){
            Log.e("SS", "SS")
            handleSearch(intent.getStringExtra(SearchManager.QUERY))
        }
    }


    private fun handleSearch(searchQuery:String?){
        searchQuery ?: return
        Log.e("SEARCH", searchQuery)
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}
