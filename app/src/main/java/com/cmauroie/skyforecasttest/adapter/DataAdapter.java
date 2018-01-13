package com.cmauroie.skyforecasttest.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmauroie.skyforecasttest.R;
import com.cmauroie.skyforecasttest.entities.DataCell;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mauricio on 12/1/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private List<DataCell> items;
    private Context context;

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        //private ImageView imageView;
        private TextView textViewDay;
        private ImageView imageViewIcon;
        private TextView textViewTemp;

        public DataViewHolder(View itemView) {
            super(itemView);
            textViewDay = (TextView) itemView.findViewById(R.id.name_day);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.icon_day);
            textViewTemp = (TextView) itemView.findViewById(R.id.temp_day);
        }
    }

    public DataAdapter(List<DataCell> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v;
        /*if (context instanceof SearchMovieActivity) {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_movie_found, viewGroup, false);
        } else {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_movie_card, viewGroup, false);
        }*/

        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_cell, viewGroup, false);

        return new DataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position) {

        holder.textViewDay.setText(items.get(position).day);
        holder.imageViewIcon.setImageResource(R.mipmap.ic_launcher);
        holder.textViewTemp.setText(items.get(position).temp + "°");

        String iconWeather = items.get(position).icon;
        if (iconWeather.equals("clear-night") || iconWeather.equals("partly-cloudy-night")) {
            holder.imageViewIcon.setImageDrawable(changeColor(R.drawable.icon_clear_night));
        }
        if(iconWeather.equals("clear-day") || iconWeather.equals("partly-cloudy-day")){
            holder.imageViewIcon.setImageDrawable(changeColor(R.drawable.icon_clear_day));
        }
        if(iconWeather.equals("rain")){
            holder.imageViewIcon.setImageDrawable(changeColor(R.drawable.icon_rain));
        }
        if(iconWeather.equals("snow")){
            holder.imageViewIcon.setImageDrawable(changeColor(R.drawable.icon_snow));
        }
        if(iconWeather.equals("sleet")){
            holder.imageViewIcon.setImageDrawable(changeColor(R.drawable.icon_sleet));
        }
        if(iconWeather.equals("wind")){
            holder.imageViewIcon.setImageDrawable(changeColor(R.drawable.icon_air));
        }
        if(iconWeather.equals("fog")){
            holder.imageViewIcon.setImageDrawable(changeColor(R.drawable.icon_fog));
        }
        if(iconWeather.equals("cloudy")){
            holder.imageViewIcon.setImageDrawable(changeColor(R.drawable.icon_cloudy));
        }
    }

    private Drawable changeColor(int id){
        Drawable d = context.getResources().getDrawable(id);
        int iconColor = Color.BLACK;
        d.mutate().setColorFilter( iconColor, PorterDuff.Mode.MULTIPLY );
        return d;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
