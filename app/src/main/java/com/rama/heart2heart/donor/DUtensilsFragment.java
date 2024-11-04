package com.rama.heart2heart.donor;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rama.heart2heart.R;
import com.rama.heart2heart.chips.dutensils;
import com.rama.heart2heart.chips.food;

import java.util.Calendar;


public class DUtensilsFragment extends Fragment {

    TextInputEditText utensils_donation_name,quantity,preferred_pickup_date,preferred_pickup_time,preferred_pickup_location;
    Button submit_donor;
    DatabaseReference chipsDbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_d_utensils, container, false);

        utensils_donation_name = view.findViewById(R.id.utensils_donation_name);
        quantity = view.findViewById(R.id.quantity);
        preferred_pickup_date = view.findViewById(R.id.preferred_pickup_date);
        preferred_pickup_time = view.findViewById(R.id.preferred_pickup_time);
        preferred_pickup_location = view.findViewById(R.id.preferred_pickup_location);
        submit_donor = view.findViewById(R.id.submit_donor);

        chipsDbRef = FirebaseDatabase.getInstance().getReference().child("Utensils");

        preferred_pickup_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                preferred_pickup_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });

        submit_donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertutensilsdata();
            }
        });

        return view;
    }
    private void insertutensilsdata() {
        String utensils_donation_name1 = utensils_donation_name.getText().toString();
        String quantity1 = quantity.getText().toString();
        String preferred_pickup_date1 = preferred_pickup_date.getText().toString();
        String preferred_pickup_time1 = preferred_pickup_time.getText().toString();
        String preferred_pickup_location1 = preferred_pickup_location.getText().toString();

        dutensils dutensils = new dutensils(utensils_donation_name1,quantity1,preferred_pickup_date1,preferred_pickup_time1,preferred_pickup_location1);
        chipsDbRef.push().setValue(dutensils);
        Toast.makeText(getActivity(), "Data is Submitted to Admin will reach u Shortly", Toast.LENGTH_SHORT).show();

    }

}