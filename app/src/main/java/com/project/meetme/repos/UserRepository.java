package com.project.meetme.repos;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.meetme.model.User;

public class UserRepository {

    private DatabaseReference databaseReference;

    public UserRepository() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        this.databaseReference = database.getReference("users");
    }

    public void create(User user) {
        databaseReference.child("users").setValue(user);
    }
}
