package com.example.login;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class login extends Fragment {

    private TextView mText_reg;
    OnLoginFormActivityListener loginFormActivityListener;

    public login(){
        //default stuff
    }

    public interface OnLoginFormActivityListener{

        public void performRegister();
        public void performLogin(String email);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.activity_login, container, false);

        mText_reg  = view.findViewById(R.id.text_reg);



        mText_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               loginFormActivityListener.performRegister();




            }
        });
        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        loginFormActivityListener = (OnLoginFormActivityListener) activity;
    }
}
