package com.example.journey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CatalogFragment extends Fragment {

    private RecyclerView recyclerView;
    private JourneyAdapter journeyAdapter;
    private JourneyDatabaseHandler dbHandler;
    private AlertDialog dialog;
    private Set<String> selectedTags; // Сет для хранения выбранных тегов

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.catalog_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        int spacing = getResources().getDimensionPixelSize(R.dimen.spacing);
        SpaceItemDecoration itemDecoration = new SpaceItemDecoration(spacing);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        dbHandler = new JourneyDatabaseHandler(getActivity());

        List<Journey> journeyList = dbHandler.getAllJourneys();

        journeyAdapter = new JourneyAdapter(journeyList);
        recyclerView.setAdapter(journeyAdapter);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSortDialog();
            }
        });


        return view;
    }

    private void showSortDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.sort, null);
        builder.setView(dialogView);
        Button btnSortByPriceAscending = dialogView.findViewById(R.id.btnSortByPriceAscending);
        btnSortByPriceAscending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                journeyAdapter.sortByPriceAscending();
                dialog.dismiss();
            }
        });

        Button btnSortByPriceDescending = dialogView.findViewById(R.id.btnSortByPriceDescending);
        btnSortByPriceDescending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                journeyAdapter.sortByPriceDescending();
                dialog.dismiss();
            }
        });

        Button btnSortByAlphabetAscending = dialogView.findViewById(R.id.btnSortByAlphabetAscending);
        btnSortByAlphabetAscending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                journeyAdapter.sortByAlphabetAscending();
                dialog.dismiss();
            }
        });

        Button btnSortByAlphabetDescending = dialogView.findViewById(R.id.btnSortByAlphabetDescending);
        btnSortByAlphabetDescending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                journeyAdapter.sortByAlphabetDescending();
                dialog.dismiss();
            }
        });

        dialog = builder.create();
        dialog.show();
    }

    // Метод для фильтрации списка поездок по выбранным тегам
    private void filterJourneysByTags() {
        List<Journey> filteredList = new ArrayList<>();
        for (Journey journey : dbHandler.getAllJourneys()) {
            if (journeyContainsTags(journey)) {
                filteredList.add(journey);
            }
        }
        journeyAdapter.setJourneyList(filteredList);
    }

    // Метод для проверки, содержит ли поездка выбранные теги
    private boolean journeyContainsTags(Journey journey) {
        if (selectedTags.isEmpty()) {
            return true; // Если не выбрано ни одного тега, вернуть true
        } else {
            Set<String> journeyTags = new HashSet<>();
            journeyTags.add(journey.getTag1());
            journeyTags.add(journey.getTag2());
            journeyTags.add(journey.getTag3());
            journeyTags.add(journey.getTag4());
            journeyTags.add(journey.getTag5());
            return journeyTags.containsAll(selectedTags); // Проверить, содержит ли поездка все выбранные теги
        }
    }
}
