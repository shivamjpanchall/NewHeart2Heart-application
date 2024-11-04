package com.rama.heart2heart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AuthorizedPersonsFragment extends Fragment {

    TextView phonecall,phonecall1,phonecall2,phonecall3,phonecall4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_authorized_persons, container, false);

        phonecall = view.findViewById(R.id.phonecall);
        phonecall1 = view.findViewById(R.id.phonecall1);
        phonecall2 = view.findViewById(R.id.phonecall2);
        phonecall3 = view.findViewById(R.id.phonecall3);
        phonecall4 = view.findViewById(R.id.phonecall4);

        phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919727721973"));
                startActivity(intent);
            }
        });

        phonecall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919978038446"));
                startActivity(intent);
            }
        });

        phonecall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+917016924342"));
                startActivity(intent);
            }
        });

        phonecall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+916356000036"));
                startActivity(intent);
            }
        });

        phonecall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+917698888244"));
                startActivity(intent);
            }
        });

        return view;
    }
}