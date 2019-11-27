package com.example.mosaic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private final int NUM_TABS = 3;
    private String[] tabTitles = {"Song", "Favourite", "Playlist"};
    private ArrayList<String> sNames = new ArrayList<>();
    private ArrayList<String> sImage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Obtain the id of the xml components to reference in java code
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.slidingTabs);
        navigationView = findViewById(R.id.nv);

        // Set the toolbar as the app bar for this activity
        setSupportActionBar(toolbar);


        // Reference : The following code is from http://www.devexchanges.info/2016/05/android-basic-training-course-combining.html -

        // Tie the toolbar with the drawer toggle to toggle the drawer layout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState(); // Synchronize the state of the linked drawerLayout

        // Set the name of the tabs and include the tabs inside the tablayout
        for (int i = 0; i < NUM_TABS; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabTitles[i]));
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Enforce that the navigation view is never false
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        // Reference Complete

        viewPager.setAdapter(new SongFragmentAdapter(getSupportFragmentManager(), this));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch(id) {
            case R.id.play_list: viewPager.setCurrentItem(0);
            break;
            case R.id.artist : viewPager.setCurrentItem(1);
            break;
            case R.id.album : viewPager.setCurrentItem(2);
            break;
            default: viewPager.setCurrentItem(0);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        assert drawerLayout != null;

        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
