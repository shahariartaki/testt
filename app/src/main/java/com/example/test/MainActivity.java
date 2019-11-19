package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText fristName, LastName, Age, Hight;
    Button Add, View;
    HashMap <Integer , ArrayList<String>>data;
    ArrayList<String>alldata;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fristName=findViewById(R.id.firstname);
        LastName=findViewById(R.id.lastname);
        Age=findViewById(R.id.age);
        Hight=findViewById(R.id.hight);
        Add=findViewById(R.id.Add);
        View=findViewById(R.id.Show);
        data=new HashMap<>();

        View.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(android.view.View v) {
        Intent intent = new Intent(MainActivity.this,Data.class);
        intent.putExtra("data",data);
        startActivity(intent);
    }
});
Add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(android.view.View v) {
        alldata=new ArrayList<>();

        alldata.add(fristName.getText().toString());
        alldata.add(LastName.getText().toString());
        alldata.add(Age.getText().toString());
        alldata.add(Hight.getText().toString());
        data.put(i,alldata);
        Log.e("data",data.toString());
        i++;

    }
});
    }
}
