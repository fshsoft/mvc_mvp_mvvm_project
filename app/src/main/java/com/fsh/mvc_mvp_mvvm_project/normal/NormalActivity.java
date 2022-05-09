package com.fsh.mvc_mvp_mvvm_project.normal;

import com.fsh.mvc_mvp_mvvm_project.bean.AccountInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.fsh.mvc_mvp_mvvm_project.R;
import com.fsh.mvc_mvp_mvvm_project.callback.MCallBack;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 需求：1、获取用户输入的信息
 *      2、展示获取信息成功 or失败界面
 *      3、查询用户数据
 *      4、业务逻辑
 */
public class NormalActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTVResult;
    private Button mBTGetAccount;
    private EditText mETAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
    }

    private void initView(){
        mTVResult = findViewById(R.id.tv_result);
        mETAccount = findViewById(R.id.et_account);
        mBTGetAccount = findViewById(R.id.bt_getAccount);
        mBTGetAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = getUserInput();
        getAccountData(input, new MCallBack() {
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

    //模拟方式：查询用户数据
    private void getAccountData(String accountName,MCallBack mCallBack){
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if(isSuccess){
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setName(accountName);
            accountInfo.setLevel(100);
            mCallBack.onSuccess(accountInfo);
        }else {
            mCallBack.onFailed();
        }
    }
}
