package com.example.nikhilkaushik.quickfix;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    public static MainActivity fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fa=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1=(Button)findViewById(R.id.button2);
        btn2=(Button)findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), Main2Activity.class);
                startActivity(intent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), Main3Activity.class);
                startActivity(intent);
            }
        });
    }
    }



