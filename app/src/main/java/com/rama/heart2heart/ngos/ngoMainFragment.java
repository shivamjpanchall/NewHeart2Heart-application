package com.rama.heart2heart.ngos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.rama.heart2heart.R;

public class ngoMainFragment extends Fragment {

    Button loginbuttonw, registerbuttonw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ngo_main, container, false);

        loginbuttonw = view.findViewById(R.id.Login_Buttonw);
        registerbuttonw = view.findViewById(R.id.Register_Buttonw);

        loginbuttonw.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_ngoMainFragment_to_ngoSignInFragment2);
        });

        registerbuttonw.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_ngoMainFragment_to_ngoSignUpFragment2);
        });

        return view;

    }
}