package com.fsh.mvc_mvp_mvvm_project.mvp;

import com.fsh.mvc_mvp_mvvm_project.callback.MCallBack;

public interface IMVPModel {

    void getAccountData(String accountName, MCallBack mCallBack);
}
