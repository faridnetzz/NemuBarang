package pnj.uas.ahmadfarid;

import android.content.Intent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import pnj.uas.ahmadfarid.LocationActivity;
import pnj.uas.ahmadfarid.R;
import pnj.uas.ahmadfarid.fragment.BeritaFragment;
import pnj.uas.ahmadfarid.fragment.HomeFragment;
import pnj.uas.ahmadfarid.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomView;
    HomeFragment homeFragment = new HomeFragment();
    BeritaFragment beritaFragment = new BeritaFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomView = findViewById(R.id.BottomMenu);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerHost, homeFragment);
        fragmentTransaction.commit();

        bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragmentTransaction2.replace(R.id.containerHost, homeFragment);
                        break;
                    case R.id.navigation_dashboard:
                        fragmentTransaction2.replace(R.id.containerHost, beritaFragment);
                        break;
                    case R.id.navigation_notifications:
                        fragmentTransaction2.replace(R.id.containerHost, profileFragment);
                        break;
                    case R.id.navigation_maps:
                        Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                        startActivity(intent);
                        break;
                }
                fragmentTransaction2.commit();
                return true;
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.actionKehilangan) {
            Intent intent = new Intent( this, DataTemuanActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.actionPenemu) {
            Intent intent = new Intent( this, ListDataTemuan.class);
            startActivity(intent);

        }else {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();

            Intent intent = new Intent( this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }
}
