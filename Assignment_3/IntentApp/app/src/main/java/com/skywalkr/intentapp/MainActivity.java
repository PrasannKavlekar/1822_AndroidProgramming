package com.skywalkr.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText et1;
    String st1=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.btn1);
        et1=findViewById(R.id.ed1);
        Bundle b = getIntent().getExtras();
        if(b!=null){
            st1= b.getString("Value");
            et1.setText(st1);
        }
        
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity.this,SecondActivity.class);
                st1 = et1.getText().toString();
                i1.putExtra("Value", st1);
                startActivity(i1);
                finish();
            }
        });
    }
}