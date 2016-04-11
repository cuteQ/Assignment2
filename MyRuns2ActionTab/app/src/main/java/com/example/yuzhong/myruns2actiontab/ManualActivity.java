package com.example.yuzhong.myruns2actiontab;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class ManualActivity extends Activity {
   private ListView list ;
    Calendar DateAndTime = Calendar.getInstance();
//    TextView mDisplayDateTime;
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
        showEditBox(pos);
    }

    void showEditBox(int pos) {
        DialogFragment newFragment = MyEditBoxFragment
                .newInstance(pos);
        newFragment.show(getFragmentManager(), "dialog");
    }

    public void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
    }

    public static class MyEditBoxFragment extends DialogFragment {

        public static MyEditBoxFragment newInstance(int title) {
            MyEditBoxFragment frag = new MyEditBoxFragment();
            Bundle args = new Bundle();
            args.putInt("title", title);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("title");
            final EditText edittext = new EditText(getActivity());
            edittext.setInputType(InputType.TYPE_CLASS_NUMBER);

            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
            switch (title) {
                case 2:
                    alert.setTitle("Duration");
                    break;
                case 3:
                    alert.setTitle("Distance");
                    break;
                case 4:
                    alert.setTitle("Calories");
                    break;
                case 5:
                    alert.setTitle("Heart Rate");
                    break;
                case 6:
                    // if user choose comment, add hint and change input type
                    alert.setTitle("Comment");
                    edittext.setHint("How did it go? Notes here.");
                    edittext.setInputType(InputType.TYPE_CLASS_TEXT);
                    break;
                default:
                    break;
            }
            
            alert.setView(edittext);
            alert.setPositiveButton(R.string.alert_dialog_ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            ((ManualActivity) getActivity())
                                    .doPositiveClick();
                        }
                    });
            alert.setNegativeButton(R.string.alert_dialog_cancel,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            ((ManualActivity) getActivity())
                                    .doNegativeClick();
                        }
                    });
            return alert.create();
        }
    }
}

