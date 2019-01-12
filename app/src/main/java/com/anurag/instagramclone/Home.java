package com.anurag.instagramclone;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Home extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabAdapter tabAdapter;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        setTitle("Home");
        toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager);
        tabAdapter= new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager,false);






    }
}
