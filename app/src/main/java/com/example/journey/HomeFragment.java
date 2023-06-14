package com.example.journey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {

    private Button showButton1, showButton2, showButton3, showButton4;
    private ImageView homeImg11, homeImg12, homeImg13, homeImg14, homeImg15;
    private ImageView homeImg21, homeImg22, homeImg23, homeImg24, homeImg25;
    private ImageView homeImg31, homeImg32, homeImg33, homeImg34, homeImg35;
    private ImageView homeImg41, homeImg42, homeImg43, homeImg44, homeImg45;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        // Initialize views
        showButton1 = view.findViewById(R.id.show_button_1);
        showButton2 = view.findViewById(R.id.show_button_2);
        showButton3 = view.findViewById(R.id.show_button_3);
        showButton4 = view.findViewById(R.id.show_button_4);

        homeImg11 = view.findViewById(R.id.home_img_11);
        homeImg12 = view.findViewById(R.id.home_img_12);
        homeImg13 = view.findViewById(R.id.home_img_13);
        homeImg14 = view.findViewById(R.id.home_img_14);
        homeImg15 = view.findViewById(R.id.home_img_15);

        homeImg21 = view.findViewById(R.id.home_img_21);
        homeImg22 = view.findViewById(R.id.home_img_22);
        homeImg23 = view.findViewById(R.id.home_img_23);
        homeImg24 = view.findViewById(R.id.home_img_24);
        homeImg25 = view.findViewById(R.id.home_img_25);

        homeImg31 = view.findViewById(R.id.home_img_31);
        homeImg32 = view.findViewById(R.id.home_img_32);
        homeImg33 = view.findViewById(R.id.home_img_33);
        homeImg34 = view.findViewById(R.id.home_img_34);
        homeImg35 = view.findViewById(R.id.home_img_35);

        homeImg41 = view.findViewById(R.id.home_img_41);
        homeImg42 = view.findViewById(R.id.home_img_42);
        homeImg43 = view.findViewById(R.id.home_img_43);
        homeImg44 = view.findViewById(R.id.home_img_44);
        homeImg45 = view.findViewById(R.id.home_img_45);

        // Set click listeners for buttons
        showButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CatalogFragment());
            }
        });

        showButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CatalogFragment());
            }
        });

        showButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CatalogFragment());
            }
        });

        showButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CatalogFragment());
            }
        });

        // Set click listeners for images
        homeImg11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CatalogFragment());
            }
        });

        homeImg12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CatalogFragment());
            }
        });

        homeImg13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CatalogFragment());
            }
        });

        homeImg14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CatalogFragment());
            }
        });

        homeImg15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CatalogFragment());
            }
        });

        // Add click listeners for other images if needed

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
