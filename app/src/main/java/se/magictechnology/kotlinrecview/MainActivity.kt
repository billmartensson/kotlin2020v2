package se.magictechnology.kotlinrecview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var namesadapter = NamesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("BILLDEBUG", "ACTIVITY STARTED")

        namesRecview.layoutManager = LinearLayoutManager(this)
        namesRecview.adapter = namesadapter

        addNameBtn.setOnClickListener {
            namesadapter.addNewName(addNameET.text.toString())
            addNameET.setText("")
        }


    }




}