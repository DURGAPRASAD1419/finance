package com.example.finance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class signup extends AppCompatActivity {

    private ProgressBar progress;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextInputEditText email1 = findViewById(R.id.email);
        TextInputEditText password = findViewById(R.id.password);
        Button btn = findViewById(R.id.signup);
        progress = findViewById(R.id.progress);

        TextView signin = findViewById(R.id.text1);
        auth = FirebaseAuth.getInstance();

        progress.setVisibility(View.GONE);

        if (auth.getCurrentUser() != null) {
            // User is logged in, redirect to the user activity
            startActivity(new Intent(getApplicationContext(), user.class));
            finish(); // Close signup activity
        }

        signin.setOnClickListener(v -> {
            startActivity(new Intent(signup.this, financierlogin.class));
            finish();
        });

        btn.setOnClickListener(view -> {
            String txt_email = Objects.requireNonNull(email1.getText()).toString();
            String txt_password = Objects.requireNonNull(password.getText()).toString();

            if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                Toast.makeText(signup.this, "Empty credentials", Toast.LENGTH_SHORT).show();
            } else if (txt_password.length() < 10) {
                Toast.makeText(signup.this, "Password must have at least 10 characters!", Toast.LENGTH_SHORT).show();
            } else if (txt_password.length() > 20) {
                Toast.makeText(signup.this, "Password is too long!", Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(txt_email).matches()) {
                Toast.makeText(signup.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            } else {
                registerUser(txt_email, txt_password);
            }
        });
    }


    private void registerUser(String email, String password) {
        progress.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(signup.this, task -> {
                    progress.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        Toast.makeText(signup.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signup.this, user.class));
                        finish();
                    }
                })
                .addOnFailureListener(e -> {
                    progress.setVisibility(View.GONE);
                    Toast.makeText(signup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
