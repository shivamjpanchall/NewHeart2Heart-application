package com.rama.heart2heart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.rama.heart2heart.donor.DonorSignInFragment;

public class ForgetPasswordFragment extends Fragment {

    private TextInputEditText fp;
    private Button rp1;
    private String email;
    ImageButton back_img_btn_fp;
    FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_forget_password, container, false);

        fp = view.findViewById(R.id.fpp);
        rp1 = view.findViewById(R.id.rp);
        back_img_btn_fp = view.findViewById(R.id.back_img_btn_fp);
        auth = FirebaseAuth.getInstance();

        rp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = fp.getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText(getActivity(), "Email cannot be Empty", Toast.LENGTH_SHORT).show();
                } else {
                    forgetpassword();
                }
            }
        });

        back_img_btn_fp.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_forgetPasswordFragment_to_donorSignInFragment2);
        });

        return view;
    }

    private void forgetpassword() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), "Check Your Email", Toast.LENGTH_SHORT).show();
                            Fragment signInFragment = new DonorSignInFragment();
                            FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                            fm.replace(R.id.maincontainer, signInFragment).commit();
                        } else {
                            Toast.makeText(getActivity(), "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}