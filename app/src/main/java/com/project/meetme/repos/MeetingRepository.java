package com.project.meetme.repos;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.meetme.model.Meeting;

public class MeetingRepository {

    private DatabaseReference databaseReference;

    public MeetingRepository() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("meetings");
    }

    public DatabaseReference getAll() {
        return databaseReference;
    }

    public void create(Meeting meeting) {
        databaseReference.push().setValue(meeting);
    }

    public void update(Integer id, Meeting meeting) {
        String idStr = id.toString();
        databaseReference.child(idStr).setValue(meeting);
    }
}