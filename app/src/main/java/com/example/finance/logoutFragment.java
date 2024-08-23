package com.example.finance;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class logoutFragment extends Fragment {
    user u;


    CardView card1,card2;
    FirebaseAuth auth;
    FirebaseUser user;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_logout, container, false);
        card1=view.findViewById(R.id.logout);
        card2=view.findViewById(R.id.delete);
        auth=FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        u=(user)getActivity();

        card1.setOnClickListener(v -> {
            auth.signOut();
            Intent intent=new Intent(getActivity(), financierlogin.class);

            startActivity(intent);
            u.finish();


        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.delete();
                Intent intent=new Intent(getActivity(),signup.class);
                startActivity(intent);
                u.finish();
            }
        });


        return view;
    }
}