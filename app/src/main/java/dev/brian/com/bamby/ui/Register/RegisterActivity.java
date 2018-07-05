package dev.brian.com.bamby.ui.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.brian.com.bamby.Home;
import dev.brian.com.bamby.LoginActivity;
import dev.brian.com.bamby.Model.User;
import dev.brian.com.bamby.R;
import dev.brian.com.bamby.Realm.Shared;
import io.realm.Realm;
import io.realm.RealmQuery;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    @BindView(R.id.signup_username)
    EditText username;
    @BindView(R.id.signup_password)
    EditText password;
    @BindView(R.id.signup_confirm_password)
    EditText confirm_password;
    @BindView(R.id.signup_email)
    EditText email;
    @BindView(R.id.terms_check)
    AppCompatCheckBox compatCheckBox;


    RegisterPresenter mRegisterPresenter;

    @OnClick(R.id.btn_signup)
    public void onSignUpClicked(){
        mRegisterPresenter.onRegisterNewUser(username.getText().toString(),password.getText().toString(),confirm_password.getText().toString(),
                email.getText().toString(),compatCheckBox);

    }
    @OnClick(R.id.btn_loginsign)
    public void onLoginClicked(){
        mRegisterPresenter.onLognClicked();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        mRegisterPresenter = new RegisterPresenterImpl(RegisterActivity.this);

    }

    @Override
    public void onRegisterValidate() {
        Toast.makeText(getApplicationContext(), "Please Fill In All Required Fields", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSuccess() {
        Toast.makeText(getApplicationContext(), "New User Added Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterFailure() {
        Toast.makeText(getApplicationContext(), "Failed To Add User, Please Try Again Later", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNavigateToHome() {
        Intent homeIntent = new Intent(RegisterActivity.this,Home.class);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public void onNavigateToLogin() {
        Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    @Override
    public void onMatchValidate() {
        Toast.makeText(getApplicationContext(), "Make Sure That Passwords Match", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTermsValidate() {
        Toast.makeText(getApplicationContext(), "Please Accept Our Terms of Agreement ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserExists() {
        Toast.makeText(getApplicationContext(), "Username Already Taken, Try Changing Username", Toast.LENGTH_SHORT).show();
    }

}
