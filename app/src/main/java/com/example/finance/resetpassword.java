package com.example.finance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class resetpassword extends AppCompatActivity {
    private TextView text;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        text=findViewById(R.id.text5);
        String auth=FirebaseAuth.getInstance().getCurrentUser().getEmail();
        text.setText("Please check your gmail.The reset password link will be sent to "+auth);


        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent = new Intent(resetpassword.this, financierlogin.class);
                    startActivity(intent);
                    finish();

            }
        });

    }
}