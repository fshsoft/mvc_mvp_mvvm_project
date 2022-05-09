package com.fsh.mvc_mvp_mvvm_project.mvp;
import com.fsh.mvc_mvp_mvvm_project.bean.AccountInfo;

public interface IMVPView {

    String getUserInput();
    void showSuccessPage(AccountInfo accountInfo);
    void showFailedPage();
}
