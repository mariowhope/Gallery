package com.pucpr.gallery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Variables
    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonLogIn;
    Button buttonSignIn;
    String usernameHC = "";
    String passwordHC = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove Title Bar !!After super.OnCreate!!
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        // Instancing variables
        editTextUsername =  findViewById(R.id.editTextUsername);
        editTextPassword =  findViewById(R.id.editTextPassword);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonSignIn = findViewById(R.id.buttonSignIn);
    }

    // Login method
    public void onClickLogIn (View view){
        // Check user credentials :: Hardcoded
        // Credentials are null: Alert
        if(usernameHC.isEmpty() && passwordHC.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(android.R.string.dialog_alert_title);
            builder.setMessage(R.string.login_register);
            builder.setPositiveButton(android.R.string.ok,null);
            builder.create().show();

        // Credentials match: Proceed to next Activity
        }else if(editTextUsername.getText().toString().equals(usernameHC) && editTextPassword.getText().toString().equals(passwordHC)){
            Intent goToGallery = new Intent(MainActivity.this, GalleryActivity.class);
            goToGallery.putExtra("username",usernameHC);
            startActivity(goToGallery);

        // Credentials doesn't match: Alert
        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(android.R.string.dialog_alert_title);
            builder.setMessage(R.string.login_wrong_credentials);
            builder.setPositiveButton(android.R.string.ok,null);
            builder.create().show();
        }
    }
    // Register credentials :: Hardcoded - No security
    public void onClickSignIn (View view){
        usernameHC = editTextUsername.getText().toString();
        passwordHC = editTextPassword.getText().toString();
    }
}