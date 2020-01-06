package com.project.meetme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.meetme.model.User;
import com.project.meetme.repos.UserRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserRepository userRepository = new UserRepository();
        userRepository.create("ana", "doggy@gmail.com", "test", 07L);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
