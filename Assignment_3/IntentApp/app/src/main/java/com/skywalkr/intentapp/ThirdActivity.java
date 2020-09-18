package com.skywalkr.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class ThirdActivity extends AppCompatActivity {

    Button btn3;
    EditText et3;
    String st3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btn3= (Button) findViewById(R.id.btn3);
        et3=findViewById(R.id.ed3);

        st3= Objects.requireNonNull(getIntent().getExtras()).getString("Value");
        et3.setText(st3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(ThirdActivity.this,MainActivity.class);
                st3 = et3.getText().toString();
                i3.putExtra("Value", st3);
                startActivity(i3);
                finish();
            }
        });
    }
}