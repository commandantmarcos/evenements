package com.ldnr.evenements;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String [] colors = {"#EDD9CF","#BED4D6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //
        //
        this.configureViewPager();
    }

    private void configureViewPager(){
        ViewPager viewPager = findViewById(R.id.activity_main_viewpager);

        viewPager.setAdapter(new EvenementAdapter(getSupportFragmentManager(), colors));
    }
}
