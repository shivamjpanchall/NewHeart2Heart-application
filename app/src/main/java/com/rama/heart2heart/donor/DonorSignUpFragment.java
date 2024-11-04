package com.rama.heart2heart.donor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rama.heart2heart.R;

import java.util.HashMap;
import java.util.Map;

public class DonorSignUpFragment extends Fragment {

    TextInputEditText phoneno1,address1,name1,email1,password1;
    TextView haveaccount1;
    Button btnRegister1;
    ImageButton back_img_btn_sign_up;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    String userId;


    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donor_sign_up, container, false);

        phoneno1 = view.findViewById(R.id.phoneno);
        name1 = view.findViewById(R.id.name);
        email1 = view.findViewById(R.id.email);
        password1 = view.findViewById(R.id.password);
        address1 = view.findViewById(R.id.address);
        btnRegister1 = view.findViewById(R.id.btnRegister);
        haveaccount1 = view.findViewById(R.id.haveaccount);
        back_img_btn_sign_up = view.findViewById(R.id.back_img_btn_sign_up);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        btnRegister1.setOnClickListener(view1 -> {
            createUser();
        });

        haveaccount1.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_donorSignUpFragment_to_donorSignInFragment);
        });

        back_img_btn_sign_up.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_donorSignUpFragment_to_donorMainFragment);
        });

        return view;

    }
    private void createUser(){
        String phoneno = phoneno1.getText().toString();
        String name = name1.getText().toString();
        String address = address1.getText().toString();
        String email = email1.getText().toString();
        String password = password1.getText().toString();

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("user");

        reference.setValue("First data storage");


        if(TextUtils.isEmpty(phoneno)) {
            phoneno1.setError("Phone No. Cannot Be Empty");
            phoneno1.requestFocus();
        }
        else if (TextUtils.isEmpty(name)) {
            name1.setError("Name Cannot Be Empty");
            name1.requestFocus();
        }
        else if (TextUtils.isEmpty(address)) {
            address1.setError("Address Cannot Be Empty");
            address1.requestFocus();
        }
        else if (TextUtils.isEmpty(email)) {
            email1.setError("Email Id Cannot Be Empty");
            email1.requestFocus();
        }
        else if (TextUtils.isEmpty(password)) {
            password1.setError("Password Cannot Be Empty");
            password1.requestFocus();
        }
        else if (TextUtils.isEmpty(email)) {
            email1.setError("Confirm Password Cannot Be Empty");
            email1.requestFocus();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            Toast.makeText(getActivity(), "User Registered Successfully", Toast.LENGTH_SHORT).show();
                            Fragment loginf = new DonorSignInFragment();
                            FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                            fm.replace(R.id.maincontainer,loginf).commit();

                            user = mAuth.getCurrentUser();
                            DocumentReference df = fStore.collection("Users").document(user.getUid());
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("FullName",name1.getText().toString());
                            userInfo.put("Email",email1.getText().toString());
                            userInfo.put("Address",address1.getText().toString());
                            userInfo.put("Phone",phoneno1.getText().toString());
                            userInfo.put("Password",password1.getText().toString());
                            userInfo.put("isUser","1");
                            userInfo.put("isVerfied", false);
                            Log.d("SignUp Donor", "Registered Successfully");
                            df.set(userInfo);
                        }
                    else
                    {
                        Toast.makeText(getActivity(), "Registered Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
