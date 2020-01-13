package com.project.meetme.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.project.meetme.R;
import com.project.meetme.model.Meeting;
import com.project.meetme.repos.MeetingRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MeetingDetailsActivity extends AppCompatActivity {

    MeetingRepository meetingRepository = new MeetingRepository();
    final Calendar myCalendar = Calendar.getInstance();

    EditText etTitle;
    EditText etDescription;
    EditText etDatetime;
    EditText etLocation;
    Button createMeeting;

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDatetime.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);

        etTitle = findViewById(R.id.etMtgTitle);
        etDescription = findViewById(R.id.etMtgDescription);
        etDatetime = findViewById(R.id.etMtgDatetime);
        etLocation = findViewById(R.id.etMtgLocation);
        createMeeting = findViewById(R.id.buttonCreateMeeting);


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

//        etDatetime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                new DatePickerDialog(classname.this, date,
//                        myCalendar.get(Calendar.YEAR),
//                        myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });

        createMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String title = etTitle.getText().toString();
                final String description = etDescription.getText().toString();
//                final String datetimeStr = etDatetime.getText().toString();
//                String startTime = "2011-09-05 15:00:23";
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Timestamp datetime = dateFormat.parse(datetimeStr);
                final String location = etLocation.getText().toString();

                Meeting meeting = new Meeting(title, description, null, location);
                meetingRepository.create(meeting);
            }
        });
    }
}
