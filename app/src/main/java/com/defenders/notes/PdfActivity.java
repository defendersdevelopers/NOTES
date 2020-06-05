package com.defenders.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {

    PDFView study01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        String pdfName = getIntent().getExtras().get("pdf_name").toString();
        study01=(PDFView) findViewById(R.id.pdfView01);

        study01.fromAsset(pdfName+".pdf").load();



    }
}
