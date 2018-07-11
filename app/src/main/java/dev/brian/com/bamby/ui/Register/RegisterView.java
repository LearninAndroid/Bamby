package dev.brian.com.bamby.ui.Register;

public interface RegisterView {
    void onRegisterValidate();
    void onRegisterSuccess();
    void onRegisterFailure();
    void onNavigateToHome();
    void onNavigateToLogin();
    void onMatchValidate();
    void onTermsValidate();
    void onUserExists();
    void onEmailPatternError();


}
