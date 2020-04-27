package com.example.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements login.OnLoginFormActivityListener {

    public  static PrefConfig prefConfig;
    public  static ApiInterface apiInterface;

//     private Button mLogin;
//     private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        prefConfig = new PrefConfig(this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.frame_container)!=null){

            if(savedInstanceState!=null){
                return;
            }
            if(prefConfig.readLoginStatus()){
               getSupportFragmentManager().beginTransaction().add(R.id.frame_container, new welcome()).commit();
            }
            else{
                getSupportFragmentManager().beginTransaction().add(R.id.frame_container, new login()).commit();
            }

        }
    }


    @Override
    public void performRegister() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                new register()).addToBackStack(null).commit();

    }

    @Override
    public void performLogin(String email) {

    }
}
