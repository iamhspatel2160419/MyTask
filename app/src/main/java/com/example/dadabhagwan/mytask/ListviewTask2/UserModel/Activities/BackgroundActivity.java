package com.example.dadabhagwan.mytask.ListviewTask2.UserModel.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dadabhagwan.mytask.ListviewTask2.UserModel.UserModel;

/**
 * Created by dadabhagwan on 10/19/2016.
 */

public class BackgroundActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                Intent i=getIntent();
                int i1 = i.getIntExtra("pos1", 0);
                String fname = i.getStringExtra("fn");
                String lname = i.getStringExtra("ln");
                UserModel o1 = new UserModel();
                o1.setFirstName(fname);
                o1.setLastName(lname);
                Toast.makeText(this, fname+" "+lname+" "+i1, Toast.LENGTH_SHORT).show();

//            Int   ent pack=new Intent(BackgroundActivity.this,FirstActivity.class);
//            pack.putExtra("fn",fname);
//            pack.putExtra("ln",lname);
//            pack.putExtra("pos1",i1);

            //setResult(,pack);
        //finish();



  //              setResult(RESULT_OK,);
    }
}
