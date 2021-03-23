package com.pucpr.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GalleryActivity extends AppCompatActivity {
    // Variables
    ImageView imageViewGallery;
    TextView textViewIdentifier;
    TextView textViewTittle;
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
        textViewTittle = findViewById(R.id.textViewTittle);

        // Place array position and length on identifier
        textViewIdentifier.setText(selectedImage+1+"/"+images.length);

        // Get extra value (username) from goToGallery intent
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String user = extras.getString("username");
            textViewTittle.setText("Hello "+user);
        }
    }

    // Gallery Navigation Buttons method
    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables", "SetTextI18n"})
    public void navigationButtonClicked (View view) {
        Drawable d;
        switch (view.getId()){
            // Button Next
            case R.id.buttonNextImage:
                if(selectedImage >=0 && selectedImage < 4){
                    selectedImage++;
                }else{
                    selectedImage = 0;
                }
                d = getResources().getDrawable(getResources().getIdentifier(images[selectedImage],
                        "drawable", getPackageName()),this.getTheme());
                imageViewGallery.setImageDrawable(d);
                textViewIdentifier.setText(selectedImage+1+"/"+images.length);
                break;
            // Button Previous
            case (R.id.buttonPreviousImage):
                if(selectedImage >0 && selectedImage <= 4){
                    selectedImage--;
                }else{
                    selectedImage = 4;
                }
                d = getResources().getDrawable(getResources().getIdentifier(images[selectedImage],
                        "drawable", getPackageName()),this.getTheme());
                imageViewGallery.setImageDrawable(d);
                textViewIdentifier.setText(selectedImage+1+"/"+images.length);
                break;
        }

    }

}