package com.project.meetme.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.project.meetme.R;
import com.project.meetme.model.Meeting;
import com.project.meetme.repos.MeetingRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MeetingDetailsActivity extends AppCompatActivity {

    MeetingRepository meetingRepository = new MeetingRepository();
    final Calendar myCalendar = Calendar.getInstance();

    EditText etTitle;
    EditText etDescription;
    TextView etDate;
    TextView etTime;
    EditText etLocation;
    Button createMeeting;
    Calendar calendar;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private TimePickerDialog.OnTimeSetListener timeSetListener;

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDate.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);
        calendar = Calendar.getInstance();


        etTitle = findViewById(R.id.etMtgTitle);
        etDescription = findViewById(R.id.etMtgDescription);
        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
        etLocation = findViewById(R.id.etMtgLocation);
        createMeeting = findViewById(R.id.buttonCreateMeeting);
        final Date returnDate = new Date();

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MeetingDetailsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month=month+1;
                        String myDate=dayOfMonth+"/"+month+"/"+year;
                        returnDate.setYear(year);
                        returnDate.setMonth(month);
                        returnDate.setDate(dayOfMonth);
                        etDate.setText(myDate);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mHour = calendar.get(Calendar.HOUR_OF_DAY);
                int mMinute = calendar.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(MeetingDetailsActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                String time = hourOfDay+":"+minute;
                                etTime.setText(time);
                                returnDate.setHours(hourOfDay);
                                returnDate.setMinutes(minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();

            }
        });


        createMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String title = etTitle.getText().toString();
                final String description = etDescription.getText().toString();
                final String location = etLocation.getText().toString();

                Meeting meeting = new Meeting(title, description, calendar.getTimeInMillis(), location);
                meetingRepository.create(meeting);
                startActivity(new Intent(MeetingDetailsActivity.this, MeetingsActivity.class));
            }
        });
    }
}
