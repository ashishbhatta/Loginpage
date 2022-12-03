package com.example.affirmations

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginpage)
        val username = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.password)
        val button = findViewById<View>(R.id.button)

        button.setOnClickListener{
            if(username.text.toString() == "abc@xyz.com" && password.text.toString() == "welcome")
            {
                setContentView(R.layout.activity_main)

                // Initialize data.
                val myDataset = Datasource().loadAffirmations()

                val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
                recyclerView.adapter = ItemAdapter(this, myDataset)

                // Use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                recyclerView.setHasFixedSize(true)
            }
            else{
                Toast.makeText(this, "Incorrect login Detail", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
