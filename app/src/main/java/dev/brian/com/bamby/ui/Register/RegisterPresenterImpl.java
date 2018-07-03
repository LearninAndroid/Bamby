package dev.brian.com.bamby.ui.Register;

import android.text.TextUtils;

public class RegisterPresenterImpl implements RegisterPresenter {
    RegisterView mRegisterView;
    @Override
    public void onRegisterNewUser(String username, String password, String email) {

    }

    @Override
    public void onPasswordMatchConfirm(String password, String confirm_password) {
        if(!password.equals(confirm_password)){
            mRegisterView.onMatchValidate();
        }
    }
}
