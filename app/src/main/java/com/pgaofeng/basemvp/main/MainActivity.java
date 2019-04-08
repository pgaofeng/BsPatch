package com.pgaofeng.basemvp.main;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pgaofeng.basemvp.R;
import com.pgaofeng.common.base.BaseActivity;


/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description :View界面，只负责显示。逻辑处理由Presenter负责。
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    TextView mTextView;
    Button mButton;


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTextView = findViewById(R.id.tv_myText);
        mButton = findViewById(R.id.btn_update);
        // 示例，通过点击按钮请求http://www.example.com/api?id=success
        // 该请求为假请求，访问不通，这里只是模拟
        mButton.setOnClickListener(v ->
                mPresenter.updateTextViewText()
        );
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void updateText(String text) {
        mTextView.setText(text);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
