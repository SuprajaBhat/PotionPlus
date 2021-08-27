package com.example.signuplab;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.signuplab.R;

import java.text.DateFormat;
import java.util.Calendar;

public class Reminder extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    private TextView mTextView;
    public TextView med1;
    public TextView med2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        mTextView = findViewById(R.id.textView);
        med1=findViewById(R.id.medicinename1);
        med2=findViewById(R.id.medicinename2);

        String medname1=med1.getText().toString();
        Button buttonTimePicker = findViewById(R.id.button_timepicker);
        Button btntimepicker2=findViewById(R.id.picker2);

        Button btncancel2=findViewById(R.id.Cancle2);
        Button buttonCancelAlarm = findViewById(R.id.button_cancel);

        TextView add=findViewById(R.id.add);


        med2.setVisibility(View.INVISIBLE);
        btntimepicker2.setVisibility(View.INVISIBLE);
        btncancel2.setVisibility(View.INVISIBLE);

        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimPicker();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
        //PICKER 2
        btntimepicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimPicker();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });


        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });


        btncancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                med2.setVisibility(View.VISIBLE);
                btntimepicker2.setVisibility(View.VISIBLE);
                btncancel2.setVisibility(View.VISIBLE);
                add.setX(750);
                add.setY(1350);
            }
        });




    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
        startAlarm(c);
    }

    private void updateTimeText(Calendar c) {
        String timeText = "Reminder set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView.setText(timeText);
    }

    public void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(Reminder.this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager.cancel(pendingIntent);
        mTextView.setText("Reminder canceled");
    }
}