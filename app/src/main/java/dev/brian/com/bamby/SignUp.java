package dev.brian.com.bamby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SignUp extends AppCompatActivity {

    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login = (Button)findViewById(R.id.btn_loginsign);

        login.setOnClickListener(new android.view.View.OnClickListener(){
             @Override
            public void onClick(android.view.View v) {
                android.content.Intent homeIntent = new android.content.Intent(SignUp.this,MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }
}
