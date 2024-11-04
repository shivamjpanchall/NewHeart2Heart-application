package com.rama.heart2heart.ngos;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rama.heart2heart.AboutOusFragment;
import com.rama.heart2heart.AuthorizedPersonsFragment;
import com.rama.heart2heart.ContactOusFragment;
import com.rama.heart2heart.R;

public class NgoMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    FirebaseUser currentUser;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2, new NgoHomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
        updateNavHeader();

    }

    private void updateNavHeader() {


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView nickname = headerView.findViewById(R.id.nav_name);
        TextView navUserMail = headerView.findViewById(R.id.nav_user_email);

        navUserMail.setText(currentUser.getEmail());
        nickname.setText(currentUser.getDisplayName());
    }

    public void setSupportActionBar(Toolbar toolbar) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2, new NgoHomeFragment(),null).addToBackStack(null).commit();
                break;
            case R.id.nav_authorized:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2, new AuthorizedPersonsFragment(),null).addToBackStack(null).commit();
                break;
            case R.id.nav_aboutous:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2, new AboutOusFragment(),null).addToBackStack(null).commit();
                break;
            case R.id.nav_contactous:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2, new ContactOusFragment(),null).addToBackStack(null).commit();
                break;
            case R.id.nav_logout:
                Fragment loginf = new NgoSignInFragment();
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.drawer_layout,loginf).commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

}