package com.example.hrizi.onescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       Toolbar toolbar;
        TextView searchscore,orderscore;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");



        //get text items
        searchscore = (TextView) findViewById(R.id.search);
        orderscore = (TextView) findViewById(R.id.order);







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
                Intent communityintent= new Intent(MainActivity.this,community.class);
                startActivity(communityintent);
                break;
            case R.id.ichome:
                Intent homeintent= new Intent(MainActivity.this,MainActivity.class);
                startActivity(homeintent);
                break;
            case R.id.icprofile:
                Intent profileintent= new Intent(MainActivity.this,profile.class);
                startActivity(profileintent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void tosearchscore(View v)
    {
        Intent homeintent= new Intent(MainActivity.this,search_score.class);
        startActivity(homeintent);
    }

    public void toorderscore(View v)
    {
        Intent orderintent= new Intent(MainActivity.this,order_score.class);
        startActivity(orderintent);
    }
}
