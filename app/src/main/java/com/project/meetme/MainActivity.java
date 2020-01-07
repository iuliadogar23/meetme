package com.project.meetme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;
import com.project.meetme.model.User;
import com.project.meetme.repos.UserRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        UserRepository userRepository = new UserRepository(database);
        userRepository.getAll();
//        userRepository.create("ana", "doggy@gmail.com", "test", 07L);
    }
}
