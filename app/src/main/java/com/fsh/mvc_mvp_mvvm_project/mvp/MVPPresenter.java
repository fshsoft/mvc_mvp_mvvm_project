package com.fsh.mvc_mvp_mvvm_project.mvp;

import com.fsh.mvc_mvp_mvvm_project.bean.AccountInfo;
import com.fsh.mvc_mvp_mvvm_project.callback.MCallBack;

/**
 * MVPPresenter持有IMVPView和MVPModel的引用
 */
public class MVPPresenter {
    private IMVPView mView;
//    private MVPModel mMode;
    private MVPModel2 mMode;

    public MVPPresenter(IMVPView mView) {
        this.mView = mView;
//        mMode = new MVPModel();
        mMode = new MVPModel2();
    }

    public void getData(String accountName) {
        mMode.getAccountData(accountName, new MCallBack() {
            @Override
            public void onSuccess(AccountInfo account) {
                mView.showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                mView.showFailedPage();
            }
        });
    }
}
