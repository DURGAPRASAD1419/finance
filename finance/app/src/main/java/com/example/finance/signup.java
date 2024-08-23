package com.example.finance;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.Objects;

public class signup extends AppCompatActivity {
    ProgressBar progress;
    private FirebaseAuth auth;
    TextInputEditText user,phone1,email1,password;
    Button btn;
    TextView signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        user= findViewById(R.id.user);
        phone1=findViewById(R.id.phone);
        email1 =findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn=findViewById(R.id.signup);
        progress=findViewById(R.id.progress);

        signin =findViewById(R.id.text1);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signup.this,login.class);
                startActivity(intent);
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username,email,password1,phone;
                username=String.valueOf(user.getText());
                email=String.valueOf(email1.getText());
                password1=String.valueOf(password.getText());
                phone=String.valueOf(phone1.getText());
                if(username.equals("") && email.equals("") && password1.equals("") && phone.equals("")) {
                    Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_SHORT).show();
                    progress.setVisibility(View.VISIBLE);

                }
                else{
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "user";
                            field[1] = "email";
                            field[2] = "password";
                            field[3] = "phone";

                            String[] data = new String[4];
                            data[0] = "username";
                            data[1] = "email";
                            data[2] = "password1";
                            data[3] = "phone";
                            PutData putData = new PutData("http://192.168.55.107/loginRegister/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progress.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("signup success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                        Intent intent=new Intent(getApplicationContext(),login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }


                                }
                            }

                        }
                    });

                }

            }
        });


    }

}