package com.example.searchbar.data

import androidx.room.Entity
import androidx.room.Fts4

@Fts4(contentEntity = JustItem::class)
@Entity(tableName = "just_item_fts")
data class JustItemFts(
    val value:String
)