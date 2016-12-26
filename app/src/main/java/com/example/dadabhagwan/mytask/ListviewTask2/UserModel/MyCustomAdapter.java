package com.example.dadabhagwan.mytask.ListviewTask2.UserModel;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dadabhagwan.mytask.Adapter.CustomAdapter;
import com.example.dadabhagwan.mytask.ListviewTask2.UserModel.Activities.FirstActivity;
import com.example.dadabhagwan.mytask.ListviewTask2.UserModel.Activities.SecondActivity;
import com.example.dadabhagwan.mytask.R;

import java.util.ArrayList;

/**
 * Created by dadabhagwan on 10/18/2016.
 */

public class MyCustomAdapter extends BaseAdapter {

        LayoutInflater inflater;
        ArrayList<UserModel> getArrayList;
        ArrayList<String> update;
        Activity context;
    public MyCustomAdapter(ArrayList<UserModel> u, Activity c)
    {
        this.getArrayList=u;
        this.context=c;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return getArrayList.size();
    }

    @Override
    public UserModel getItem(int i) {
        return getArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View vi=view;
        ViewHolder holder ;
        if(view==null) {
         holder=new ViewHolder();
         vi= inflater.inflate(R.layout.getdata,null);
         holder.FName1= (TextView) vi.findViewById(R.id.tv1);
         holder.LName1= (TextView) vi.findViewById(R.id.tv2);
         holder.Update= (Button) vi.findViewById(R.id.btn1);
         holder.Delete= (Button) vi.findViewById(R.id.btn2);
            vi.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) vi.getTag();

            holder.FName1.setText(getArrayList.get(i).getFirstName());
            holder.LName1.setText(getArrayList.get(i).getLastName());
            holder.Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder adb=new AlertDialog.Builder(context);
                    adb.setTitle("Delete?");
                    adb.setMessage("Are you sure you want to delete " + i);
                    final int positionToRemove =i;
                    adb.setNegativeButton("Cancel", null);
                    adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            getArrayList.remove(positionToRemove);
                            notifyDataSetChanged();
                        }});
                    adb.show();

                }
            });
            holder.Update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Intent send=new Intent(context,SecondActivity.class);
                send.putExtra("fn",getArrayList.get(i).getFirstName());
                send.putExtra("ln",getArrayList.get(i).getLastName());
                send.putExtra("pos",i);
                context.startActivityForResult(send,100);

                }
            });


        }

        return vi;
    }

//
//    public void showInputDialog(final String data1, String data2, final int index)
//    {
//       final Dialog dialog=new Dialog(context);
//       dialog.setTitle("Input Box");
//       dialog.setContentView(R.layout.activity_second);
//        final EditText fn= (EditText) dialog.findViewById(R.id.ExtFirsName);
//        final EditText ln= (EditText) dialog.findViewById(R.id.EtxtLastname);
//        Button updating= (Button) dialog.findViewById(R.id.btnBackUpdate);
//        fn.setText( data1);
//        ln.setText( data2);
//        final   UserModel U=new UserModel();
//        U.setFirstName(fn.getText().toString());
//        U.setLastName(ln.getText().toString());
//
//        updating.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            getArrayList.set(index,U);
//            dialog.dismiss();
//
//            }
//        });
//        dialog.show();
//    }
//
//
//



    public static class ViewHolder
    {
    public TextView FName1;
    public TextView LName1;
    public Button Update,Delete;

    }
}
