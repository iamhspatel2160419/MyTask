package com.example.dadabhagwan.mytask.ListviewTask2.UserModel.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dadabhagwan.mytask.ListviewTask2.UserModel.MyCustomAdapter;
import com.example.dadabhagwan.mytask.ListviewTask2.UserModel.UserModel;
import com.example.dadabhagwan.mytask.MainActivity;
import com.example.dadabhagwan.mytask.R;
import com.example.dadabhagwan.mytask.SingleRowActivity;

import java.util.ArrayList;

public class FirstActivity extends Activity {

    public ListView List;
    public  Button btnNext,btnDelete,btnUpdate,btnShowListview;
    public ArrayList<UserModel> arrayListData=new ArrayList<UserModel>();
    public MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initialize();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(i1,1);

            }
        });
        btnShowListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(FirstActivity.this);
                dialog.setTitle("My List View");
                dialog.setContentView(R.layout.activity_first);
                List= (ListView) dialog.findViewById(R.id.listview);

                adapter=new MyCustomAdapter(arrayListData,FirstActivity.this);
                List.setAdapter(adapter);
                adapter.notifyDataSetChanged();


                dialog.dismiss();
                dialog.show();
            }
        });


    }
    public void initialize()
    {

       btnNext= (Button) findViewById(R.id.btnNext1);
       btnDelete= (Button) findViewById(R.id.btn1);
       btnUpdate= (Button) findViewById(R.id.btn2);
       btnShowListview= (Button) findViewById(R.id.btnShowListView);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1) {
            if(data!=null) {
                UserModel i3 = data.getParcelableExtra("key1");
                arrayListData.add(i3);
               // adapter.notifyDataSetChanged();

            }
        }


        else if(requestCode==100) {
            if (resultCode == RESULT_OK) {
                if (data != null) {


                    int i1 = data.getIntExtra("pos1", 0);
                    UserModel o1 = data.getParcelableExtra("key1");

                    arrayListData.set(i1, o1);
                 //   adapter.notifyDataSetChanged();
                }
            }
        }






    }
    }

