package com.fsh.mvc_mvp_mvvm_project.callback;
import com.fsh.mvc_mvp_mvvm_project.bean.AccountInfo;
/**
 * 定义一个接口，回调方法，来通知用户查询的结果
 */
public interface MCallBack {
    void onSuccess(AccountInfo account);
    void onFailed();
}
