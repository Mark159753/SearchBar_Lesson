package com.example.searchbar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [JustItem::class, JustItemFts::class], version = 1)
abstract class MyDataBase: RoomDatabase() {

    abstract fun getJustDao():JustDao

    companion object{
        @Volatile
        private var instant:MyDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instant ?: synchronized(LOCK){
            instant ?: buildDatabase(context).also { instant = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                MyDataBase::class.java,
                "my_dadabase")
                .build()
    }
}