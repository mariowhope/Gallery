package com.pucpr.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonLogIn;
    Button buttonSignIn;
    String usernameHC = "";
    String passwordHC = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getActionBar().hide();
        editTextUsername =  findViewById(R.id.editTextUsername);
        editTextPassword =  findViewById(R.id.editTextPassword);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonSignIn = findViewById(R.id.buttonSignIn);
    }

    public void onClickLogIn (View view){
        Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
        intent.putExtra("data",usernameHC);
        startActivity(intent);
        if(usernameHC.isEmpty() && passwordHC.isEmpty()){
            //TODO: Prompt to register user/pw;
        }else if(editTextUsername.toString().equals(usernameHC) && editTextPassword.toString().equals(passwordHC)){
            //TODO: Intent to activity-gallery;
        }else {
            //TODO: Prompt wrong credentials;
        }
    }

    public void onClickSignIn (View view){
        usernameHC = editTextUsername.toString();
        passwordHC = editTextPassword.toString();
        Toast.makeText(MainActivity.this, usernameHC+"-"+passwordHC,Toast.LENGTH_LONG).show();
    }
}