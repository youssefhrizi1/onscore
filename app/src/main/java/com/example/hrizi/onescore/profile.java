package com.example.hrizi.onescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");



        View includedLayout = findViewById(R.id.profile_feeds);
        TextView editprofiletxt = (TextView )includedLayout.findViewById(R.id.editprofile);

        editprofiletxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_update_profile= new Intent(profile.this,update_profile.class);
                startActivity(to_update_profile);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.iccommunity:
                Intent communityintent= new Intent(profile.this,community.class);
                startActivity(communityintent);
                break;
            case R.id.ichome:
                Intent homeintent= new Intent(profile.this,MainActivity.class);
                startActivity(homeintent);
                break;
            case R.id.icprofile:
                Intent profileintent= new Intent(profile.this,profile.class);
                startActivity(profileintent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
