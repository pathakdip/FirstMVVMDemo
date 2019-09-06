package com.example.firstmvvmdemo.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firstmvvmdemo.R;
import com.example.firstmvvmdemo.databinding.ActivityMainBinding;
import com.example.firstmvvmdemo.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();

    }

    @BindingAdapter({"toastMessage","userEmail"})
    public static void runMe(View view, String message,String userEmail) {
        if (message != null)
        {
            Toast.makeText(view.getContext(), message+" "+userEmail, Toast.LENGTH_SHORT).show();
            goToHome(view.getContext(),userEmail);
        }
    }

    public static void goToHome(Context context,String userEmail)
    {
        Intent intent=new Intent(context,HomeActivity.class);
        intent.putExtra("uname",userEmail);
        context.startActivity(intent);
    }

}
