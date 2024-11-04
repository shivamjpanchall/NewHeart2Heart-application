package com.rama.heart2heart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.rama.heart2heart.donor.DonorHomeFragment;

public class DonorHomeMainFragment extends Fragment {

    ViewFlipper flipper;
    Button donate_1, donate_2, donate_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_donor_home_main, container, false);

        donate_1 = view.findViewById(R.id.donate_1);
        donate_2 = view.findViewById(R.id.donate_2);
        donate_3 = view.findViewById(R.id.donate_3);

        donate_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                donate_1.startAnimation(animation);
                Fragment foodf = new DonorHomeFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, foodf,null).addToBackStack(null).commit();
            }
        });

        donate_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                donate_2.startAnimation(animation);
                Fragment foodf = new DonorHomeFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, foodf,null).addToBackStack(null).commit();
            }
        });

        donate_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                donate_3.startAnimation(animation);
                Fragment foodf = new DonorHomeFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, foodf,null).addToBackStack(null).commit();
            }
        });

        int imgarray[] = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3,R.drawable.slide4};
        flipper = view.findViewById(R.id.flipper);

        for (int i=0;i<imgarray.length;i++)
            showimage(imgarray[i]);

        return view;

    }
    public void showimage(int img)
    {
        ImageView imageView= new ImageView(getActivity());
        imageView.setBackgroundResource(img);

        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        flipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right);
    }
}