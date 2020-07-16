package org.wc.bottomnavigationex01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.linda.bottomnavigationex01.Frag1;
import org.linda.bottomnavigationex01.Frag2;
import org.linda.bottomnavigationex01.Frag3;
import org.linda.bottomnavigationex01.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    //헷갈려서 mB이런 형식으로 많이 만듬
    private BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottom_navigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //switch문을 많이 쓴다
                Log.d(TAG, "onNavigationItemSelected: "+item.getItemId());
                switch (item.getItemId()){
                    case R.id.nav_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Frag1()).commit();
                        break;
                    case R.id.nav_settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Frag2()).commit();
                        break;
                    case R.id.nav_navigation:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Frag3()).commit();
                        break;
                }
                //return이 true여야 그림이 다시 그려짐
                return true;
            }
        });
    }
}