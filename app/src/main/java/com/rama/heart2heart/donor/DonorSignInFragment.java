package com.rama.heart2heart.donor;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.rama.heart2heart.R;

public class DonorSignInFragment extends Fragment {

    TextInputEditText emaill1, passwordl1;
    Button fp1, login1, da1;
    ImageButton back_img_btn_sign_in;
    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_donor_sign_in, container, false);
        emaill1 = view.findViewById(R.id.emaill);
        passwordl1 = view.findViewById(R.id.passwordl);
        fp1 = view.findViewById(R.id.fp);
        login1 = view.findViewById(R.id.login);
        da1 = view.findViewById(R.id.da);
        back_img_btn_sign_in = view.findViewById(R.id.back_img_btn_sign_in);

        mAuth = FirebaseAuth.getInstance();

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        fp1.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_donorSignInFragment_to_forgetPasswordFragment);
        });

       da1.setOnClickListener(view1 ->  {
           Navigation.findNavController(view).navigate(R.id.action_donorSignInFragment_to_donorSignUpFragment);
       });

        back_img_btn_sign_in.setOnClickListener(view1 ->  {
            Navigation.findNavController(view).navigate(R.id.action_donorSignInFragment_to_donorMainFragment);
        });

        return view;
    }

    private void loginUser() {
        String email = emaill1.getText().toString();
        String password = passwordl1.getText().toString();
        if(TextUtils.isEmpty(email)) {
            emaill1.setError("Email Id Cannot Be Empty");
            emaill1.requestFocus();
        }
        else if (TextUtils.isEmpty(password)) {
            passwordl1.setError("Password Cannot Be Empty");
            passwordl1.requestFocus();
        } else {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("Users")
                    .whereEqualTo("Email", email)
                    .whereEqualTo("Password", password)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            QuerySnapshot querySnapshot = task.getResult();
                            if (!querySnapshot.isEmpty()) {
                                Toast.makeText(getActivity(), "Logged In As Donor Successfully", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getActivity(), DonorMainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getActivity(), "Log In Error", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Log In Error", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    };
}



//            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()){
//                        Toast.makeText(getActivity(), "Logged In Successfully", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), DonorMainActivity.class);
//                        startActivity(intent);
//                    }
//                    else {
//                        Toast.makeText(getActivity(), "Log In Error", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
