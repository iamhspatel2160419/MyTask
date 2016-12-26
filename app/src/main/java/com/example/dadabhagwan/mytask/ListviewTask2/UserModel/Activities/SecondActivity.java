package com.example.dadabhagwan.mytask.ListviewTask2.UserModel.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dadabhagwan.mytask.ListviewTask2.UserModel.MyCustomAdapter;
import com.example.dadabhagwan.mytask.ListviewTask2.UserModel.UserModel;
import com.example.dadabhagwan.mytask.MainActivity;
import com.example.dadabhagwan.mytask.R;
import com.example.dadabhagwan.mytask.SingleRowActivity;

public class SecondActivity extends Activity {

    EditText firstName,lastName;
    Button Save;
    Intent set;
    int pos;
    String fn,ln;
    //private static final int RESULT_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();
        updatedata();






        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel setData=new UserModel();
                setData.setFirstName(firstName.getText().toString());
                setData.setLastName(lastName.getText().toString());
                Intent i=new Intent(SecondActivity.this,FirstActivity.class);
                i.putExtra("key1",setData);
                i.putExtra("pos1",pos);

                setResult(RESULT_OK,i);
                finish();

            }
        });
    }
    public void initialize()
    {
       firstName= (EditText) findViewById(R.id.ExtFirsName);
       lastName= (EditText) findViewById(R.id.EtxtLastname);
       Save= (Button) findViewById(R.id.btnUpdate);

    }
    public void updatedata()
    {

        set=getIntent();
        pos=set.getIntExtra("pos",0);
        fn=set.getStringExtra("fn");
        ln=set.getStringExtra("ln");
        firstName.setText(fn);
        lastName.setText(ln);
        Toast.makeText(this, pos+""+fn+"\n"+ln, Toast.LENGTH_SHORT).show();

    }

}
