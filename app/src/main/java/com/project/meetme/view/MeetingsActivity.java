package com.project.meetme.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.meetme.R;
import com.project.meetme.model.Meeting;
import com.project.meetme.repos.MeetingRepository;

import java.util.ArrayList;

public class MeetingsActivity extends AppCompatActivity {

    MeetingRepository meetingRepository = new MeetingRepository();

    ListView meetingsView;
    Button createMeetingButton;
    Button aboutMe;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("meetings");
    ArrayList<Meeting> meetings;
    ArrayAdapter<Meeting> adapter;
    Meeting meeting;
    CalendarView calendarView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);

        meetingsView = (ListView) findViewById(R.id.meetingsView);
        createMeetingButton = findViewById(R.id.createMeetingButton);
        aboutMe = findViewById(R.id.about_me);
        meetings = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, meetings);

        calendarView = (CalendarView) findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                startActivity(new Intent(MeetingsActivity.this, MeetingDetailsActivity.class));
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                meetings.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    meeting = snapshot.getValue(Meeting.class);
                    if (!meeting.getDeleted()) {
                        meetings.add(meeting);
                    }
                }
                meetingsView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        meetingsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(MeetingsActivity.this, DisplayMeetingActivity.class);
                meeting = meetings.get(position);
                intent.putExtra("meetingToDisplay", meeting);
                startActivity(intent);
            }
        });

        createMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeetingsActivity.this, MeetingDetailsActivity.class));
            }
        });

        aboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeetingsActivity.this, ProfileActivity.class));
            }
        });
    }
}
