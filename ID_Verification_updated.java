package com.example.updatedidverification;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class ID_Verification extends AppCompatActivity {

    private static final int PICK_IMAGE_FRONT = 1;
    private static final int PICK_IMAGE_BACK = 2;
    private static final int PICK_IMAGE_FACE = 3;

    private ImageView frontImagePreview, backImagePreview, faceImagePreview;
    private Button btnContinue;
    private boolean isFrontUploaded = false, isBackUploaded = false, isFaceUploaded = false;
    private String selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.id_verification);

        frontImagePreview = findViewById(R.id.frontImagePreview);
        backImagePreview = findViewById(R.id.backImagePreview);
        faceImagePreview = findViewById(R.id.faceImagePreview);
        btnContinue = findViewById(R.id.btnContinue);
        findViewById(R.id.backArrow).setOnClickListener(v -> finish());

        LinearLayout uploadFrontLayout = findViewById(R.id.uploadFrontLayout);
        LinearLayout uploadBackLayout = findViewById(R.id.uploadBackLayout);
        LinearLayout uploadFaceLayout = findViewById(R.id.uploadFaceLayout);
        TextView titleTextView = findViewById(R.id.titleTextView);

        // Get selected ID from previous activity
        selectedID = getIntent().getStringExtra("SELECTED_ID");
        if (selectedID != null) {
            titleTextView.setText(selectedID);
        }

        uploadFrontLayout.setOnClickListener(v -> openGallery(PICK_IMAGE_FRONT));
        uploadBackLayout.setOnClickListener(v -> openGallery(PICK_IMAGE_BACK));
        uploadFaceLayout.setOnClickListener(v -> openGallery(PICK_IMAGE_FACE));

        btnContinue.setOnClickListener(v -> {
            if (!isFrontUploaded || !isBackUploaded || !isFaceUploaded) {
                showMissingImagePopup();
            } else {
                Intent intent = new Intent(ID_Verification.this, Face_Verification.class);
                intent.putExtra("SELECTED_ID", selectedID);
                startActivity(intent);
            }
        });
    }

    private void openGallery(int requestCode) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);

                    if (requestCode == PICK_IMAGE_FRONT) {
                        frontImagePreview.setVisibility(View.VISIBLE);
                        frontImagePreview.setImageBitmap(bitmap);
                        isFrontUploaded = true;
                    } else if (requestCode == PICK_IMAGE_BACK) {
                        backImagePreview.setVisibility(View.VISIBLE);
                        backImagePreview.setImageBitmap(bitmap);
                        isBackUploaded = true;
                    } else if (requestCode == PICK_IMAGE_FACE) {
                        faceImagePreview.setVisibility(View.VISIBLE);
                        faceImagePreview.setImageBitmap(bitmap);
                        isFaceUploaded = true;
                    }

                    checkIfAllImagesUploaded();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkIfAllImagesUploaded() {
        btnContinue.setEnabled(isFrontUploaded && isBackUploaded && isFaceUploaded);
    }

    private void showMissingImagePopup() {
        new AlertDialog.Builder(this)
                .setTitle("Incomplete Submission")
                .setMessage("Please upload all required images before proceeding.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
