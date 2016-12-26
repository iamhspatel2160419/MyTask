package com.example.dadabhagwan.mytask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dadabhagwan.mytask.Adapter.CustomAdapter;
import com.example.dadabhagwan.mytask.plainOldJavaObject.Model;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView List;
    Button BtnNext;
    ArrayList<Model> listData=new ArrayList<Model>();
    CustomAdapter cu;
    //Model myBackData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + i);
                final int positionToRemove = i;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        listData.remove(positionToRemove);
                        cu.notifyDataSetChanged();
                    }});
                adb.show();


            }
        });

        BtnNext.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i1=new Intent(MainActivity.this,SingleRowActivity.class);
             startActivityForResult(i1,1);


         }
     });
         }

    public void init()
    {
        List= (ListView) findViewById(R.id.list);
        BtnNext= (Button) findViewById(R.id.btnNext);

        cu=new CustomAdapter(listData,MainActivity.this);

        List.setAdapter(cu);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1) {
            if(data!=null) {
                Model i3 = data.getParcelableExtra("key1");
      //           Toast.makeText(this, i3.getFirtsName() + "\n" + i3.getLastName() + "\n" + i3.getCity() + "\n" + i3.getGender() + "\n" + i3.getRollNo(), Toast.LENGTH_SHORT).show();

                listData.add(i3);
                cu.notifyDataSetChanged();
            }
        }
    }


}
