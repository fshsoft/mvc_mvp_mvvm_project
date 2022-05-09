package com.fsh.mvc_mvp_mvvm_project.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fsh.mvc_mvp_mvvm_project.bean.AccountInfo;
import com.fsh.mvc_mvp_mvvm_project.R;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 需求：1、获取用户输入的信息
 *      2、展示获取信息成功 or失败界面
 */
public class MVPActivity extends AppCompatActivity implements View.OnClickListener,IMVPView {
    private TextView mTVResult;
    private Button mBTGetAccount;
    private EditText mETAccount;
    private MVPPresenter mvpPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();

        mvpPresenter = new MVPPresenter(this);
    }

    private void initView(){
        mTVResult = findViewById(R.id.tv_result);
        mETAccount = findViewById(R.id.et_account);
        mBTGetAccount = findViewById(R.id.bt_getAccount);
        mBTGetAccount.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        mvpPresenter.getData(getUserInput());
    }

    @Override
    public String getUserInput() {
        return mETAccount.getText().toString().trim();
    }

    @Override
    public void showSuccessPage(AccountInfo accountInfo) {
        mTVResult.setText("用户账号："+ accountInfo.getName()+"|"+"用户等级："+ accountInfo.getLevel());
    }

    @Override
    public void showFailedPage() {
        mTVResult.setText("获取数据失败");
    }
}
