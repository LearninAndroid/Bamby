package dev.brian.com.bamby.Realm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import dev.brian.com.bamby.MainActivity;

public class Shared {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int mode = 0;
    String fileName = "sdFile";
    String data  = "b";

    public Shared(Context context){
        this.context = context;
        sharedPreferences= context.getSharedPreferences(fileName,mode);
        editor = sharedPreferences.edit();

    }
    public void secondTime(){
        editor.putBoolean(data,true);
        editor.commit();
    }
    public void firstTime(){
        if(!this.login()){
            Intent loginIntent = new Intent(context, MainActivity.class);
        }

    }
    private boolean login(){
        return sharedPreferences.getBoolean(data,false);
    }
}
