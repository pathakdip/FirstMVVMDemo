package com.example.firstmvvmdemo.view.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstmvvmdemo.R;
import com.example.firstmvvmdemo.databinding.RecyclerviewRowItemBinding;
import com.example.firstmvvmdemo.model.User;

import java.util.List;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.MyViewHolder> {

    Context context;
    List<User> userList;
    User viewModel;

    public UserDataAdapter (Context context,List<User> userList) {
        this.context=context;
        this.userList = userList;
    }



    @Override
    public UserDataAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerviewRowItemBinding recyclerviewRowItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.recyclerview_row_item, parent, false);
        return new MyViewHolder(recyclerviewRowItemBinding);
    }

    @Override
    public void onBindViewHolder( final UserDataAdapter.MyViewHolder holder, int position) {

        final User userdata=userList.get(position);
        holder.rowItemBinding.setUserData(userdata);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("User Details");
                alertDialog.setMessage("");
                alertDialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.show();*/

                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.popup_details);
                dialog.setTitle(userdata.getName());

                TextView txtname,txtemail,txtcontact;
                txtname=dialog.findViewById(R.id.txtDialogTitle);
                txtemail=dialog.findViewById(R.id.txtDialogEmail);
                txtcontact=dialog.findViewById(R.id.txtDialogContact);

                txtname.setText(userdata.getName());
                txtemail.setText(userdata.getEmail());
                txtcontact.setText(userdata.getContact());

                dialog.show();

                Button btnDismiss=dialog.findViewById(R.id.btnDismiss);
                btnDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerviewRowItemBinding rowItemBinding;

        MyViewHolder(RecyclerviewRowItemBinding itemView) {
            super(itemView.getRoot());
            this.rowItemBinding = itemView;
        }
    }
}
