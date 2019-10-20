package com.lamart.site.mymotiv.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lamart.site.mymotiv.R;
import com.lamart.site.mymotiv.fragments.ChatFragment;
import com.lamart.site.mymotiv.fragments.HomeFragment;
import com.lamart.site.mymotiv.fragments.StocksFragment;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initComponent();
    }

    private void initComponent(){
        setTitle("");
        BottomNavigationView btnNav = findViewById(R.id.bottom_navigation);
        btnNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_manager,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch(menuItem.getItemId()){
                        case R.id.navigation_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.navigation_chat:
                            selectedFragment = new ChatFragment();
                            break;
                        case R.id.navigation_new:
                            selectedFragment = new StocksFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_manager,
                            selectedFragment).commit();
                    return true;
                }
            };

    @Override
    public void onBackPressed() {
    }
}
