package com.pucpr.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity {
    // Variables
    ImageView imageViewGallery;
    TextView textViewIdentifier;
    TextView textViewTitle;
    int selectedImage = 0;
    String[] images = new String[]{"squirtle","butterfree","charizard","eevee","vaporeon"};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        // Instancing variables
        imageViewGallery = findViewById(R.id.imageViewGallery);
        textViewIdentifier = findViewById(R.id.textViewIdentifier);
        textViewTitle = findViewById(R.id.textViewTitle);

        // Setting array position and length on identifier
        textViewIdentifier.setText(selectedImage+1+"/"+images.length);
        // Setting title according to image displayed
        textViewTitle.setText(images[selectedImage].toUpperCase());

        // Set GalleryActivity title with extra value (username) from goToGallery intent
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String user = extras.getString("username");
            setTitle("Hello "+user);
        }
    }

    // Gallery Navigation Buttons method
    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables", "SetTextI18n"})
    public void navigationButtonClicked (View view) {
        Drawable d;
        switch (view.getId()){
            // Button Next :: Loop stack
            case R.id.buttonNextImage:
                if(selectedImage >=0 && selectedImage < 4){
                    selectedImage++;
                }else{
                    selectedImage = 0;
                }
                d = getResources().getDrawable(getResources().getIdentifier(images[selectedImage],
                        "drawable", getPackageName()),this.getTheme());
                imageViewGallery.setImageDrawable(d);
                // Setting array position and length on identifier
                textViewIdentifier.setText(selectedImage+1+"/"+images.length);
                // Setting title according to image displayed
                textViewTitle.setText(images[selectedImage].toUpperCase());
                break;
            // Button Previous :: Loop stack
            case (R.id.buttonPreviousImage):
                if(selectedImage >0 && selectedImage <= 4){
                    selectedImage--;
                }else{
                    selectedImage = 4;
                }
                d = getResources().getDrawable(getResources().getIdentifier(images[selectedImage],
                        "drawable", getPackageName()),this.getTheme());
                imageViewGallery.setImageDrawable(d);
                // Setting array position and length on identifier
                textViewIdentifier.setText(selectedImage+1+"/"+images.length);
                // Setting title according to image displayed
                textViewTitle.setText(images[selectedImage].toUpperCase());
                break;
        }

    }

}