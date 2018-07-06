package dev.brian.com.bamby.ui.Login;

import android.text.TextUtils;
import dev.brian.com.bamby.Model.User;
import io.realm.Realm;
import io.realm.RealmQuery;

public class LoginPresenterImpl implements LoginPresenter {
    Realm realm;
    LoginView mLoginView;

    public LoginPresenterImpl(LoginView loginView){
        this.mLoginView = loginView;

    }
    @Override
    public void onLoginConfirm(String username, String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mLoginView.onLoginValidate();
        }else{
            if(username.equals("jamaa") && password.equals("jamaa")){
                mLoginView.onLoginSuccess();
            }else {
                mLoginView.onLoginFailed();
            }
        }
    }
    @Override
    public void onCheckUserExists(String username,String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mLoginView.onLoginValidate();
            return;
        }
        realm = Realm.getDefaultInstance();
        RealmQuery<User> realmQuery = realm.where(User.class);
        realmQuery.equalTo("username",username).equalTo("password",password).findAll();
        if(realmQuery.count()>0){
            mLoginView.onLoginSuccess();
            mLoginView.onNavigateToHome();
        }else{
            mLoginView.onLoginFailed();
        }
    }
}
