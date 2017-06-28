package com.example.rijunath.date_picker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv1;
    ImageView iv,iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        tv1=(TextView)findViewById(R.id.tv1);
        iv = (ImageView) findViewById(R.id.iv);
        iv1=(ImageView)findViewById(R.id.iv1);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int y = c.get(Calendar.YEAR);
                int m = c.get(Calendar.MONTH);
                int d = c.get(Calendar.DAY_OF_MONTH);
                /*DatePickerDialog dialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String s=dayOfMonth+"/"+(month+1)+"/"+year;
                        tv.setText(s);
                    }
                }, y, m, d);
                dialog.show();*/
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String s = dayOfMonth + "/" + (month + 1) + "/" + year;
                        tv.setText(s);
                    }
                }, y, m, d);
                dialog.show();
            }


        });

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                int h=c.get(Calendar.HOUR);
                int mi=c.get(Calendar.MINUTE);
                int b=c.get(Calendar.AM_PM);

                TimePickerDialog time=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay>12)
                        {
                            String s2=(hourOfDay-12)+":"+minute;
                            tv1.setText(s2);
                        }
                        else
                        {
                            String s2=(hourOfDay)+":"+minute;
                            tv1.setText(s2);
                        }



                    }
                },h,mi,false);
                time.show();



                }



        });

    }
}
