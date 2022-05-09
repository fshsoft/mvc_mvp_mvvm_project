package com.fsh.mvc_mvp_mvvm_project.mvp;

import com.fsh.mvc_mvp_mvvm_project.bean.AccountInfo;
import com.fsh.mvc_mvp_mvvm_project.callback.MCallBack;

import java.util.Random;

/**
 * 查询账号数据 Model数据模型
 * 数据的获取和界面展示进行分离
 */
public class MVPModel2 implements IMVPModel {

    @Override
    public void getAccountData(String accountName, MCallBack mCallBack) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if(isSuccess){
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setName(accountName);
            accountInfo.setLevel(90);
            mCallBack.onSuccess(accountInfo);
        }else {
            mCallBack.onFailed();
        }
    }
}
