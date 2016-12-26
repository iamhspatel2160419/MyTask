package com.example.dadabhagwan.mytask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dadabhagwan.mytask.R;
import com.example.dadabhagwan.mytask.plainOldJavaObject.Model;

import java.util.ArrayList;

/**
 * Created by dadabhagwan on 10/17/2016.
 */

public class CustomAdapter extends BaseAdapter {

    public LayoutInflater inflatering;
    public ArrayList<Model> ModelData;
    public Context context;

    public CustomAdapter(ArrayList<Model> m, Context c) {
        this.ModelData = m;
        this.context = c;
        inflatering = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ModelData.size();
    }


    @Override
    public Model getItem(int i) {
        return ModelData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ViewHolder holder;

        if (view == null) {


//            v = inflatering.inflate(R.layout.show_raw,linearLayout,false);
            holder = new ViewHolder();
            holder.TvFirstName = (TextView) v.findViewById(R.id.tvFname);
            holder.TvLastName = (TextView) v.findViewById(R.id.tvLname);
            holder.TvRollNumber = (TextView) v.findViewById(R.id.tvRollNumber);
            holder.TvGender = (TextView) v.findViewById(R.id.tvGender);
            holder.TvCity = (TextView) v.findViewById(R.id.tvCity);
            v.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) v.getTag();
     //       ModelData.get(i);
            holder.TvFirstName.setText(ModelData.get(i).getFirtsName());
            holder.TvLastName.setText(ModelData.get(i).getLastName());
            holder.TvCity.setText(ModelData.get(i).getCity());
            holder.TvGender.setText(ModelData.get(i).getGender());
            holder.TvRollNumber.setText(ModelData.get(i).getRollNo()+"");


        }
        return v;
    }

    public static class ViewHolder {
        public TextView TvFirstName;
        public TextView TvLastName;
        public TextView TvRollNumber;
        public TextView TvGender;
        public TextView TvCity;

    }
    }

