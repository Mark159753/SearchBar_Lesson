package com.example.searchbar.adapter

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.cursoradapter.widget.CursorAdapter
import com.example.searchbar.R

class SearchCursorAdapter(
    context: Context,
    cursor: Cursor?
): CursorAdapter(context, cursor, 0) {

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.search_item, parent, false)
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        if (cursor == null) return
        val text = cursor.getString(cursor.getColumnIndex("value"))

        val textView = view!!.findViewById<TextView>(R.id.text_item)
        textView.text = text
    }
}