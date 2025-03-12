package com.study.bspatch.main

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.study.bspatch.PatchUtils
import com.study.bspatch.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * @author gaofengpeng
 * @date 2021/9/3
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mTvText: TextView
    private lateinit var mButton: Button
    private lateinit var mButtonToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTvText = findViewById(R.id.tv_myText)
        mButton = findViewById(R.id.btn_update)
        mButtonToast = findViewById(R.id.btn_version)
        init()
    }

    private fun init() {
        // 用于创建cache目录，方便将patch文件放在Android/data/com.study.bspatch/cache目录
        try {
            File(externalCacheDir!!.absolutePath)
        } catch (ignore: Exception) {
        }
        // 可以修改这里文本，然后打包两个不同的安装包
        mButtonToast.setOnClickListener {
            Toast.makeText(this, "我现在是新版本了哦哈哈哈哈哈", Toast.LENGTH_SHORT).show()
        }

        mButton.setOnClickListener {
            val patchFile = File("$externalCacheDir/patch")
            if (!patchFile.exists()) {
                mTvText.text = "未找到分包文件patch，请将其放在{$externalCacheDir}目录下"
                return@setOnClickListener
            }

            lifecycleScope.launch {
                mTvText.text = "开始合并安装包..."
                val last = System.currentTimeMillis()
                val isSuccess = withContext(Dispatchers.IO) {
                    PatchUtils.bsPatch(
                        newFile = "$externalCacheDir/output.apk",
                        oldFile = applicationInfo.sourceDir,
                        patch = "$externalCacheDir/patch"
                    )
                }
                if (isSuccess) {
                    val cost = System.currentTimeMillis() - last
                    mTvText.text = "合并完成，耗时: $cost ms"
                } else {
                    mTvText.text = "合并失败"
                }
            }
        }
    }
}