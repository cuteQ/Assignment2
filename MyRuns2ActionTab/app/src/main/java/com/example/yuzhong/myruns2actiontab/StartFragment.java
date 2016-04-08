package com.example.yuzhong.myruns2actiontab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class StartFragment extends Fragment {

    //    public static final int MANUL = 0;
//    public static final int GPS =1;
//    public static final int AUTOMATIC = 1;
    private Button buttonStart;
    private Button SyncButton;
    private Spinner Inputspinner;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_start, container, false);

        Inputspinner = (Spinner) view.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> inputAdapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.ActivityTypeSpinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        Inputspinner.setAdapter(inputAdapter);
        buttonStart = (Button) view.findViewById(R.id.StartButton);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                Log.d("CS65",Inputspinner.getSelectedItem().toString());
                if (Inputspinner.getSelectedItem().toString().equals("Manual Entry")) {
                    i = new Intent(getActivity(),ManualActivity.class);
                }

                else {
                    i = new Intent(getActivity(),MapActivity.class);

                }
                startActivity(i);
            }
        });
        return view;
    }


}
