package com.ieitlabs.masud.almahmud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    private ArrayList<String> department_data;
    private ArrayList<String> division_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        setTitle("ফারেগীন ২০১৮ ইং");

        department_data = (new DBManager(this)).getDepartment();
        ArrayList<String> deptWithHint = new ArrayList<>();
        deptWithHint.add("জামাত...");
        deptWithHint.addAll(department_data);
        department_data=deptWithHint;

        final Spinner department = findViewById(R.id.department);
        ArrayAdapter<String> departmentDataAdapter = new StudentSpinnerAdapter(this, department_data);
        departmentDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        department.setAdapter(departmentDataAdapter);

        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                final String selectedDept = department_data.get(i);
                division_data = (new DBManager(getApplicationContext())).getDivision(selectedDept);
                ArrayList<String> divWithHint = new ArrayList<>();
                divWithHint.add("বিভাগ...");
                divWithHint.addAll(division_data);
                division_data = divWithHint;

                final Spinner division = findViewById(R.id.division);
                ArrayAdapter<String> divisionDataAdapter = new StudentSpinnerAdapter(StudentActivity.this,division_data);
                divisionDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                division.setAdapter(divisionDataAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
