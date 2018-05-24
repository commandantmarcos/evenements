package com.ldnr.evenements;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main );
        //
        //
        this.configureViewPager();
    }

    private void configureViewPager(){
        ViewPager viewPager = findViewById(R.id.activity_main_viewpager);

        viewPager.setAdapter(new EvenementAdapter(getSupportFragmentManager()));
    }
}
