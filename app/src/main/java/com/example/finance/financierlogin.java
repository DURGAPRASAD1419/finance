package com.example.finance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class financierlogin extends AppCompatActivity {

    ProgressBar progress;
    TextView forgot1;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financierlogin);
        TextInputEditText email1 = findViewById(R.id.email);
        TextInputEditText pass= findViewById(R.id.pass);
        Button login = findViewById(R.id.login);
        TextView dont = findViewById(R.id.text2);
        forgot1=findViewById(R.id.forgot);
        progress=findViewById(R.id.pro);

        progress.setVisibility(View.GONE);
        auth= FirebaseAuth.getInstance();




        if(auth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(), user.class));
            finish();
        }
        dont.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),signup.class));
            finish();
        });
        login.setOnClickListener(view -> {
            String txt_email= Objects.requireNonNull(email1.getText()).toString();
            String txt_password= Objects.requireNonNull(pass.getText()).toString();

            loginUser(txt_email,txt_password);

        });
        forgot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(financierlogin.this,forgot.class));

            }
        });

    }
    private void loginUser(String email,String password){
        progress.setVisibility(View.VISIBLE);

        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(authResult -> {
            progress.setVisibility(View.GONE);


            Toast.makeText(financierlogin.this,"Login successful",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), user.class));
            finish();
        }).addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception e) {
                progress.setVisibility(View.GONE);
                Toast.makeText(financierlogin.this,e.getMessage() ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}