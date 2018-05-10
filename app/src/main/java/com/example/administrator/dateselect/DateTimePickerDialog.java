package com.example.administrator.dateselect;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

import static android.app.AlertDialog.THEME_HOLO_LIGHT;


public class DateTimePickerDialog  {
    private DatePicker mDatePicker;
    private TimePicker mTimePicker;
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private String timeMsg;
    private boolean mIs24HourView;
    private Context mContext;

    private DatePicker.OnDateChangedListener mOnDateChangedListener;
    private TimePicker.OnTimeChangedListener mOnTimeChangedListener;
    private DialogInterface.OnClickListener yesListener;
    private DialogInterface.OnClickListener noListener;


    public DateTimePickerDialog(Context context, DatePicker.OnDateChangedListener dateListener , TimePicker.OnTimeChangedListener timeListener,

                                 DialogInterface.OnClickListener yesListener, DialogInterface.OnClickListener noListener, boolean is24HourView){
        this.mContext=context;
        this.mOnDateChangedListener=dateListener;
        this.mOnTimeChangedListener=timeListener;
        this.yesListener=yesListener;
        this.noListener=noListener;
        this.mIs24HourView=is24HourView;
        initDialog();
    }

    private void initDialog(){
        Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH) ;
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mHour = calendar.get(Calendar.HOUR);
        mMinute = calendar.get(Calendar.MINUTE);
        View view=View.inflate(mContext,R.layout.timedialog,null);

        mDatePicker=view.findViewById(R.id.datepicker);
        mTimePicker=view.findViewById(R.id.timepicker);
        mDatePicker.init(mYear,mMonth,mDay, mOnDateChangedListener);
        mTimePicker.setIs24HourView(mIs24HourView);

        mTimePicker.setOnTimeChangedListener(mOnTimeChangedListener);
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("设置时间");
        builder.setView(view);
        builder.setPositiveButton("确认",yesListener);
        builder.setNegativeButton("取消",noListener);
        builder.show();
    }
    private String showTime(int year,int month,int day,int hour,int minute){
        StringBuffer dateTime=new StringBuffer();
        dateTime.append(year);
        dateTime.append("-");
        if(month<10){
            dateTime.append("0"+(month+1));
        }else {
            dateTime.append((month+1));
        }

        dateTime.append("-");
        if(day<10){
            dateTime.append("0"+day);
        }else {
            dateTime.append(day);
        }

        dateTime.append(" ");
        if(hour<10){
            dateTime.append("0"+hour);
        }else {
            dateTime.append(hour);
        }


        dateTime.append(":");
        if(minute<10){
            dateTime.append("0"+minute);
        }else {
            dateTime.append(minute);
        }
        timeMsg= String.valueOf(dateTime);
        return timeMsg;
    }








}
