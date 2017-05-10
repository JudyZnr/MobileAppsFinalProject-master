package com.example.kamran.eleganttheme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by administorzz on 2017/5/10.
 */

public class FarmerAdapter extends ArrayAdapter<Farmer> {
    private int resourceId;

    public FarmerAdapter(Context context, int textViewResourceId, ArrayList<Farmer> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position , View convertView, ViewGroup parent){
        Farmer farmer= getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView farmerPhoto= (ImageView) view.findViewById(R.id.farmerPhoto);
        TextView farmerName = (TextView) view.findViewById(R.id.farmerName);
        TextView farmerPhone = (TextView) view.findViewById(R.id.farmerPhone);

        farmerPhoto.setImageResource(farmer.getImageId());
        farmerPhone.setText(farmer.getFarmerPhone());
        farmerName.setText(farmer.getFarmerName());
        return view;

    }
}