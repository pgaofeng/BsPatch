package com.study.bspatch.main

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.study.basemvp.R
import com.study.bspatch.PatchUtils

/**
 * @author gaofengpeng
 * @date 20121/9/3
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mTvText: TextView
    private lateinit var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTvText = findViewById(R.id.tv_myText)
        mButton = findViewById(R.id.btn_update)
        init()
    }

    private fun init() {
        mButton.setOnClickListener {
            mTvText.text = PatchUtils.md5sum(applicationInfo.sourceDir)
        }
    }
}