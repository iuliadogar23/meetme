package com.project.meetme.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.meetme.R;
import com.project.meetme.model.Meeting;
import com.project.meetme.repos.MeetingRepository;

public class DisplayMeetingActivity extends AppCompatActivity {

    Intent intent;
    TextView textView;
    Button update;
    Button delete;
    MeetingRepository meetingRepository = new MeetingRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_display);
        textView = findViewById(R.id.textView);
        intent = getIntent();
        final Meeting meeting = (Meeting) intent.getSerializableExtra("meetingToDisplay");
        textView.setText(meeting.toStringDisplay());
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("meetings");
                databaseReference.child(meeting.getTitle()).removeValue();

                meetingRepository.deleteMeeting(meeting);
                Toast.makeText(v.getContext(), "Meeting " + meeting.getTitle() + " was deleted!", Toast.LENGTH_SHORT);
                startActivity(new Intent(DisplayMeetingActivity.this, MeetingsActivity.class));
            }
        });
    }
}
