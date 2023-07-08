package com.mobile.test.login.domain.contract;

public interface LoginContract {
    interface View {
        void showLoading();
        void hideLoading();
        void showLoginSuccess();
        void showLoginFailure();
    }

    interface Presenter {
        void onLoginButtonClicked(String email, String password);
    }
}
