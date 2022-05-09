package com.fsh.mvc_mvp_mvvm_project.mvvm;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fsh.mvc_mvp_mvvm_project.R;
import com.fsh.mvc_mvp_mvvm_project.databinding.ActivityMvvmBinding;
/**
 * 需求：1、获取用户输入的信息
 *      2、展示获取信息成功 or失败界面
 */
public class MVVMActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);
        //初始化绑定viewModel
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        MVVMViewModel mvvmViewModel = new MVVMViewModel(this);
        binding.setViewModel(mvvmViewModel);
    }
}
