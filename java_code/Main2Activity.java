package com.example.nikhilkaushik.quickfix;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static com.example.nikhilkaushik.quickfix.GlobalVariables.emailid;


public class Main2Activity extends AppCompatActivity {

    private static   Button button;
    private static EditText username ;
    private static EditText email ;
    private static EditText  city;
    private static RadioGroup radio_g;
    private static RadioButton radio_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=(Button)findViewById(R.id.button4);
        username =(EditText)findViewById(R.id.editText4);
        email=(EditText)findViewById(R.id.editText6);
        city=(EditText)findViewById(R.id.editText7);

        radio_g = (RadioGroup)findViewById(R.id.radio);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String m=email.getText().toString();
                String c=city.getText().toString();
                emailid=m;

                int selected_id = radio_g.getCheckedRadioButtonId();
                radio_b = (RadioButton)findViewById(selected_id);
                String r=radio_b.getText().toString();
               ApiCall.Factory.getInstance().Signup(user,m,c,r).enqueue(
                        new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                Toast.makeText(Main2Activity.this, "Signup Successful", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.e("TAG", t.getMessage());
                                Toast.makeText(Main2Activity.this, "Fail", Toast.LENGTH_SHORT).show();
                            }
                        }
         );

                Intent intent=new Intent(view.getContext(), Main3Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
