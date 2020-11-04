package com.example.duan1_team6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.duan1_team6.Fragment.Fragmentdienthoai;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initnavigation(savedInstanceState);


    }
    public void initnavigation(Bundle savedInstanceState){

        final Toolbar toolbar = findViewById(R.id.mytoolbar);

        setSupportActionBar(toolbar);

        final FrameLayout frame = findViewById(R.id.frameContainer);
        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frameContainer,new Fragmentdienthoai())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_xemdt);

        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()){

                    case R.id.nav_dienthoai:
                        fragment = new Fragmentdienthoai();
                        Toast.makeText(MainActivity.this,"tab điện thoại",Toast.LENGTH_SHORT).show();
                        break;
                }
                if(fragment!=null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frameContainer, fragment).commit();
                    drawer.setSelected(true);
                    drawer.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });

    }
}