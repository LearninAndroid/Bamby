package dev.brian.com.bamby.ui.Login;

public interface LoginView {
    void onLoginValidate();
    void onLoginSuccess();
    void onLoginFailed();
    void onNavigateToHome();
}
