package com.example.digendra.ghsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class WelcomeActivity extends Activity implements View.OnClickListener{

    ImageView fuel_logo,hospital_logo,gym_logo,food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        fuel_logo=(ImageView)findViewById(R.id.fuel);
        hospital_logo=(ImageView)findViewById(R.id.hospital);
        gym_logo=(ImageView)findViewById(R.id.gym);
        food=(ImageView)findViewById(R.id.restaurant);

        setListener();



    }
    public void setListener()
    {
        fuel_logo.setOnClickListener(this);
        hospital_logo.setOnClickListener(this);
        gym_logo.setOnClickListener(this);
        food.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view ==fuel_logo )
        {
            Intent intent = new Intent(this,GooglePlacesActivity.class);
            intent.putExtra("key","atm");
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Click image on Fuel",Toast.LENGTH_LONG).show();
            //finish();
        }
        else if(view == hospital_logo)
        {
            Intent intent = new Intent(this,GooglePlacesActivity.class);
            intent.putExtra("key","hospital");
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Click image on Hospital",Toast.LENGTH_LONG).show();
           // finish();
        }else if(view == gym_logo )
        {
            Intent intent = new Intent(this,GooglePlacesActivity.class);
            intent.putExtra("key","gym");
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Click image on GYM",Toast.LENGTH_LONG).show();
           // finish();
        }
        else if(view == food)
        {
            Intent intent = new Intent(this,GooglePlacesActivity.class);
            intent.putExtra("key","restaurant");
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Click image on Restaurant",Toast.LENGTH_LONG).show();
            //finish();
        }
    }
}
