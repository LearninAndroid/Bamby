package dev.brian.com.bamby.ui.Register;

public interface RegisterView {
    void onRegisterValidate();
    void onRegisterSuccess();
    void onRegisterFailure();
    void onNavigateToLogin();
    void onMatchValidate();

}
