package dev.brian.com.bamby.ui;

import android.content.Context;
import android.content.Intent;

import dev.brian.com.bamby.Home;
import dev.brian.com.bamby.LoginActivity;
import dev.brian.com.bamby.ui.Register.RegisterActivity;

public final class Navigation {

    public Navigation(){

    }
    public void toHome(Context context){
        Intent homeIntent = new Intent(context, Home.class);
        context.startActivity(homeIntent);
    }
    public void toRegistration(Context context){
        Intent registerIntent = new Intent(context, RegisterActivity.class);
        context.startActivity(registerIntent);
    }
    public void toLogin(Context context){
        Intent loginIntent = new Intent(context, LoginActivity.class);
        context.startActivity(loginIntent);
    }
}
