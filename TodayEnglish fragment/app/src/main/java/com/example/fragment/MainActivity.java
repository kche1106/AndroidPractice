package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    BookmarkFragment bookmarkFragment;
    StudyFragment studyFragment;
    ReviewFragment reviewFragment;
    AlarmFragment alarmFragment;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        bookmarkFragment = new BookmarkFragment();
        studyFragment = new StudyFragment();
        reviewFragment = new ReviewFragment();
        alarmFragment = new AlarmFragment();

        toolbar = (Toolbar)findViewById(R.id.tool_menu);
        setSupportActionBar(toolbar);

        TextView userName = findViewById(R.id.userName);

        Intent intent = getIntent();
        String strUserName = intent.getStringExtra("name");
        userName.setText(strUserName);

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.buttom_menu);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.study:
                        getSupportActionBar().setTitle("STUDY");
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, studyFragment).commit();
                        return true;
                    case R.id.bookmark:
                        getSupportActionBar().setTitle("BOOKMARK");
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, bookmarkFragment).commit();
                        return true;
                    case R.id.home:
                        getSupportActionBar().setTitle("HOME");
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();
                        return true;
                    case R.id.review:
                        getSupportActionBar().setTitle("REVIEW");
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, reviewFragment).commit();
                        return true;
                    case R.id.alarm:
                        getSupportActionBar().setTitle("ALARM");
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, alarmFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.tool_menu, menu);
        return true;
    }

    //액션버튼을 클릭했을때의 동작
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.setting:
                Intent settingIntent = new Intent(this, SettingActivity.class);
                startActivity(settingIntent);
                return true;
            case R.id.account:
                Intent accountIntent = new Intent(this, MypageActivity.class);
                startActivity(accountIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}