package com.project.meetme.view;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.project.meetme.R;

public class UserView extends AppCompatActivity {

    private Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.test = findViewById(R.id.test);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
