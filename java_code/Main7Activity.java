package com.example.nikhilkaushik.quickfix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.example.nikhilkaushik.quickfix.GlobalVariables.emailid;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Intent intent =getIntent();

        TextView tv20=(TextView)findViewById(R.id.textView20);
        String  date =intent.getStringExtra("date");
        tv20.setText(date);

        TextView tv22=(TextView)findViewById(R.id.textView22);
        String title =intent.getStringExtra("title");
        tv22.setText(title);

        TextView tv21=(TextView)findViewById(R.id.textView21);
        String address =intent.getStringExtra("address");
        tv21.setText(address);


        Button b7=(Button)findViewById(R.id.button7);

        TextView tv3=(TextView)findViewById(R.id.textView3);
        String description=intent.getStringExtra("description");
        tv3.setText(description);

        Button b10=(Button)findViewById(R.id.button10);
        final  String id=intent.getStringExtra("id");




        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           String id1 =id;

                ApiCall3.Factory.getInstance().accept(id1,emailid).enqueue(
                        new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                Toast.makeText(Main7Activity.this, "Request Accepted", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.e("TAG",t.getMessage());
                                Toast.makeText(Main7Activity.this, "Failed To Accept Request", Toast.LENGTH_SHORT).show();
                            }
                        }
                );

                finish();
            }
        });


        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });







    }


}
