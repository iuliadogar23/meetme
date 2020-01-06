package com.project.meetme.repos;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.meetme.model.User;

public class UserRepository {

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//
//    private void getAll() {
//        databaseReference = FirebaseDatabase.getInstance().getReference("users");
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//    }

    public void create(String name, String email, String password, Long phone) {
        User user = new User(name, email, password, phone);
        databaseReference.setValue(user);
    }
}
