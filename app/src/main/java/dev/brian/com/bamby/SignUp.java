package dev.brian.com.bamby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev.brian.com.bamby.Model.User;
import io.realm.Realm;
import io.realm.RealmAsyncTask;

public class SignUp extends AppCompatActivity {

    Button login,sign_up;
    EditText username,password,confirm_password,email;
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
        realm = Realm.getDefaultInstance();
        login.setOnClickListener(new android.view.View.OnClickListener(){
             @Override
            public void onClick(android.view.View v) {
                android.content.Intent homeIntent = new android.content.Intent(SignUp.this,MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AddUser(username.getText().toString(),password.getText().toString(),email.getText().toString());
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

}
