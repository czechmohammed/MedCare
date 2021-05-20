package com.example.medcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton myImageButton;
    RecyclerView patientsRecycler;
    patientsAdapter patientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageButton = (ImageButton) findViewById(R.id.ib1);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, accountActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        List<patientsData> patientsDataList = new ArrayList<>();
        patientsDataList.add(new patientsData("Patient 1","de 08h00","à 08h15",R.drawable.img_patient));
        patientsDataList.add(new patientsData("Patient 2","de 08h15","à 08h30",R.drawable.img_patient));
        patientsDataList.add(new patientsData("Patient 3","de 08h30","à 08h45",R.drawable.img_patient));
        patientsDataList.add(new patientsData("Patient 4","de 08h45","à 09h00",R.drawable.img_patient));
        patientsDataList.add(new patientsData("Patient 5","de 09h00","à 09h15",R.drawable.img_patient));
        patientsDataList.add(new patientsData("Patient 6","de 09h15","à 09h30",R.drawable.img_patient));
        patientsDataList.add(new patientsData("Patient 7","de 09h30","à 09h45",R.drawable.img_patient));
        patientsDataList.add(new patientsData("Patient 8","de 09h45","à 10h00",R.drawable.img_patient));

        setpatientsRecycler(patientsDataList);
    }

    private  void setpatientsRecycler(List<patientsData> patientsDataList){

        patientsRecycler = findViewById(R.id.patients_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        patientsRecycler.setLayoutManager(layoutManager);
        patientsAdapter = new patientsAdapter(this, patientsDataList);
        patientsRecycler.setAdapter(patientsAdapter);

    }

}