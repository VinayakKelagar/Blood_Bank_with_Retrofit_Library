package com.vinayak.blooddonner.Fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vinayak.blooddonner.Adapter.DonnerAdapter;
import com.vinayak.blooddonner.Client.RetrofitClient;
import com.vinayak.blooddonner.Module.Donner_Module;
import com.vinayak.blooddonner.R;
import com.vinayak.blooddonner.Response.FetchDonner;

import java.util.List;

public class Hm_details extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Donner_Module> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hm_details);

        BottomNavigationView bottomNavigationView = findViewById(R.id.b_nav);

        recyclerView=findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        return true;

//                    case R.id.map:
//                        startActivity(new Intent(getApplicationContext(), Bank_map.class));
//                        overridePendingTransition(0,0);
//                        return true;

                    case R.id.req:
                        startActivity(new Intent(getApplicationContext(), Blood_req.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //retrofit

        Call<FetchDonner> call= RetrofitClient.getInstance().getApi().fetchAllUsers();

        call.enqueue(new Callback<FetchDonner>() {
            @Override
            public void onResponse(Call<FetchDonner> call, Response<FetchDonner> response) {

                if(response.isSuccessful()){

                    userList=response.body().getUserList();
                    recyclerView.setAdapter(new DonnerAdapter(getApplicationContext(),userList));

                }
                else{
                    Toast.makeText(getApplicationContext(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<FetchDonner> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}