package com.example.learncodefromppcandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.edt_input_data)
    EditText edtInputData;

    @BindView(R.id.tv_result)
    TextView tvResult;

    @BindView(R.id.btn_send_back)
    Button btnSendBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        tvResult.setText(getIntent().getExtras().getString("input_data"));

        btnSendBack.setOnClickListener(v -> {
            String input_data = edtInputData.getText().toString().trim();
            Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("result", input_data);
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
        });
    }
}
