package com.example.digendra.ghsearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {

    EditText name,user_name,mob,pass,email,confirmpass;
    String Name,UserName,Mobile,Password1,EmailId,Password2;
    Button save;
    Contact contact;
    DataBaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        name=(EditText)findViewById(R.id.name);
        user_name=(EditText)findViewById(R.id.u_name);
        mob=(EditText)findViewById(R.id.mobNo);
        pass=(EditText)findViewById(R.id.pass);
        confirmpass=(EditText)findViewById(R.id.confirmpass);
        email=(EditText)findViewById(R.id.email);
        save=(Button)findViewById(R.id.save);

        contact=new Contact();
        db=new DataBaseHandler(getApplicationContext());

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                initView();
                if(validate())
                {
                    if(!Password1.equals(Password2))
                    {
                        Toast.makeText(SecondActivity.this, "password don't match!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        db.addContact(contact);
                        Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }

            }
        });


    }

    public boolean validate()
    {
        boolean flag=true;
        if("".equals(Name)||"".equals(EmailId)||"".equals(UserName)||"".equals(Password1)||"".equals(Password2)||"".equals(Mobile))
        {
            if("".equals(Name))
            {
                name.setError("Please enter name");
            }
            if("".equals(EmailId))
            {
                email.setError("Please enter emailId");
            }
            if("".equals(UserName))
            {
                user_name.setError("Please enter user name");
            }
            if("".equals(Password1))
            {
                pass.setError("Please enter password");
            }
            if("".equals(Password2))
            {
                confirmpass.setError("Please enter confirm password");
            }
            if("".equals(Mobile))
            {
                mob.setError("Please enter mobile no.");
            }
            flag=false;
        }
        return flag;
    }
    public void initView()
    {
        Name=name.getText().toString();
        EmailId=email.getText().toString();
        UserName=user_name.getText().toString();
        Password1=pass.getText().toString();
        Password2=confirmpass.getText().toString();
        Mobile=mob.getText().toString();

        contact.setName(Name);
        contact.setUserNo(Mobile);
        contact.setEmail(EmailId);
        contact.setUserName(UserName);
        contact.setPassword1(Password1);
        contact.setPassword2(Password2);
    }

}
