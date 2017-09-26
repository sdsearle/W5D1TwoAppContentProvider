package com.example.accessdatabase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 9/13/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    ArrayList<Contact> contacts = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(ArrayList<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Contact contact = contacts.get(position);

        String name = "NAME: " + contact.getFirstName() + " " + contact.getLastName();
        holder.tvName.setText(name);

        holder.tvEmail.setText("EMAIL: " + contact.getEmail());

        String other = "Other:\n    Favorite Color: " + contact.getFavoriteColor() + "\n"
                + "    Blood Type: " + contact.getBloodType();
        holder.tvOther.setText(other);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvName;
        private final TextView tvEmail;
        private final TextView tvOther;

        public ViewHolder(final View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvOther = itemView.findViewById(R.id.tvOther);


        }
    }


}
