package com.example.taskmanager.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.taskmanager.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public abstract Fragment  createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getSupportFragmentManager();
        //check if fragment exists in container (configuration changes save the fragments)

        Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_container);

        //2=create and add fragment transaction for crimeDetailFragment;
        if (fragment==null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, createFragment())
                    .commit();
        }
}}
