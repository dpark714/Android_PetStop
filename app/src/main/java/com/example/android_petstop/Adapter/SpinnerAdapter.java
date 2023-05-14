package com.example.android_petstop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_petstop.DropDownItem;
import com.example.android_petstop.R;

import java.util.List;
import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter{

    public SpinnerAdapter(@NonNull Context context, ArrayList<DropDownItem> dropDownList) {
        super(context, 0, dropDownList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout, parent, false);
        }
        DropDownItem item = (DropDownItem) getItem(position);
        ImageView spinnerIV = convertView.findViewById(R.id.ivSpinnerLayout);
        TextView spinnerTV = convertView.findViewById(R.id.tvSpinnerLayout);
        if (item != null){
            spinnerIV.setImageResource(item.getSpinnerItemImage());
            spinnerTV.setText(item.getSpinnerItemName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dropdown_layout, parent, false);
        }
        DropDownItem item = (DropDownItem) getItem(position);
        ImageView dropDownIV = convertView.findViewById(R.id.ivDropDownLayout);
        TextView dropDownTV = convertView.findViewById(R.id.tvDropDownLayout);
        if (item != null){
            dropDownIV.setImageResource(item.getSpinnerItemImage());
            dropDownTV.setText(item.getSpinnerItemName());
        }
        return convertView;
    }
}
