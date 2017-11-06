package com.example.digendra.ghsearch;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView createAccount;
    EditText Uname,pass;
    Button signin;
    String userName,password,password1;
    DataBaseHandler helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uname=(EditText)findViewById(R.id.Uname);
        pass=(EditText)findViewById(R.id.pass);
        signin=(Button)findViewById(R.id.signin);

        createAccount=(TextView) findViewById(R.id.txtview);
        helper=new DataBaseHandler(getApplicationContext());
        //mEtPwd=(EditText)findViewById(R.id.edittxt2);

        createAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=Uname.getText().toString();
                password=pass.getText().toString();
                password1=helper.searchPass(userName);
                String newData[]=password1.split("=");
                if(password.equals(newData[1])&&userName.equalsIgnoreCase(newData[0]))
                {
                    Intent i =new Intent(MainActivity.this,WelcomeActivity.class);
                    i.putExtra("username", userName);
                    startActivity(i);

                }
                else
                {

                    Toast.makeText(getApplicationContext(), "user name and password not match!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
