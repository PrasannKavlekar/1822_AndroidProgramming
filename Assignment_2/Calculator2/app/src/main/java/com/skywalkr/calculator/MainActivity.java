package com.skywalkr.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnMod, btnMul, btnDiv, btnAdd, btnSub, btnEqual, btnAC, btnCLR, btnDot;
    EditText ed1;
    float res1=0, res2=0;
    boolean decimal;
    String func;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btn0=(Button)findViewById(R.id.btn0);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnSub=(Button)findViewById(R.id.btnSub);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnDiv=(Button)findViewById(R.id.btnDiv);
        btnMod=(Button)findViewById(R.id.btnMod);
        btnEqual=(Button)findViewById(R.id.btnEqual);
        btnCLR=(Button)findViewById(R.id.btnCLR);
        btnAC=(Button)findViewById(R.id.btnAC);
        btnDot=(Button)findViewById(R.id.btnDot);
        ed1=(EditText)findViewById(R.id.editNum);

        //ButtonInputs
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ed1.setText(ed1.getText() +"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText() +"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText() +"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText() +"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText() +"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText() +"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText() +"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText() +"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText() +"9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText() +"0");
            }
        });

        //Functions
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }
                else{
                    res1=Float.parseFloat(ed1.getText() + "");
                    func="Add";
                    decimal=false;
                    ed1.setText(null);
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }
                else{
                    res1=Float.parseFloat(ed1.getText() + "");
                    func="Sub";
                    decimal=false;
                    ed1.setText(null);
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }
                else{
                    res1=Float.parseFloat(ed1.getText() + "");
                    func="Mul";
                    decimal=false;
                    ed1.setText(null);
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }
                else{
                    res1=Float.parseFloat(ed1.getText() + "");
                    func="Div";
                    decimal=false;
                    ed1.setText(null);
                }
            }
        });
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }
                else{
                    res1=Float.parseFloat(ed1.getText() + "");
                    func="Mod";
                    decimal=false;
                    ed1.setText(null);
                }
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decimal) {
                    //do nothing or you can show the error
                } else {
                    ed1.setText(ed1.getText() + ".");
                    decimal = true;
                }

            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res2=Float.parseFloat(ed1.getText() + "");
                if(func.equals("Add")){
                    ed1.setText(res1+res2+"");
                }
                else if(func.equals("Sub")){
                    ed1.setText(res1-res2+"");
                }
                else if(func.equals("Mul")){
                    ed1.setText(res1*res2+"");
                }
                else if(func.equals("Div")){
                    ed1.setText(res1/res2+"");
                }
                else if(func.equals("Mod")){
                    ed1.setText(res1%res2+"");
                }
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText("");
                res1=0;
                res2=0;
            }
        });

        btnCLR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String digit = (String.valueOf(ed1.getText()));
                if ((digit != null) && (digit.length() > 0)) {
                    String ldigit = digit.substring(0, digit.length() - 1);
                    ed1.setText(ldigit);
                }

            }
        });
    }
}