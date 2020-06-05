package com.defenders.notes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import id.zelory.compressor.Compressor;

public class DoubtActivity extends AppCompatActivity {


    ImageView imgDoubt;
    EditText txtDoubt,txtName,txtPhoneNo;
    Button btnSubmitDoubt;
    Uri ImageUri = null;
    ProgressDialog pd;

    String downloadImgUrl;

    private StorageReference storageReference;
    private Bitmap compressedImageFile;
    AdView mAdView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubt);




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView7);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        imgDoubt = findViewById(R.id.img_doubt);
        txtDoubt = findViewById(R.id.txt_doubt);
        txtName = findViewById(R.id.txt_name);
        txtPhoneNo = findViewById(R.id.txt_phone_no);
        btnSubmitDoubt = findViewById(R.id.btn_submit_doubt);

        pd = new ProgressDialog(this);

        pd.setTitle("doubt Submission");
        pd.setMessage("sending details...");
        pd.setCancelable(false);


        imgDoubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setAspectRatio(9, 16)
                        .start(DoubtActivity.this);
            }
        });


        btnSubmitDoubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String doubt = txtDoubt.getText().toString();
                final String name = txtName.getText().toString();
                final String PhoneNo = txtPhoneNo.getText().toString();

                if (TextUtils.isEmpty(doubt) || TextUtils.isEmpty(name) || TextUtils.isEmpty(PhoneNo) || ImageUri == null) {
                    Toast.makeText(DoubtActivity.this, "Empty field", Toast.LENGTH_SHORT).show();
                } else {


                    pd.show();
                    Calendar calendar = Calendar.getInstance();

                    SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                    SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
                    final String doubtRandomKey = currentDate.format(calendar.getTime()) + currentTime.format(calendar.getTime());
                    File newImageFile = new File(ImageUri.getPath());

                    try {
                        compressedImageFile = new Compressor(DoubtActivity.this)
                                .setMaxHeight(1080)
                                .setMaxWidth(1080)
                                .setQuality(50)
                                .compressToBitmap(newImageFile);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    compressedImageFile.compress(Bitmap.CompressFormat.JPEG, 50, baos);
                    byte[] imageData = baos.toByteArray();

                    storageReference = FirebaseStorage.getInstance().getReference();

                    final StorageReference filePath_ref = storageReference.child("Doubts").child(doubtRandomKey).child("certificate.jpg");

                    final UploadTask filePath = filePath_ref.putBytes(imageData);
                    filePath.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            String message = e.toString();
                            Toast.makeText(DoubtActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                            pd.dismiss();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> urlTask = filePath.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                @Override
                                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                    if (!task.isSuccessful()) {
                                        throw task.getException();
                                    }

                                    downloadImgUrl = filePath_ref.getDownloadUrl().toString();
                                    return filePath_ref.getDownloadUrl();
                                }
                            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()) {
                                        downloadImgUrl = task.getResult().toString();
                                        Map<String, Object> doubtMap = new HashMap<>();
                                        doubtMap.put("doubt_txt", doubt);
                                        doubtMap.put("doubt_name", name);
                                        doubtMap.put("doubt_phone_no", PhoneNo);
                                        doubtMap.put("doubt_image",downloadImgUrl);
                                        FirebaseDatabase.getInstance().getReference().child("Doubts").child(doubtRandomKey).updateChildren(doubtMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                if(!task.isSuccessful()){
                                                    Toast.makeText(DoubtActivity.this, "error. Try again later", Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                    Toast.makeText(DoubtActivity.this, "Submitted successfully.", Toast.LENGTH_SHORT).show();
                                                    txtDoubt.setText("");
                                                    txtName.setText("");
                                                    txtPhoneNo.setText("");
                                                    imgDoubt.setImageDrawable(getResources().getDrawable(R.drawable.ic_cloud_upload_black_24dp));
                                                    pd.dismiss();
                                                }

                                            }
                                        });


                                    }
                                }

                            });
                        }

                    });
                }
            }

            });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                ImageUri = result.getUri();
                imgDoubt.setImageURI(ImageUri);


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();

            }
        }

    }
}
