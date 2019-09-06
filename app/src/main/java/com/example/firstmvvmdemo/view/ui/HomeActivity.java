package com.example.firstmvvmdemo.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.firstmvvmdemo.R;
import com.example.firstmvvmdemo.databinding.ActivityHomeBinding;
import com.example.firstmvvmdemo.databinding.ActivityMainBinding;
import com.example.firstmvvmdemo.model.User;
import com.example.firstmvvmdemo.view.adapter.UserDataAdapter;
import com.example.firstmvvmdemo.viewmodel.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    List<User> userList=new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        ActivityHomeBinding activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        activityHomeBinding.setViewModel(new LoginViewModel());
        activityHomeBinding.executePendingBindings();

        String uname=getIntent().getStringExtra("uname");
        Log.e("HomeActivity","uname: "+uname);
        activityHomeBinding.txtWelcome.setText(uname);


        userList.add(new User("asdasdf","adsfasdf@gmail.com","58465465"));
        userList.add(new User("asdasdfvf","advfsfd@gmail.com","58365366"));
        userList.add(new User("asdasddfvf","adsfvsddf@gmail.com","58425435"));
        userList.add(new User("asdasddfff","adsfvsddfa@gmail.com","58412435"));

        UserDataAdapter userDataAdapter=new UserDataAdapter(getApplicationContext(),userList);
        activityHomeBinding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        activityHomeBinding.recyclerview.setAdapter(userDataAdapter);

    }

}
