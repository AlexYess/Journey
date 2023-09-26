package com.example.journey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JourneyAdapter extends RecyclerView.Adapter<JourneyAdapter.ViewHolder> {
    private List<Journey> journeyList;

    public JourneyAdapter(List<Journey> journeyList) {
        this.journeyList = journeyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.journey_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Journey journey = journeyList.get(position);

        holder.imageView.setImageResource(journey.getImageResourceId());
        holder.nameTextView.setText(journey.getName());
        holder.costTextView.setText(String.valueOf(journey.getCost()));
        holder.timeTextView.setText(journey.getTime());
        holder.locationTextView.setText(journey.getLocation());

        holder.tag1TextView.setText(journey.getTag1());
        holder.tag2TextView.setText(journey.getTag2());
        holder.tag3TextView.setText(journey.getTag3());
        holder.tag4TextView.setText(journey.getTag4());
        holder.tag5TextView.setText(journey.getTag5());
    }

    @Override
    public int getItemCount() {
        return journeyList.size();
    }

    public void sortByPriceAscending() {
        Collections.sort(journeyList, new Comparator<Journey>() {
            @Override
            public int compare(Journey journey1, Journey journey2) {
                return Double.compare(journey1.getCost(), journey2.getCost());
            }
        });
        notifyDataSetChanged();
    }

    public void sortByPriceDescending() {
        Collections.sort(journeyList, new Comparator<Journey>() {
            @Override
            public int compare(Journey journey1, Journey journey2) {
                return Double.compare(journey2.getCost(), journey1.getCost());
            }
        });
        notifyDataSetChanged();
    }

    public void sortByAlphabetAscending() {
        Collections.sort(journeyList, new Comparator<Journey>() {
            @Override
            public int compare(Journey journey1, Journey journey2) {
                return journey1.getName().compareToIgnoreCase(journey2.getName());
            }
        });
        notifyDataSetChanged();
    }

    public void sortByAlphabetDescending() {
        Collections.sort(journeyList, new Comparator<Journey>() {
            @Override
            public int compare(Journey journey1, Journey journey2) {
                return journey2.getName().compareToIgnoreCase(journey1.getName());
            }
        });
        notifyDataSetChanged();
    }

    public void setJourneyList(List<Journey> journeyList) {
        this.journeyList = journeyList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameTextView;
        public TextView costTextView;
        public TextView timeTextView;
        public TextView locationTextView;
        public TextView tag1TextView;
        public TextView tag2TextView;
        public TextView tag3TextView;
        public TextView tag4TextView;
        public TextView tag5TextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            costTextView = itemView.findViewById(R.id.costTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            tag1TextView = itemView.findViewById(R.id.tag1TextView);
            tag2TextView = itemView.findViewById(R.id.tag2TextView);
            tag3TextView = itemView.findViewById(R.id.tag3TextView);
            tag4TextView = itemView.findViewById(R.id.tag4TextView);
            tag5TextView = itemView.findViewById(R.id.tag5TextView);
        }
    }
}
