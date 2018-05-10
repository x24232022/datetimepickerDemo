package com.example.administrator.dateselect;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {

    Activity mActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DateTimePickerDialog dialog=new DateTimePickerDialog(mActivity, new DatePicker.OnDateChangedListener() {
                   @Override
                   public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                   }
               }, new TimePicker.OnTimeChangedListener() {
                   @Override
                   public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                   }
               }, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               }, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               }, true);
            }
        });
    }
}
