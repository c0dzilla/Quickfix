package com.example.nikhilkaushik.quickfix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.nikhilkaushik.quickfix.GlobalVariables.emailid;

public class Main5Activity extends AppCompatActivity {

    private static Button button;
    private static EditText datefield;
    private static EditText titlefield;
    private static EditText brieffield;
    private static EditText addressfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        button=(Button)findViewById(R.id.button);
        datefield =(EditText)findViewById(R.id.editText);
        titlefield=(EditText)findViewById(R.id.editText2);
        brieffield=(EditText)findViewById(R.id.editText3);
        addressfield = (EditText) findViewById(R.id.editText5);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String date=datefield.getText().toString();
                String title=titlefield.getText().toString();
                String brief=brieffield.getText().toString();
                String address=addressfield.getText().toString();
                ApiCall1.Factory.getInstance().SendRequest(emailid,date,title,brief,address).enqueue(
                        new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                Toast.makeText(Main5Activity.this, "Request posted", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.e("TAG",t.getMessage());
                                Toast.makeText(Main5Activity.this, "Fail", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                Intent intent=new Intent(view.getContext(), Main4Activity.class);
                startActivity(intent);
               finish();
            }
        });
    }
}


