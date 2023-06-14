package com.example.journey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class TagFilterFragment extends Fragment implements View.OnClickListener {

    private List<String> selectedTags;
    private Button applyButton;

    public TagFilterFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tag_filter, container, false);

        selectedTags = new ArrayList<>();

        // Find and set click listeners for tag buttons
        Button tag1Button = view.findViewById(R.id.tag1Button);
        Button tag2Button = view.findViewById(R.id.tag2Button);
        Button tag3Button = view.findViewById(R.id.tag3Button);
        // Add more buttons for additional tags

        tag1Button.setOnClickListener(this);
        tag2Button.setOnClickListener(this);
        tag3Button.setOnClickListener(this);
        // Set click listeners for additional buttons

        applyButton = view.findViewById(R.id.applyButton);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyFilters();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String tag = button.getText().toString();

        if (selectedTags.contains(tag)) {
            selectedTags.remove(tag);
            button.setSelected(false);
        } else {
            selectedTags.add(tag);
            button.setSelected(true);
        }
    }

    private void applyFilters() {
        // Pass the selected tags to the catalog fragment for filtering
        CatalogFragment catalogFragment = new CatalogFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("selectedTags", new ArrayList<>(selectedTags));
        catalogFragment.setArguments(bundle);

        // Replace the current fragment with the catalog fragment
        requireFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, catalogFragment)
                .commit();
    }
}
