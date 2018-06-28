package dev.brian.com.bamby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.brian.com.bamby.Model.Utils;
import dev.brian.com.bamby.Realm.Shared;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login_username)
    EditText username;
    @BindView(R.id.login_password)
    EditText password;
    Utils  utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Shared shared = new Shared(getApplicationContext());
        shared.firstTime();
    }

    @OnClick(R.id.signup)
    public void onSignUpClicked(){
        Intent signUp = new Intent(MainActivity.this, SignUp.class);
        startActivity(signUp);
        finish();
    }
    @OnClick(R.id.btnLogin)
    public void onLoginClicked(){
        if(username.getText().toString().isEmpty()||
                password.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter All Required Fields", Toast.LENGTH_SHORT).show();
        }else{
            if(utils.checkIfUserExists(username.getText().toString())){
                Intent homeIntent = new Intent(MainActivity.this,Home.class);
                startActivity(homeIntent);
                finish();
            }else{
                Toast.makeText(this, "Username or Password Incorrect", Toast.LENGTH_SHORT).show();

            }
        }

    }
}
