package com.rama.heart2heart.donor;

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

import com.rama.heart2heart.R;

public class DonorHomeFragment extends Fragment {

    ViewFlipper flipper;
    Button dfoodbutton,dclothbutton,dgrainbutton,dtoybutton,dbookbutton,dutensilsbutton,dsportbutton,dstationerybutton,dboardgamebutton,dotherbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_donor_home, container, false);

        dfoodbutton = view.findViewById(R.id.dfoodbutton);
        dclothbutton = view.findViewById(R.id.dclothbutton);
        dgrainbutton = view.findViewById(R.id.dgrainbutton);
        dtoybutton = view.findViewById(R.id.dtoybutton);
        dbookbutton = view.findViewById(R.id.dbookbutton);
        dutensilsbutton = view.findViewById(R.id.dutensilsbutton);
        dsportbutton = view.findViewById(R.id.dsportbutton);
        dstationerybutton = view.findViewById(R.id.dstationerybutton);
        dboardgamebutton = view.findViewById(R.id.dboardgamebutton);
        dotherbutton = view.findViewById(R.id.dotherbutton);

        dfoodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dfoodbutton.startAnimation(animation);
                Fragment foodf = new FoodFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, foodf,null).addToBackStack(null).commit();
            }
        });

        dclothbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dclothbutton.startAnimation(animation);
                Fragment clothf = new DClothFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, clothf,null).addToBackStack(null).commit();
            }
        });

        dgrainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dgrainbutton.startAnimation(animation);
                Fragment grainf = new DGrainFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, grainf,null).addToBackStack(null).commit();
            }
        });

        dtoybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dtoybutton.startAnimation(animation);
                Fragment toyf = new DToyFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, toyf,null).addToBackStack(null).commit();
            }
        });

        dbookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dbookbutton.startAnimation(animation);
                Fragment bookf = new DBookFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, bookf,null).addToBackStack(null).commit();
            }
        });

        dsportbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dsportbutton.startAnimation(animation);
                Fragment sportf = new DSportFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, sportf,null).addToBackStack(null).commit();
            }
        });

        dutensilsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dutensilsbutton.startAnimation(animation);
                Fragment utensilsf = new DUtensilsFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, utensilsf,null).addToBackStack(null).commit();
            }
        });

        dstationerybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dstationerybutton.startAnimation(animation);
                Fragment stationeryf = new DStationeryFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, stationeryf,null).addToBackStack(null).commit();
            }
        });

        dboardgamebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dboardgamebutton.startAnimation(animation);
                Fragment boardf = new DBoardGameFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, boardf,null).addToBackStack(null).commit();
            }
        });

        dotherbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                dotherbutton.startAnimation(animation);
                Fragment otherf = new DOtherFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container, otherf,null).addToBackStack(null).commit();
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