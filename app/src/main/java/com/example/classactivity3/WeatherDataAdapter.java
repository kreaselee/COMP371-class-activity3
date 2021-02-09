package com.example.classactivity3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherDataAdapter extends RecyclerView.Adapter<WeatherDataAdapter.ViewHolder> {

    private List<WeatherData> weatherDataList;

    // pass this list into the constructor of the adapter
    public WeatherDataAdapter(List<WeatherData> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout from xml and return the ViewHolder
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // inflate the custom layout
        View dataView = inflater.inflate(R.layout.item_weatherdata, parent, false);
        // return new ViewHolder
        ViewHolder viewHolder = new ViewHolder(dataView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // populate data into the item through holder
        // grab data model (aka WeatherData object) based on position
        WeatherData weatherData = weatherDataList.get(position);
        // set the view
        holder.textView_time.setText(weatherData.getTime());
        holder.textView_description.setText(weatherData.getWeatherDescription());
        holder.textView_temp.setText(weatherData.getTemp());
    }

    @Override
    public int getItemCount() {
        return weatherDataList.size();
    }

    // reference to each view in data item
    class ViewHolder extends RecyclerView.ViewHolder{

        // views to set
        TextView textView_time;
        TextView textView_description;
        TextView textView_temp;

        // constructor
        public ViewHolder(View itemView) {
            super(itemView);
            // look up each view
            textView_time = itemView.findViewById(R.id.textView_time);
            textView_description = itemView.findViewById(R.id.textView_description);
            textView_temp = itemView.findViewById(R.id.textView_temp);
        }
    }
}
