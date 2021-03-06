package com.example.database.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database.R;
import com.example.database.model.contact;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactHolder> {

    // List to store all the contact details
      ArrayList<contact> contactsList;
    private Context mContext;

    // Counstructor for the Class
    public MyAdapter(ArrayList<contact> contactsList, Context context) {
        this.contactsList = contactsList;
        this.mContext = context;
    }

    // This method creates views for the RecyclerView by inflating the layout
    // Into the viewHolders which helps to display the items in the RecyclerView
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.mycustomadapter, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public int getItemCount() {
        return contactsList == null? 0: contactsList.size();
    }



    // This method is called when binding the data to the views being created in RecyclerView
    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, final int position) {
        final contact contact = contactsList.get(position);
        
        // Set the data to the views here
        holder.setContactName(contact.getName());
        //holder.setContactId(contact.getId());
        holder.setContactNumber(contact.getPhonenumber());
        holder.setContactAddress(contact.getAddress());

       // You can set click listners to indvidual items in the viewholder here
       // make sure you pass down the listner or make the Data members of the viewHolder public
    
    }

    // This is your ViewHolder class that helps to populate data to the view
    public class ContactHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtNumber;
        private TextView txtid;
        private TextView txtaddress;

        public ContactHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtNumber = itemView.findViewById(R.id.txt_number);
            txtid = itemView.findViewById(R.id.txt_id);
            txtaddress = itemView.findViewById(R.id.txt_address);
        }
 
        public void setContactName(String name) {
            txtName.setText(name);
        }

        public void setContactNumber(String number) {
            txtNumber.setText(number);
        }
        public void setContactId(int id) { txtid.setText(id); }

        public void setContactAddress(String address){txtaddress.setText(address);}

        }
    }
