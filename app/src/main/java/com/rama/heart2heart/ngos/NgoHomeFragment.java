package com.rama.heart2heart.ngos;

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

public class NgoHomeFragment extends Fragment {

    ViewFlipper flipper;
    Button nfoodbutton,nclothbutton,ngrainbutton,ntoybutton,nbookbutton,nutensilsbutton,nsportbutton,nstationerybutton,nboardgamebutton,notherbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ngo_home, container, false);

        nfoodbutton = view.findViewById(R.id.nfoodbutton);
        nclothbutton = view.findViewById(R.id.nclothbutton);
        ngrainbutton = view.findViewById(R.id.ngrainbutton);
        ntoybutton = view.findViewById(R.id.ntoybutton);
        nbookbutton = view.findViewById(R.id.nbookbutton);
        nutensilsbutton = view.findViewById(R.id.nutensilsbutton);
        nsportbutton = view.findViewById(R.id.nsportbutton);
        nstationerybutton = view.findViewById(R.id.nstationerybutton);
        nboardgamebutton = view.findViewById(R.id.nboardgamebutton);
        notherbutton = view.findViewById(R.id.notherbutton);

        nfoodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                nfoodbutton.startAnimation(animation);
                Fragment foodf = new NFoodFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, foodf,null).addToBackStack(null).commit();
            }
        });

        nclothbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                nclothbutton.startAnimation(animation);
                Fragment clothf = new NClothFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, clothf,null).addToBackStack(null).commit();
            }
        });

        ngrainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                ngrainbutton.startAnimation(animation);
                Fragment grainf = new NGrainFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, grainf,null).addToBackStack(null).commit();
            }
        });

        ntoybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                ntoybutton.startAnimation(animation);
                Fragment toyf = new NToyFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, toyf,null).addToBackStack(null).commit();
            }
        });

        nbookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                nbookbutton.startAnimation(animation);
                Fragment bookf = new NBookFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, bookf,null).addToBackStack(null).commit();
            }
        });

        nsportbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                nsportbutton.startAnimation(animation);
                Fragment sportf = new NSportFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, sportf,null).addToBackStack(null).commit();
            }
        });

        nutensilsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                nutensilsbutton.startAnimation(animation);
                Fragment utensilsf = new NUtensilsFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, utensilsf,null).addToBackStack(null).commit();
            }
        });

        nstationerybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                nstationerybutton.startAnimation(animation);
                Fragment stationeryf = new NStationeryFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, stationeryf,null).addToBackStack(null).commit();
            }
        });

        nboardgamebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                nboardgamebutton.startAnimation(animation);
                Fragment boardf = new NBoardGameFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, boardf,null).addToBackStack(null).commit();
            }
        });

        notherbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
                notherbutton.startAnimation(animation);
                Fragment otherf = new NOtherFragment();
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.fragment_container2, otherf,null).addToBackStack(null).commit();
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