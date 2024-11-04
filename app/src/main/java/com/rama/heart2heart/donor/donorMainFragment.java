package com.rama.heart2heart.donor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.rama.heart2heart.R;

public class donorMainFragment extends Fragment {

    Button loginbutton, registerbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donor_main, container, false);

        loginbutton = view.findViewById(R.id.Login_Button);
        registerbutton = view.findViewById(R.id.Register_Button);

        loginbutton.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_donorMainFragment_to_donorSignInFragment);
        });

        registerbutton.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_donorMainFragment_to_donorSignUpFragment2);
        });

        return view;

    }
}