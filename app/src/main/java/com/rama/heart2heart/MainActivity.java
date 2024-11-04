package com.rama.heart2heart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rama.heart2heart.donor.DonorHomeActivity;
import com.rama.heart2heart.ngos.NgoHomeActivity;

public class MainActivity extends AppCompatActivity {

    String[] item = {"Donor", "NGO"};
    AutoCompleteTextView auto;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auto = findViewById(R.id.auto);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item);
        auto.setAdapter(adapterItems);
        auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "item"+ item, Toast.LENGTH_SHORT).show();


                if ("Donor".equals(item)) {
                    Intent intent = new Intent(MainActivity.this, DonorHomeActivity.class);
                    startActivity(intent);
                } else if ("NGO".equals(item)) {
                    Intent intent = new Intent(MainActivity.this, NgoHomeActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}