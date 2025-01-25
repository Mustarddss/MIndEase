package com.example.updatedidverification;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class Face_Verification extends AppCompatActivity {

    private static final int PICK_IMAGE_FRONT = 1;
    private static final int PICK_IMAGE_RIGHT = 2;
    private static final int PICK_IMAGE_LEFT = 3;

    private ImageView frontImagePreview, rightImagePreview, leftImagePreview;
    private Button btnContinue;
    private boolean isFrontUploaded = false, isRightUploaded = false, isLeftUploaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face_verification);

        frontImagePreview = findViewById(R.id.frontImagePreview);
        rightImagePreview = findViewById(R.id.rightImagePreview);
        leftImagePreview = findViewById(R.id.leftImagePreview);
        btnContinue = findViewById(R.id.btnContinue);
        findViewById(R.id.backArrow).setOnClickListener(v -> finish());

        // Set "ID Verification"  title in the white background
        TextView titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setText("ID Verification");

        findViewById(R.id.uploadFrontLayout).setOnClickListener(v -> openGallery(PICK_IMAGE_FRONT));
        findViewById(R.id.uploadRightLayout).setOnClickListener(v -> openGallery(PICK_IMAGE_RIGHT));
        findViewById(R.id.uploadLeftLayout).setOnClickListener(v -> openGallery(PICK_IMAGE_LEFT));

        btnContinue.setOnClickListener(v -> {
            if (!isFrontUploaded || !isRightUploaded || !isLeftUploaded) {
                showMissingImagePopup();
            } else {
                showCompletionPopup();
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
                    } else if (requestCode == PICK_IMAGE_RIGHT) {
                        rightImagePreview.setVisibility(View.VISIBLE);
                        rightImagePreview.setImageBitmap(bitmap);
                        isRightUploaded = true;
                    } else if (requestCode == PICK_IMAGE_LEFT) {
                        leftImagePreview.setVisibility(View.VISIBLE);
                        leftImagePreview.setImageBitmap(bitmap);
                        isLeftUploaded = true;
                    }

                    checkIfAllImagesUploaded();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkIfAllImagesUploaded() {
        btnContinue.setEnabled(isFrontUploaded && isRightUploaded && isLeftUploaded);
    }

    // Popup for missing images
    private void showMissingImagePopup() {
        new AlertDialog.Builder(this)
                .setTitle("Incomplete Submission")
                .setMessage("Please upload all required images before proceeding.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // Popup for successful verification
    private void showCompletionPopup() {
        new AlertDialog.Builder(this)
                .setTitle("Verification Complete")
                .setMessage("You can now log in to your account.")
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                    Intent intent = new Intent(Face_Verification.this, Choose_ID.class); // Example destination
                    startActivity(intent);
                    finish(); // Close current activity
                })
                .show();
    }
}
