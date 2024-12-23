<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fillViewport="true"
    android:background="#00454A"> <!-- Solid background color -->

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:gravity="center_horizontal"
        android:paddingTop="60dp"
        android:paddingBottom="40dp">


        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:gravity="center_horizontal">

            <TextView
                android:id="@+id/topTextView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="MIND OVER MATTER"
                android:textColor="#FFFFFF"
                android:textSize="12sp"
                android:textStyle="bold"
                android:gravity="center" />

            <TextView
                android:id="@+id/titleTextView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="MIND EASE"
                android:textColor="#FFFFFF"
                android:textSize="28sp"
                android:textStyle="bold"
                android:gravity="center"
                android:layout_marginTop="5dp" />

            <TextView
                android:id="@+id/subtitleTextView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="ANONYMOUS OUTREACH AND PROFESSIONAL CARE"
                android:textColor="#FFFFFF"
                android:textSize="12sp"
                android:gravity="center"
                android:layout_marginTop="5dp" />
        </LinearLayout>

        <!-- Logo Image -->
        <ImageView
            android:id="@+id/logoImageView"
            android:layout_width="180dp"
            android:layout_height="180dp"
            android:layout_marginTop="30dp"
            android:src="@drawable/logo"
            android:contentDescription="Logo" />

        <!-- Bottom Button -->
        <Button
            android:id="@+id/startButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="START YOUR JOURNEY"
            android:backgroundTint="#FFFFFF"
            android:textColor="#00454A"
            android:layout_marginTop="50dp"
            android:paddingHorizontal="30dp"
            android:layout_gravity="center_horizontal" />

    </LinearLayout>
</ScrollView>
