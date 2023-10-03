package com.bitcodetech.volleypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WebUtil(this).postNameAndJob(
            "Vishal", "Trainer"
        )

    }
}