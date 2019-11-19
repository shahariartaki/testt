package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data extends AppCompatActivity {

    HashMap<Integer,ArrayList<String>> mymap;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        listView=findViewById(R.id.mulistview);


        Intent intent = getIntent();

        mymap = (HashMap<Integer, ArrayList<String>>) getIntent().getSerializableExtra("data");
        ArrayList<datvalue> myllist=new ArrayList<>();

        for(int i=0;i<mymap.size();i++){
            ArrayList<String>temp =mymap.get(i);

            String firstname=temp.get(0);
            String lastname=temp.get(1);
            String age=temp.get(2);
            String height=temp.get(3);

            myllist.add(new datvalue(firstname,lastname,age,height));

        }

        something something=new something(this,myllist);
        listView.setAdapter(something);


    }

    class something extends ArrayAdapter {


        public something(@NonNull Context context, ArrayList<datvalue> mydata) {
            super(context, 0, mydata);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if(convertView==null){
                convertView= LayoutInflater.from(getContext()).inflate(R.layout.datashow,parent,false);
            }

            datvalue datvalue=(datvalue) getItem(position);

            TextView namefield=convertView.findViewById(R.id.text1);
            TextView lastname=convertView.findViewById(R.id.text2);
            TextView age=convertView.findViewById(R.id.text3);
            TextView height=convertView.findViewById(R.id.text4);


            namefield.setText(datvalue.firstname);
            lastname.setText(datvalue.lastname);
            age.setText(datvalue.age);
            height.setText(datvalue.height);
            return convertView;
        }
    }
    class datvalue{
        String firstname,lastname,age,height;
        public datvalue(String first,String last,String ag,String he){
            firstname=first;
            lastname=last;
            age=ag;
            height=he;
        }
    }
}
