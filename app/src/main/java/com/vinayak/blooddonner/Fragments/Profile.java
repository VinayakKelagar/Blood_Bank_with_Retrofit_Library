package com.vinayak.blooddonner.Fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vinayak.blooddonner.Dev;
import com.vinayak.blooddonner.Login;
import com.vinayak.blooddonner.PreferenceHelper;
import com.vinayak.blooddonner.R;

public class Profile extends AppCompatActivity {

    private TextView tvname, tvemail, tvmobile, tvaddress;
    private Button btnlogout,dev;
    private PreferenceHelper preferenceHelper;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        preferenceHelper = new PreferenceHelper(this);

        tvname = (TextView) findViewById(R.id.prof_name);
        tvemail = (TextView) findViewById(R.id.prof_email);
        tvmobile = (TextView) findViewById(R.id.prof_mobile);
        tvaddress = (TextView) findViewById(R.id.prof_address);
        btnlogout = (Button) findViewById(R.id.btn);

        dev = (Button) findViewById(R.id.btn_dev);

        BottomNavigationView bottomNavigationView = findViewById(R.id.b_nav);

        tvname.setText("Welcome "+preferenceHelper.getName());
        tvemail.setText(" "+preferenceHelper.getEmail());
        tvmobile.setText(" "+preferenceHelper.getMobile());
        tvaddress.setText(" "+preferenceHelper.getAddress());


        bottomNavigationView.setSelectedItemId(R.id.profile);
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
                        startActivity(new Intent(getApplicationContext(),Blood_req.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Dev.class);
                startActivity(intent);
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferenceHelper.putIsLogin(false);
                Intent intent = new Intent(Profile.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Profile.this.finish();
            }
        });
    }
}