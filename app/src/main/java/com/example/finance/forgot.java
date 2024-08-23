package com.example.finance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class forgot extends AppCompatActivity {

    public Button forgetbtn;
    private TextInputEditText txtEmail;
    private String email;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        auth=FirebaseAuth.getInstance();

        txtEmail=findViewById(R.id.email);
        forgetbtn=findViewById(R.id.btn);

        forgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }
    private void validateData(){
        email=txtEmail.getText().toString();
        if(email.isEmpty()){
            txtEmail.setError("Required");
        }
        else{
            forgetpass();
        }
    }
    private void forgetpass(){
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(forgot.this,"check your email",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(forgot.this,resetpassword.class));
                    finish();
                }
                else{
                    Toast.makeText(forgot.this,"Error"+ Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}