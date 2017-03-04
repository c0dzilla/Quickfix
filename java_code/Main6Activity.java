package com.example.nikhilkaushik.quickfix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.nikhilkaushik.quickfix.GlobalVariables.emailid;

public class Main6Activity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        listView = (ListView) findViewById(R.id.list1);

        ApiGet1.Factory.getInstance().getRequest(emailid).enqueue(new Callback<Example1>() {
            @Override
            public void onResponse(Call<Example1> call, Response<Example1> response) {
                List<allrequest> list = response.body().getRequest();
                ArrayList<allrequest> arrayList = new ArrayList<allrequest>();
                for (allrequest r : list) {
                    arrayList.add(new allrequest(r.getTitle(), r.getBrief(), r.getDate(), r.getAddress(),r.getId()));
                }
                ArrayListAdapter1 adapter = new ArrayListAdapter1(Main6Activity.this, arrayList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Example1> call, Throwable t) {
                Log.e("Request", "Unsuccessful");
            }
        });

    }
}
