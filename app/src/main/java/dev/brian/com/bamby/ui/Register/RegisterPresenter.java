package dev.brian.com.bamby.ui.Register;

import android.support.v7.widget.AppCompatCheckBox;

public interface RegisterPresenter {
    void onRegisterNewUser(String username,String password,String confirm,String email,AppCompatCheckBox appCompatCheckBox);
    void onLognClicked();

}
