package com.example.firstmvvmdemo.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.firstmvvmdemo.model.User;

public class LoginViewModel extends BaseObservable {

    private User user;
    Context context;
    Activity mActivity;

    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";
    private String displayMessage="Welcome Home!";

    @Bindable
    private String toastMessage = null;

    @Bindable
    private String userEmail = null;


    public String getToastMessage() {
        return toastMessage;
    }

    private final Activity getActivity() {
        return this.mActivity;
    }


    private void setToastMessage(String toastMessage,String userEmail) {

        this.toastMessage = toastMessage;
        this.userEmail=userEmail;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel() {
        user = new User("","");
    }

    public void onLoginClicked() {
        if (isInputDataValid())
        {
            setToastMessage(successMessage,userEmail);
        }
        else
            setToastMessage(errorMessage,userEmail);
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}
