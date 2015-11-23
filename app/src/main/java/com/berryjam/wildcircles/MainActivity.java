package com.berryjam.wildcircles;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    EntranceFragment entranceFragment;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initEntranceFragment();
    }

    public void initEntranceFragment() {
        entranceFragment = new EntranceFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, entranceFragment);
        transaction.commit();
    }

}
