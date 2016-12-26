package com.example.dadabhagwan.mytask.DBusingDialogListViewDynamically;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dadabhagwan.mytask.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Main2Activity extends Activity implements DialogInterface.OnClickListener {

    @InjectView(R.id.editText3)
    EditText etName;
    @InjectView(R.id.editText4)
    EditText edPosition;
    @InjectView(R.id.button3)
    Button btnSave;
    @InjectView(R.id.button4)
    Button btnRetrive;
    DBadapter db;
    ArrayList<String> data=new ArrayList<String>();
    AlertDialog ad;
    //GridView grid;
    //Spinner sp;
    ListView list;
    ArrayAdapter<String> adapter;
    //SQLiteDatabase db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.inject(this);
      //  grid= (GridView) findViewById(R.id.grid);
        //sp= (Spinner) findViewById(R.id.spinner1);
         list= (ListView) findViewById(R.id.listviewData);
        list.setBackgroundColor(Color.GREEN);
        db=new DBadapter(this);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,data);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Main2Activity.this,data.get(i), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @OnClick({R.id.button3, R.id.button4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button3:
                db.openDB();

                long result = db.add(etName.getText().toString(), edPosition.getText().toString());
                if (result > 0) {
                    etName.setText("");
                    edPosition.setText("");
                } else {
                    Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
                }
                db.close();

                break;

            case R.id.button4:


                data.clear();
                db.openDB();

                Cursor c=db.getAllData();
                while(c.moveToNext())
                {
                    String name=c.getString(1);

                    data.add(name);
                }
                list.setAdapter(adapter);
         //       grid.setAdapter(adapter);
          //      sp.setAdapter(adapter);
           //     showDialog();
                db.close();
                break;}

    }
    private void showDialog()
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        int size=data.size();
        String[] name=new String[size];
        for(int i=0;i<size;i++)
        {
            name[i]=data.get(i);

        }
        builder.setItems(name,this);
        ad=builder.create();
        ad.setTitle("DATA BASE");
        ad.show();
    }


    @Override
    public void onClick(DialogInterface dialog, int pos) {
        Toast.makeText(this, data.get(pos), Toast.LENGTH_SHORT).show();

    }
}
