package com.example.searchbar.data

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JustDao {

    @Insert
    suspend fun insert(list: List<JustItem>)

    // docid is a primary key
    @Query("SELECT * FROM just_item JOIN just_item_fts ON (just_item._id = just_item_fts.docid)" +
            "WHERE just_item_fts MATCH :term")
    fun search(term:String):Cursor
}