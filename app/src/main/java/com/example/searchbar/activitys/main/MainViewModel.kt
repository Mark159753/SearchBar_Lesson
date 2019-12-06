package com.example.searchbar.activitys.main

import androidx.lifecycle.ViewModel
import com.example.searchbar.data.JustItem
import com.example.searchbar.repository.Repository

class MainViewModel(private val repository: Repository): ViewModel(){

    suspend fun insert(list: List<JustItem>){
        repository.insert(list)
    }

    suspend fun search(term:String) = repository.search(term)
}