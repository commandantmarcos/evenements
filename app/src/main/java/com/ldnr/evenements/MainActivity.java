package com.ldnr.evenements;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static Context context;

    public static GroupeFragment frag;

    public  static Context getContext(){ return  context;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main );
        //
        this.configureViewPager();
    }

    private void configureViewPager(){
        ViewPager viewPager = findViewById(R.id.activity_main_viewpager);

        viewPager.setAdapter(new EvenementAdapter(getSupportFragmentManager()));
    }

    public void onCellClicked(View view) {
       frag.onCellClicked(view);
    }
}
