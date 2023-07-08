package com.mobile.test.login.infrastructure.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.mobile.test.R;
import com.mobile.test.helpers.ApiClientHelper;
import com.mobile.test.login.application.Authenticator;
import com.mobile.test.login.domain.contract.LoginContract;
import com.mobile.test.login.domain.service.AuthService;
import com.mobile.test.login.infrastructure.api.RestAuthRepository;
import com.mobile.test.login.infrastructure.ui.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private CircularProgressIndicator loginProgressIndicator;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        loginProgressIndicator = findViewById(R.id.loginProgressIndicator);

        //Init
        init();

        loginButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            presenter.onLoginButtonClicked(email, password);
        });
    }

    private void init() {
        ApiClientHelper<AuthService> authApi = new ApiClientHelper<>(AuthService.class);
        RestAuthRepository repository = new RestAuthRepository(authApi.createService());
        Authenticator authenticator = new Authenticator(repository);
        presenter = new LoginPresenter(this, authenticator);
    }

    @Override
    public void showLoading() {
        loginProgressIndicator.show();
    }

    @Override
    public void hideLoading() {
        loginProgressIndicator.hide();
    }

    @Override
    public void showLoginSuccess() {

    }

    @Override
    public void showLoginFailure() {
        Toast.makeText(this, "Email or Password incorrect!", Toast.LENGTH_SHORT);
    }
}