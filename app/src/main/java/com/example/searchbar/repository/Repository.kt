package com.example.searchbar.repository

import com.example.searchbar.data.JustItem
import com.example.searchbar.data.MyDataBase

class Repository(
    dataBase: MyDataBase
) {
    private val dao = dataBase.getJustDao()

    suspend fun insert(list: List<JustItem>){
        dao.insert(list)
    }

    suspend fun search(term:String) = dao.search(term)
}