package com.fsh.mvc_mvp_mvvm_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.fsh.mvc_mvp_mvvm_project.normal.NormalActivity;
import com.fsh.mvc_mvp_mvvm_project.mvc.MVCActivity;
import com.fsh.mvc_mvp_mvvm_project.mvp.MVPActivity;
public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, NormalActivity.class));
//                startActivity(new Intent(MainActivity.this, MVCActivity.class));
                startActivity(new Intent(MainActivity.this, MVPActivity.class));
            }
        });

    }
}