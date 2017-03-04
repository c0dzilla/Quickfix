package com.example.nikhilkaushik.quickfix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.nikhilkaushik.quickfix.GlobalVariables.emailid;
import static com.example.nikhilkaushik.quickfix.GlobalVariables.identity;

public class Main3Activity extends AppCompatActivity {

    private static Button loginbutton;
    private static EditText mail;
    private static RadioGroup radio_g;
    private static RadioButton radio_b;
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        loginbutton=(Button)findViewById(R.id.button6);
        mail=(EditText)findViewById(R.id.editText8);
        radio_g=(RadioGroup)findViewById(R.id.radio2);







        loginbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String m=mail.getText().toString();
                emailid=m;

                listView1 = (ListView) findViewById(R.id.list2);

                ApiGet2.Factory.getInstance().getRequest(emailid).enqueue(new Callback<Example2>() {
                    @Override
                    public void onResponse(Call<Example2> call, Response<Example2> response) {
                        List<Messages> list = response.body().getRequest();
                        ArrayList<Messages> arrayList = new ArrayList<Messages>();
                        for (Messages r : list) {
                            arrayList.add(new Messages(r.getTitle(), r.getAcc_email()));
                        }
                        ArrayListAdapter2 adapter = new ArrayListAdapter2(Main3Activity.this, arrayList);
                        listView1.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<Example2> call, Throwable t) {
                        Log.e("Request", "Unsuccessful");
                    }
                });




                int selected_id = radio_g.getCheckedRadioButtonId();
                identity=selected_id;
                radio_b = (RadioButton)findViewById(selected_id);
                ApiCall2.Factory.getInstance().Login(m).enqueue(
                        new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                Toast.makeText(Main3Activity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.e("TAG",t.getMessage());
                                Toast.makeText(Main3Activity.this, "Fail", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                if (radio_b==(RadioButton)findViewById(R.id.radioButton2)) {
                    Intent intent1 = new Intent(view.getContext(), Main4Activity.class);
                    startActivity(intent1);
                    finish();
                    MainActivity.fa.finish();
                }
                else if (radio_b==(RadioButton)findViewById(R.id.radioButton)){
                    Intent intent1 = new Intent(view.getContext(), Main6Activity.class);
                    startActivity(intent1);
                    finish();
                    MainActivity.fa.finish();
                }
            }
        });
    }
}
