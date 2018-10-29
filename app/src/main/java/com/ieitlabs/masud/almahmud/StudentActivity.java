package com.ieitlabs.masud.almahmud;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    private ArrayList<String> department_data;
    private ArrayList<String> division_data;
    private ArrayList<String> district_data;
    private ArrayList<String> subdistrict_data;
    private ArrayList<ArrayList<String>> mDataset;
    private String selectedDiv;
    private String selectedDept;
    private String selectedDist;
    private String selectedSubDist;
    RecyclerView RVStudentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        setTitle("ফারেগীন ২০১৮ ইং");

        mDataset = (new DBManager(this)).getOverview("","জামাত...","বিভাগ...", "জেলা...","থানা...");

        RVStudentView = findViewById(R.id.student_recycler_view);
        LinearLayoutManager stLayoutManager = new LinearLayoutManager(this);
        RVStudentView.setLayoutManager(stLayoutManager);
        StudentViewAdapter mAdapter;
        mAdapter = new StudentViewAdapter(mDataset,this);
        RVStudentView.setAdapter(mAdapter);

        final EditText searchBar = findViewById(R.id.search_bar);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");
        searchBar.setTypeface(custom_font);

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

                selectedDept = department_data.get(i);
                division_data = (new DBManager(getApplicationContext())).getDivision(selectedDept);
                final ArrayList<String> divWithHint = new ArrayList<>();
                divWithHint.add("বিভাগ...");
                divWithHint.addAll(division_data);
                division_data = divWithHint;
                mDataset = (new DBManager(StudentActivity.this)).getOverview(searchBar.getText().toString(),selectedDept,"বিভাগ...", "জেলা...","থানা...");
                itemChanged();

                final Spinner division = findViewById(R.id.division);
                ArrayAdapter<String> divisionDataAdapter = new StudentSpinnerAdapter(StudentActivity.this,division_data);
                divisionDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                division.setAdapter(divisionDataAdapter);

                division.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        selectedDiv = division_data.get(i);
                        district_data = (new DBManager(getApplicationContext())).getDistrict(selectedDept,selectedDiv);
                        ArrayList<String> distWithHint = new ArrayList<>();
                        distWithHint.add("জেলা...");
                        distWithHint.addAll(district_data);
                        district_data = distWithHint;

                        mDataset = (new DBManager(StudentActivity.this)).getOverview(searchBar.getText().toString(),selectedDept,selectedDiv, "জেলা...","থানা...");
                        itemChanged();

                        final Spinner district = findViewById(R.id.district);
                        ArrayAdapter<String> districtDataAdapter = new StudentSpinnerAdapter(StudentActivity.this,district_data);
                        districtDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        district.setAdapter(districtDataAdapter);

                        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                selectedDist = district_data.get(i);
                                subdistrict_data = (new DBManager(getApplicationContext())).getSubDistrict(selectedDept,selectedDiv,selectedDist);
                                ArrayList<String> subdistWithHint = new ArrayList<>();
                                subdistWithHint.add("থানা...");
                                subdistWithHint.addAll(subdistrict_data);
                                subdistrict_data = subdistWithHint;

                                mDataset = (new DBManager(StudentActivity.this)).getOverview(searchBar.getText().toString(),selectedDept,selectedDiv, selectedDist,"থানা...");
                                itemChanged();

                                final Spinner subdistrict = findViewById(R.id.subdistrict);
                                ArrayAdapter<String> subdistrictDataAdapter = new StudentSpinnerAdapter(StudentActivity.this,subdistrict_data);
                                subdistrictDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                subdistrict.setAdapter(subdistrictDataAdapter);

                                subdistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        selectedSubDist = subdistrict_data.get(i);

                                        mDataset = (new DBManager(StudentActivity.this)).getOverview(searchBar.getText().toString(),selectedDept,selectedDiv, selectedDist,selectedSubDist);
                                        itemChanged();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                searchBar.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        mDataset = (new DBManager(StudentActivity.this)).getOverview(searchBar.getText().toString(),selectedDept,selectedDiv, selectedDist,selectedSubDist);
                        itemChanged();
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void itemChanged()
    {
        StudentViewAdapter adapter = (StudentViewAdapter) RVStudentView.getAdapter();
        adapter.setmDataset(mDataset);
        adapter.notifyDataSetChanged();
    }
}
