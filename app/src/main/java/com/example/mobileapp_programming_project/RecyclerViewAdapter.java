package com.example.mobileapp_programming_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<City> items;

    private boolean showImages = true;
    private boolean showCityNames = true;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, List<City> items, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.get().load(items.get(position).getImgURL()).fit().into(holder.img);
        holder.cityName.setText(items.get(position).getName());

        if (showImages) {
            holder.img.setVisibility(View.VISIBLE);
        }
        else {
            holder.img.setVisibility(View.GONE);
        }

        if (showCityNames) {
            holder.cityName.setVisibility(View.VISIBLE);
        }
        else {
            holder.cityName.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView cityName;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            img = itemView.findViewById(R.id.imageView1);
            cityName = itemView.findViewById(R.id.cityName);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(items.get(getBindingAdapterPosition()));
        }

    }

    public interface OnClickListener {
        void onClick(City item);
    }

    public void setItems(List<City> items) {
        this.items = items;
    }

    public void toggleHideImages() {
        this.showImages = !showImages;
    }

    public void toggleHideCityNames() {
        this.showCityNames = !showCityNames;
    }
}