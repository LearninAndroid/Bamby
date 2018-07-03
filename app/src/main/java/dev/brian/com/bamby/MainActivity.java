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
import dev.brian.com.bamby.Login.LoginPresenter;
import dev.brian.com.bamby.Login.LoginPresenterImpl;
import dev.brian.com.bamby.Login.LoginView;
import dev.brian.com.bamby.Model.Utils;
import dev.brian.com.bamby.Realm.Shared;

public class MainActivity extends AppCompatActivity implements LoginView{

    @BindView(R.id.login_username)
    EditText username;
    @BindView(R.id.login_password)
    EditText password;
    
    Utils  utils = new Utils();
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenterImpl(MainActivity.this);
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
       mLoginPresenter.onCheckUserExists(username.getText().toString(),password.getText().toString());
       /* if(username.getText().toString().isEmpty()||
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
        }*/

    }

    @Override
    public void onLoginValidate() {
        Toast.makeText(getApplicationContext(), "Please Enter All Required Fields", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(getApplicationContext(), "Login Failed Try Again", Toast.LENGTH_SHORT).show();
    }
}
