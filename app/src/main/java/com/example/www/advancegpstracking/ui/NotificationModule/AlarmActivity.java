package com.example.www.advancegpstracking.ui.NotificationModule;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.www.advancegpstracking.R;
import com.google.android.gms.maps.model.LatLng;

public class AlarmActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText alarm_latitude,alarm_longitude,alarm_start_range,alarm_end_range,alarm_id;
    Button btn_insert,btn_view,btn_update,btn_delete;
    Double c_latitude,c_longitude,d_latitude,d_longitude;
    LatLng clatlng,dlatlng;
    String c,d;
    public final static String EXTRA_MESSAGE1="EXTRA_MESSAGE1";
    public final static String EXTRA_MESSAGE2="EXTRA_MESSAGE2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_notification);
        mydb=new DatabaseHelper(this);
        alarm_latitude=findViewById(R.id.alarm_latitude_module);
        alarm_longitude=findViewById(R.id.alarm_longitude_module);
        alarm_start_range=findViewById(R.id.alarm_start_range_module);
        alarm_end_range=findViewById(R.id.alarm_end_range_module);
        alarm_id=findViewById(R.id.alarm_id_module);
        btn_insert=findViewById(R.id.alarm_insert);
        btn_view=findViewById(R.id.alarm_view);
        btn_update=findViewById(R.id.alarm_update);
        btn_delete=findViewById(R.id.alarm_delete);
        Intent map = getIntent();


         c=map.getStringExtra(AlarmActivity.EXTRA_MESSAGE1);
        d=map.getStringExtra(AlarmActivity.EXTRA_MESSAGE2);
        alarm_latitude.setText(c);
      alarm_latitude.setEnabled(false);
        alarm_latitude.setClickable(false);
        alarm_longitude.setText(d);
        alarm_longitude.setEnabled(false);
        Toast.makeText(this, ""+c+"\n"+d, Toast.LENGTH_SHORT).show();

        AddData();
        viewAll();
        updataData();
        DeleteData();
    }
    public void AddData(){
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             boolean isInserted=   mydb.insertData(alarm_latitude.getText().toString(),
                        alarm_longitude.getText().toString(),
                        alarm_start_range.getText().toString(),
                        alarm_end_range.getText().toString());
             if(isInserted){
                 Toast.makeText(AlarmActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
             }else    {
                 Toast.makeText(AlarmActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
             }

            }
        });


    }
    public void viewAll(){
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Cursor res= mydb.getAllData();
               if(res.getCount()==0){
                   //show message
                   showMessage("Error","No Data Found");
                   return;
               }

                   StringBuffer buffer=new StringBuffer();

               while (res.moveToNext()){
                   buffer.append("Id :"+res.getString(0)+"\n");
                   buffer.append("Latitude :"+res.getString(1)+"\n");
                   buffer.append("Longitude :"+res.getString(2)+"\n");
                   buffer.append("Start Range :"+res.getString(3)+"\n");
                   buffer.append("End Range :"+res.getString(4)+"\n\n");



               }
               //show ALL Data
                showMessage("Data",buffer.toString());
            }
        });
    }
    public void updataData(){
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean isUpdate = mydb.updateData(alarm_id.getText().toString(),
                      alarm_latitude.getText().toString(),
                      alarm_longitude.getText().toString(),
                      alarm_start_range.getText().toString(),
                      alarm_end_range.getText().toString() );
              if(isUpdate){
                  Toast.makeText(AlarmActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();

              }else    {
                  Toast.makeText(AlarmActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
              }
            }
        });
    }
    public  void DeleteData(){
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Integer deletedRows= mydb.deleteData(alarm_id.getText().toString());
               if(deletedRows>0){
                   Toast.makeText(AlarmActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();

               }else    {
                   Toast.makeText(AlarmActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }
}
