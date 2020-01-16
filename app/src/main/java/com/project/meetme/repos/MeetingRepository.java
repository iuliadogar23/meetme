package com.project.meetme.repos;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.meetme.model.Meeting;

import java.util.List;

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

    public void update(String id, Meeting meeting) {
        String idStr = id;
        databaseReference.child(idStr).setValue(meeting);
    }

    public Meeting findByName(List<Meeting> meetings, String title) {
        for (Meeting meeting : meetings) {
            if (meeting.getTitle().equals(title))
                return meeting;
        }
        return null;
    }

    public void deleteMeeting(Meeting meeting) {
        databaseReference.child(meeting.getTitle()).child("deleted").setValue(true);
//        meeting.setDeleted(true);
    }

}