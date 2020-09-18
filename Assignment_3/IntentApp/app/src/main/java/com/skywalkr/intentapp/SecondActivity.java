package com.skywalkr.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    Button btn2;
    EditText et2;
    String st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn2=(Button) findViewById(R.id.btn2);
        et2=findViewById(R.id.ed2);

        st2= Objects.requireNonNull(getIntent().getExtras()).getString("Value");
        et2.setText(st2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(SecondActivity.this,ThirdActivity.class);
                st2 = et2.getText().toString();
                i2.putExtra("Value", st2);
                startActivity(i2);
                finish();
            }
        });
    }
}