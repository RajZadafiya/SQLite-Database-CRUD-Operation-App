package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.database.adapter.MyAdapter;
import com.example.database.data.mydbhandler;
import com.example.database.model.contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydbhandler db = new mydbhandler(MainActivity.this);

        // adding contacts to the db

        contact raj = new contact();
        raj.setPhonenumber("343443434343");
        raj.setName("R");
        raj.setAddress("B-2514.");

        db.addcontact(raj);

        /*raj.setId(1);
        raj.setName("RJ");
        raj.setPhonenumber(0000000000);

        int affectedrows = db.updatecontacts(raj);

        Log.d("dbraj","number of affected rows are" + affectedrows); */

        // delete contacts

        /*db.deletecontact(1);
        db.deletecontact(2);
        db.deletecontact(3);*/

        ArrayList<String> contacts = new ArrayList<>();
        //listview = findViewById(R.id.listview);

        // get all contacts

        List<contact> allcontacts = db.getAllcontacts();
        for (contact contact : allcontacts){
            Log.d("dbraj","Id : " + contact.getId() + "\n" +
                    " Name  : " + contact.getName() + "\n" + "Phone Number :" + contact.getPhonenumber());
            contacts.add(contact.getId() + contact.getName() + "(" + contact.getPhonenumber() + contact.getAddress() + ")");

        }


        //Log.d("dbraj","You Have " + db.getcount() + "records in your database");
        recycler = findViewById(R.id.listview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        MyAdapter listAdapter = new MyAdapter((ArrayList<contact>) allcontacts, this);
        recycler.setAdapter(listAdapter);
       // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts);
        //recycler.setAdapter(arrayAdapter);


    }
}