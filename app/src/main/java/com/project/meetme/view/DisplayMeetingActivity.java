package com.project.meetme.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.meetme.R;
import com.project.meetme.model.Meeting;

public class DisplayMeetingActivity extends AppCompatActivity {

    Intent intent;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_display);
        textView = findViewById(R.id.textView);
        intent = getIntent();
        Meeting meeting = (Meeting) intent.getSerializableExtra("meetingToDisplay");
        textView.setText(meeting.toStringDisplay());

    }
}
