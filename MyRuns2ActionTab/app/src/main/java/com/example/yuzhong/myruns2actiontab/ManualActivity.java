package com.example.yuzhong.myruns2actiontab;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.Calendar;

public class ManualActivity extends AppCompatActivity {

    private ListView list ;
    Calendar DateAndTime = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        list = (ListView) findViewById(R.id.ManualList);
        ArrayAdapter<CharSequence> manualInputAdapter = ArrayAdapter.createFromResource(this,
                R.array.ManualInput, android.R.layout.simple_list_item_1);
        list.setAdapter(manualInputAdapter);
        // choose different dialogues
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position == 0) {
                    onDateClicked();
                }

                else if (position == 1) {
                    onTimeClicked();
                }

                else {
                    onInputClicked(position);
                }
            }
        });
    }
    public void onSaveClick(View v){
        finish();
    }
    public void onCancelClick(View v){
        finish();
    }
    public void onDateClicked(){


            DatePickerDialog.OnDateSetListener mDateListener = new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    DateAndTime.set(Calendar.YEAR, year);
                    DateAndTime.set(Calendar.MONTH, monthOfYear);
                    DateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                }
            };

            new DatePickerDialog(this, mDateListener,
                    DateAndTime.get(Calendar.YEAR),
                    DateAndTime.get(Calendar.MONTH),
                    DateAndTime.get(Calendar.DAY_OF_MONTH)).show();


    }
    public void onTimeClicked() {

        TimePickerDialog.OnTimeSetListener mTimeListener = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                DateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                DateAndTime.set(Calendar.MINUTE, minute);

            }
        };
        new TimePickerDialog(this, mTimeListener,
                DateAndTime.get(Calendar.HOUR_OF_DAY),
                DateAndTime.get(Calendar.MINUTE), true).show();
    }
    public void onInputClicked(int pos){

    }


}
