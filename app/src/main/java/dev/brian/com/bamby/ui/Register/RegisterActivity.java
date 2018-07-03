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
import dev.brian.com.bamby.Home;
import dev.brian.com.bamby.LoginActivity;
import dev.brian.com.bamby.Model.User;
import dev.brian.com.bamby.R;
import dev.brian.com.bamby.Realm.Shared;
import io.realm.Realm;
import io.realm.RealmQuery;

public class RegisterActivity extends AppCompatActivity {



    Button login,sign_up;
    EditText username,password,confirm_password,email;
    AppCompatCheckBox compatCheckBox;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login = (Button)findViewById(R.id.btn_loginsign);
        username = (EditText)findViewById(R.id.signup_username);
        password = (EditText)findViewById(R.id.signup_password);
        confirm_password = (EditText)findViewById(R.id.signup_confirm_password);
        email = (EditText) findViewById(R.id.signup_email);
        sign_up = (Button)findViewById(R.id.btn_signup);
        compatCheckBox = (AppCompatCheckBox) findViewById(R.id.terms_check);
        realm = Realm.getDefaultInstance();
        login.setOnClickListener(new android.view.View.OnClickListener(){
             @Override
            public void onClick(android.view.View v) {
                android.content.Intent homeIntent = new android.content.Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty() ||
                        password.getText().toString().isEmpty() ||
                        confirm_password.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please Enter All Required Fields", Toast.LENGTH_SHORT).show();
                    return;
                }if(!password.getText().toString().equals(confirm_password.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Make Sure Passwords Match", Toast.LENGTH_SHORT).show();
                    return;
                }if(!compatCheckBox.isChecked()){
                    Toast.makeText(RegisterActivity.this, "Please Agree To the Terms of Agreement", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(checkIfUserExists(username.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Username Already Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    AddUser(username.getText().toString(),password.getText().toString(),email.getText().toString());
                    Toast.makeText(RegisterActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                    Intent homeActivity = new Intent(RegisterActivity.this,Home.class);
                    startActivity(homeActivity);
                    finish();
                    Shared shared = new Shared(getApplicationContext());
                    shared.secondTime();

                }
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        realm.close();
    }
    private void AddUser(final String usern, final String pass,final String mail){
        realm.executeTransactionAsync(new Realm.Transaction() {

            @Override
            public void execute(Realm bgRealm) {
                User user = bgRealm.createObject(User.class);
                user.setUsername(usern);
                user.setEmail(mail);
                user.setPassword(pass);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("Database","Transaction Completed Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("Realm Error:",error.getMessage());
            }

        });

    }
    public boolean checkIfUserExists(final String username){
        boolean success = true;
        RealmQuery<User> realmQuery = realm.where(User.class);
        realmQuery.equalTo("username",username);
        if(realmQuery.count()>0){
            success = true;
        }else{
            success = false;
        }
        return success;

    }


}
