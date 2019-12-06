package com.example.searchbar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "just_item")
data class JustItem (
    @PrimaryKey(autoGenerate = true)
    var _id:Int? = null,
    val value:String
)