package com.example.dadabhagwan.mytask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by dadabhagwan on 10/18/2016.
 */

public class GetData extends Activity {
    Button btn1,btn2;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getdata);
        initilize();

    }
    public void initilize()
    {
        listView= (ListView) findViewById(R.id.listview);
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
    }
}
