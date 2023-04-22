package com.example.getloginpassapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity implements View.OnClickListener,GetDataAsyncTask.AsyncResponse{
    private EditText etLogin;
    private EditText etPassword;
    private Button buttonSumbit;
    private String login,password,url_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin=findViewById(R.id.eTLogin);
        etPassword=findViewById(R.id.eTPassword);
        buttonSumbit=findViewById(R.id.buttonSubmit);
        buttonSumbit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        login=etLogin.getText().toString();
        password=etPassword.getText().toString();
        url_link="https://http://kristi1l.beget.tech/kristi.php";
        new GetDataAsyncTask(this).execute(login,password,url_link);

    }

    @Override
    public void proccessFinish(String result){

        if (!result.equals("user not found")){
            Intent intent=new Intent();
            intent.putExtra(MainActivity.FULLUSERNAME,result);
            setResult(RESULT_OK,intent);
            finish();
        }else {
            Intent intent=new Intent();
            setResult(RESULT_CANCELED,intent);
            finish();
        }

    }

}
