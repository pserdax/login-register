package com.example.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends Fragment {

    private EditText mEmail;
    private EditText mPass;
    private EditText mConfPass;
    private Button mReg_button;





    public register(){

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.activity_register, container, false);

        mEmail = view.findViewById(R.id.reg_user);
        mPass = view.findViewById(R.id.reg_pass);
        mConfPass = view.findViewById(R.id.confPass);
        mReg_button = view.findViewById(R.id.register_btn);

        mReg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               performRegistration();

            }
        });
        return view;
    }

    public  void performRegistration(){

        String email = mEmail.getText().toString();
        String password = mPass.getText().toString();
        String confirmPassword = mConfPass.getText().toString();

        Call<User> call = MainActivity.apiInterface.performRegistration(email, password, confirmPassword);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body().getResponse().equals("ok")){

                    MainActivity.prefConfig.displayToast("Registration success!");
                }
                else if(response.body().getResponse().equals("exist")){

                    MainActivity.prefConfig.displayToast("The username already exists!");
                }
                else if(response.body().getResponse().equals("password doesn't match!")){

                    MainActivity.prefConfig.displayToast("The password doesn't match!");
                }
                else if(response.body().getResponse().equals("error")){
                    MainActivity.prefConfig.displayToast("Unknown error!");
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        mEmail.setText("");
        mPass.setText("");
        mConfPass.setText("");

    }
}
