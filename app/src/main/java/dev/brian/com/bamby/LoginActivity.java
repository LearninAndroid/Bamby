package dev.brian.com.bamby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.brian.com.bamby.ui.Login.LoginPresenter;
import dev.brian.com.bamby.ui.Login.LoginPresenterImpl;
import dev.brian.com.bamby.ui.Login.LoginView;
import dev.brian.com.bamby.Realm.Shared;
import dev.brian.com.bamby.ui.Register.RegisterActivity;
import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @BindView(R.id.login_username)
    EditText username;
    @BindView(R.id.login_password)
    EditText password;
    LoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenterImpl(LoginActivity.this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Shared shared = new Shared(getApplicationContext());
        shared.firstTime();
    }
    @OnClick(R.id.signup)
    public void onSignUpClicked(){
        Intent signUp = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(signUp);
        finish();
    }
    @OnClick(R.id.btnLogin)
    public void onLoginClicked(){
       mLoginPresenter.onCheckUserExists(username.getText().toString(),password.getText().toString());
    }

    @Override
    public void onLoginValidate() {
        Toasty.error(getApplicationContext(), "Please Enter All Required Fields", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLoginSuccess() {
        Toasty.success(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLoginFailed() {
        Toast.makeText(getApplicationContext(), "Login Failed Try Again", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNavigateToHome() {
        Intent homeActivity = new Intent(LoginActivity.this,Home.class);
        startActivity(homeActivity);
        finish();
    }

    @Override
    public String onTestGetUsername() {
        return username.getText().toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
