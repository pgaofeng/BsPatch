package com.pgaofeng.basemvp.main;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pgaofeng.basemvp.R;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description :View界面，只负责显示。逻辑处理由Presenter负责。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
