package com.fyrl29074.cat_gram.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fyrl29074.cat_gram.R

class CatRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CatsFragment.newInstance())
                .commitNow()
        }
    }
}