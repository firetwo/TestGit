package com.example.learncodefromppcandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learncodefromppcandroid.Common.Constant_Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.edt_input_data)
    EditText edtInputData;

    @BindView(R.id.tv_result)
    TextView tvResult;

    @BindView(R.id.btn_send_data)
    Button btnSendData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        Log.e("Update","First Acitivity");
        btnSendData.setOnClickListener(v -> {
            String input_data = edtInputData.getText().toString().trim();
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("input_data", input_data);
            intent.putExtras(bundle);
            startActivityForResult(intent, Constant_Util.REQUEST_CODE);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant_Util.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                tvResult.setText(bundle.getString("result"));
            }
        }
    }
}
