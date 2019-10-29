package com.example.learncodefromppcandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    @BindView(R.id.btn_test)
    Button btnTest;

    @BindString(R.string.test_string)
    String testButKnifeString;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("HEY","I wanna make some changes to know in detail Git");
        ButterKnife.bind(this);
        btnTest.setOnClickListener(v -> Log.e(TAG, "onClick: yes" ));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
