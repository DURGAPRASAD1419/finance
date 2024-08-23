package com.example.finance;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class customerhomefragment extends Fragment {
    Button btn;
    customer c;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_customerhomefragment, container, false);
        btn=view.findViewById(R.id.show);
        c=(customer)getActivity();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),showdetails.class);
                startActivity(intent);
            }
        });
        return view;
    }
}