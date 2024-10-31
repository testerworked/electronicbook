package com.sample.electronicbook

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var bookTV: TextView
    private lateinit var bookContentTV: TextView
    private lateinit var  bDownload: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bDownload = findViewById(R.id.loadB)
        bookTV = findViewById(R.id.header_title)
        bookContentTV = findViewById(R.id.bookContentTV)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onToggleClicked(view: View){
        val on = (view as ToggleButton).isChecked
        if(on){
            val bookContent = loadBook(Database.text)
            bookContentTV.text = bookContent.joinToString(" ")
            View.VISIBLE
            Toast.makeText(this,"Книга загружена",Toast.LENGTH_LONG).show()
        }else{
            bookContentTV.text = ""
            View.GONE
            Toast.makeText(this,"Книга выгружена",Toast.LENGTH_LONG).show()
        }
    }

    private fun loadBook(text: String): List<String> {
        return text.split(" ")
    }
}

