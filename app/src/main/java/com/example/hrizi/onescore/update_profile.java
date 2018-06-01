package com.example.hrizi.onescore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class update_profile extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);


        //get the register form
        View includedLayout = findViewById(R.id.update_register_form);

        //change the logo with icon update profile
        ImageView img = (ImageView )includedLayout.findViewById(R.id.logo);
        img.setBackgroundResource(R.drawable.icon50);



        //change the text button to update profile
        Button btn_signup = (Button )includedLayout.findViewById(R.id.btn_signup);
        btn_signup.setText("Update Profile");

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
