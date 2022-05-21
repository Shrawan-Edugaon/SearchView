package com.example.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val search  = findViewById<SearchView>(R.id.searchView) as SearchView
        val list = findViewById<ListView>(R.id.listView) as ListView
        val countries = arrayOf("India","USA","China","Sri Lanka","Ireland","Germany","France","Nepal","Brazil","England")
        val countryAdap:ArrayAdapter<String> =
            ArrayAdapter(this,android.R.layout.simple_list_item_1,countries)
        list.adapter = countryAdap
        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
              return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                countryAdap.filter.filter(newText)
                return false
            }
        })
    }
}