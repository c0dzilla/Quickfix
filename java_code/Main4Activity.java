package com.example.nikhilkaushik.quickfix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.nikhilkaushik.quickfix.GlobalVariables.emailid;

public class Main4Activity extends AppCompatActivity {

    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button = (Button) findViewById(R.id.button5);

        listView = (ListView) findViewById(R.id.list);

        ApiGet.Factory.getInstance().getRequest(emailid).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                List<Request> list = response.body().getRequest();
                ArrayList<Request> arrayList = new ArrayList<Request>();
                for (Request r : list) {
                    arrayList.add(new Request(r.getTitle(), r.getBrief(), r.getDate(), r.getAddress()));
                }
                ArrayListAdapter adapter = new ArrayListAdapter(Main4Activity.this, arrayList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("Request", "Unsuccessful");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Main5Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
