package com.vinayak.blooddonner.Fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vinayak.blooddonner.Api;
import com.vinayak.blooddonner.R;

public class Blood_req extends AppCompatActivity {

    private EditText retunit, retgrp, retcnt, retfname, retlname, retcond;
    Button retsub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_req);

        retunit = (EditText)findViewById(R.id.reg_unit);
        retgrp = (EditText)findViewById(R.id.reg_grp);
        retcnt = (EditText)findViewById(R.id.reg_contact);
        retfname = (EditText)findViewById(R.id.reg_fname);
        retlname = (EditText)findViewById(R.id.reg_lname);
        retcond = (EditText)findViewById(R.id.reg_condition);
        retsub = (Button)findViewById(R.id.req_sub);

        BottomNavigationView bottomNavigationView = findViewById(R.id.b_nav);

        bottomNavigationView.setSelectedItemId(R.id.req);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Hm_details.class));
                        overridePendingTransition(0,0);
                        return true;

//                    case R.id.map:
//                        startActivity(new Intent(getApplicationContext(),Bank_map.class));
//                        overridePendingTransition(0,0);
//                        return true;

                    case R.id.req:
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        retsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reqForm();
                Toast.makeText(Blood_req.this, "Request Sent Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void reqForm() {

        final String unit = retunit.getText().toString();
        final String group = retgrp.getText().toString();
        final String contact = retcnt.getText().toString();
        final String fname = retfname.getText().toString();
        final String lname = retlname.getText().toString();
        final String condition = retcond.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.REQUEST)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<String> call = api.requestForm(unit,group,contact,fname,lname,condition);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}