package com.vinayak.blooddonner.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vinayak.blooddonner.Module.Donner_Module;
import com.vinayak.blooddonner.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DonnerAdapter extends RecyclerView.Adapter<DonnerAdapter.ViewHolder> {

    List<Donner_Module> userList;
    Context context;

    public DonnerAdapter(Context context, List<Donner_Module> userList) {
        this.context = context;
        this.userList=userList;
    }

    @NonNull
    @Override
    public DonnerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.donner_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonnerAdapter.ViewHolder holder, int position) {

        holder.name.setText(userList.get(position).getName());
        holder.email.setText(userList.get(position).getEmail());
        holder.mobile.setText(userList.get(position).getMobile());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,email,mobile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.D_name);
            email=itemView.findViewById(R.id.D_email);
            mobile=itemView.findViewById(R.id.D_mobile);
        }
    }
}

