package com.example.dadabhagwan.mytask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dadabhagwan.mytask.plainOldJavaObject.Model;

public class SingleRowActivity extends Activity {

    EditText EtFirstName,EtLastName,EtRollNo;
    Spinner SpinCity;
    RadioGroup RgGender;
    RadioButton RbMale,RbFemale;
    Model ModelData;
    Button btnSaveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_row);
        init1();


        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ModelData = new Model();
                ModelData.setFirtsName(EtFirstName.getText().toString());
                ModelData.setLastName(EtLastName.getText().toString());
                Integer roll_number = Integer.parseInt(EtRollNo.getText().toString()+"");
                ModelData.setRollNo(roll_number);
                int selectedId = RgGender.getCheckedRadioButtonId();
                if (selectedId == R.id.RbtnMale) {// find the radiobutton by returned id
                    RbMale = (RadioButton) findViewById(selectedId);
                    ModelData.setGender(RbMale.getText().toString());
                } else {
                    RbFemale = (RadioButton) findViewById(selectedId);
                    ModelData.setGender(RbFemale.getText().toString());
                }
                ModelData.setCity(SpinCity.getSelectedItem().toString());

                Intent i=new Intent(SingleRowActivity.this,MainActivity.class);

                i.putExtra("key1",ModelData);
                setResult(RESULT_OK,i);
                finish();

            }
        });



    }
    public void init1()
    {
        EtFirstName= (EditText) findViewById(R.id.etFirstName);
        EtLastName= (EditText) findViewById(R.id.etLastName);
        EtRollNo= (EditText) findViewById(R.id.etRollNumber);
        SpinCity= (Spinner) findViewById(R.id.spinnerCity);
        RgGender= (RadioGroup) findViewById(R.id.RgGender);
        RbMale= (RadioButton) findViewById(R.id.RbtnMale);
        RbFemale= (RadioButton) findViewById(R.id.RbtnFemale);
        btnSaveData= (Button) findViewById(R.id.btnSave);

//        GetData();
    }
//    public void GetData() {
//
//    }





    }


