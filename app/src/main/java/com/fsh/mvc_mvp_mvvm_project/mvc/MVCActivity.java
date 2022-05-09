package com.fsh.mvc_mvp_mvvm_project.mvc;

import androidx.appcompat.app.AppCompatActivity;
import com.fsh.mvc_mvp_mvvm_project.R;
import com.fsh.mvc_mvp_mvvm_project.bean.AccountInfo;
import com.fsh.mvc_mvp_mvvm_project.callback.MCallBack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * MVC框架
 * MVCActivity要实现的功能：
 * 1、获取用户输入
 * 2、展示获取信息成功 or失败界面
 * 3、业务逻辑处理
 */
public class MVCActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTVResult;
    private Button mBTGetAccount;
    private EditText mETAccount;
    //MVCActivity必须持有MVCModel的引用
    private MVCModel mvcModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
        mvcModel = new MVCModel();
    }

    private void initView(){
        mTVResult = findViewById(R.id.tv_result);
        mETAccount = findViewById(R.id.et_account);
        mBTGetAccount = findViewById(R.id.bt_getAccount);
        mBTGetAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mvcModel.getAccountData(getUserInput(), new MCallBack() {
            @Override
            public void onSuccess(AccountInfo account) {
                showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                showFailedPage();
            }
        });
    }


    //获取用户输入的信息
    private String getUserInput(){
        return mETAccount.getText().toString().trim();
    }

    //展示获取数据成功的界面
    private void showSuccessPage(AccountInfo accountInfo){
        mTVResult.setText("用户账号："+ accountInfo.getName()+"|"+"用户等级："+ accountInfo.getLevel());
    }

    //展示获取数据失败的界面
    private void showFailedPage(){
        mTVResult.setText("获取数据失败");
    }
}