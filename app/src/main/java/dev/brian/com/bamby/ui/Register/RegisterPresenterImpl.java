package dev.brian.com.bamby.ui.Register;

import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.util.Log;

import dev.brian.com.bamby.Model.User;
import io.realm.Realm;
import io.realm.RealmQuery;

public class RegisterPresenterImpl implements RegisterPresenter {

    RegisterView mRegisterView;
    Realm realm;

    public RegisterPresenterImpl(RegisterView registerView){
        realm = Realm.getDefaultInstance();
        this.mRegisterView = registerView;
    }


    @Override
    public void onRegisterNewUser(final String username, final String password,String c_password,final String email,AppCompatCheckBox appCompatCheckBox) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(c_password)
                ||TextUtils.isEmpty(email)){
            mRegisterView.onRegisterValidate();
            return;
        }
        if(!password.equals(c_password)){
            mRegisterView.onMatchValidate();
            return;
        }
       if(!appCompatCheckBox.isChecked()){
            mRegisterView.onTermsValidate();
            return;
        } if(checkIfUserExists(username)){
            mRegisterView.onUserExists();
        }
        else{
            realm.executeTransactionAsync(new Realm.Transaction() {

                @Override
                public void execute(Realm bgRealm) {
                    User user = bgRealm.createObject(User.class);
                    user.setUsername(username);
                    user.setEmail(email);
                    user.setPassword(password);
                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    Log.v("Database","Transaction Completed Successfully");
                    mRegisterView.onRegisterSuccess();
                    mRegisterView.onNavigateToHome();
                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable error) {
                    Log.e("Realm Error:",error.getMessage());
                    mRegisterView.onRegisterFailure();
                }

            });
        }
    }

    @Override
    public void onLognClicked() {
        mRegisterView.onNavigateToLogin();
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
    private void AddUser(final String usern, final String pass,final String mail){


    }
}
