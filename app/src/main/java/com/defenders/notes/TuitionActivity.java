package com.defenders.notes;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TuitionActivity extends AppCompatActivity {



    Spinner spinnerClass,spinnerSubject;
    Button btnApply;
    EditText etName,etPhno;
    String classTxt = "Five( V )" , subjectTxt = "Science";
    ProgressDialog pd;

    AdView mAdView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuition);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView6);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        spinnerClass = findViewById(R.id.spinner_class);
        spinnerSubject = findViewById(R.id.spinner_subject);
        btnApply = findViewById(R.id.btn_apply);
        etName = findViewById(R.id.txt_tution_name);
        etPhno = findViewById(R.id.txt_tution_ph);

        pd = new ProgressDialog(this);

        pd.setTitle("Apply for tuition");
        pd.setMessage("applying...");
        pd.setCancelable(false);



        List<String> classes = new ArrayList<>();
        classes.add("Five( V )");
        classes.add("Six( VI )");
        classes.add("Seven( VII )");
        classes.add("Eight( VIII )");
        classes.add("Nine( IX )");
        classes.add("Ten( X )");

        ArrayAdapter<String> classAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, classes);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClass.setAdapter(classAdapter);


        List<String> subjects = new ArrayList<>();
        subjects.add("Science");
        subjects.add("Mathematics");
        subjects.add("Social science");
        subjects.add("All");

        ArrayAdapter<String> subAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subjects);
        subAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(subAdapter);


        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                classTxt = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subjectTxt = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String phNo = etPhno.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phNo) || TextUtils.isEmpty(classTxt) || TextUtils.isEmpty(subjectTxt)) {

                    Toast.makeText(TuitionActivity.this, "Empty field", Toast.LENGTH_SHORT).show();
                } else {
                    pd.show();

                    Calendar calendar = Calendar.getInstance();

                    SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                    SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
                    final String tuitionRandomKey = currentDate.format(calendar.getTime()) + currentTime.format(calendar.getTime());
                    Map<String, Object> tutMap = new HashMap<>();

                    tutMap.put("name", name);
                    tutMap.put("phone_no", phNo);
                    tutMap.put("class", classTxt);
                    tutMap.put("subject", subjectTxt);

                    FirebaseDatabase.getInstance().getReference().child("Tuition").child(tuitionRandomKey).updateChildren(tutMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            etName.setText("");
                            etPhno.setText("");
                            pd.dismiss();
                            Toast.makeText(TuitionActivity.this, "Applied successfully", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });


    }
}
