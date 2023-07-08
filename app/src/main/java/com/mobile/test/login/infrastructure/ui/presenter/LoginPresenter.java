package com.mobile.test.login.infrastructure.ui.presenter;

import com.mobile.test.login.application.Authenticator;
import com.mobile.test.login.domain.callback.AuthCallback;
import com.mobile.test.login.domain.contract.LoginContract;
import com.mobile.test.user.domain.model.User;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;
    private Authenticator authenticator;

    public LoginPresenter(LoginContract.View view, Authenticator authenticator) {
        this.view = view;
        this.authenticator = authenticator;
    }

    @Override
    public void onLoginButtonClicked(String email, String password) {
        view.showLoading();
        authenticator.authenticate(email, password, new AuthCallback() {
            @Override
            public void onLoginSuccess(User user) {
                view.hideLoading();
                view.showLoginSuccess();
            }

            @Override
            public void onLoginFailure() {
                view.hideLoading();
                view.showLoginFailure();
            }
        });
    }
}
