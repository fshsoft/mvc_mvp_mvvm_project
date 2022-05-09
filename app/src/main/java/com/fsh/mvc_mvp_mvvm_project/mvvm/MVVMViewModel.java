package com.fsh.mvc_mvp_mvvm_project.mvvm;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.fsh.mvc_mvp_mvvm_project.BR;
import com.fsh.mvc_mvp_mvvm_project.bean.AccountInfo;
import com.fsh.mvc_mvp_mvvm_project.callback.MCallBack;

public class MVVMViewModel extends BaseObservable {
    private MVVMModel mvvmModel;
    private String result;
    private String userInput;

    public MVVMViewModel(Context context){
        mvvmModel = new MVVMModel();
    }


    public void getData(View view){

        mvvmModel.getAccountData(userInput, new MCallBack() {
            @Override
            public void onSuccess(AccountInfo account) {
                String info = account.getName()+"|"+account.getLevel();
                setResult(info);
            }

            @Override
            public void onFailed() {
                setResult("获取用户数据失败");

            }
        });
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }
    @Bindable
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        notifyPropertyChanged(BR.userInput);
    }
}
