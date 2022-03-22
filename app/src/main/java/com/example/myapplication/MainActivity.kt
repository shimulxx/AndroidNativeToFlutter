package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    //https://stackoverflow.com/questions/65641985/no-implementation-method-found-for-method-error
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.appButton)
        button.setOnClickListener {
            Log.d(TAG,"Clicked")
            val intent = FlutterActivity.NewEngineIntentBuilder(MyFlutterActivity::class.java).build(applicationContext)
            intent.putExtra("tag", "FARUQ")
            startActivity(intent);
        }
    }
}