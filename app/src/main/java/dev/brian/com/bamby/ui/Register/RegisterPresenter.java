package dev.brian.com.bamby.ui.Register;

public interface RegisterPresenter {
    void onRegisterNewUser(String username,String password,String email);
    void onPasswordMatchConfirm(String password,String confirm_password);

}
