package com.amulya.murthy.reflections12;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class Student extends Activity {

    Button login;
    EditText userName,userPassword,userUsn;
    String name,password,usn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
        final Context context = this;

        userName = (EditText) findViewById(R.id.name_unique);
        userPassword = (EditText) findViewById(R.id.password_unique);
        userUsn = (EditText) findViewById(R.id.usn_unique);
        login = (Button) findViewById(R.id.submit);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Please wait...", Toast.LENGTH_LONG).show();
                name = userName.getText().toString();
                usn = userUsn.getText().toString();
                password = userPassword.getText().toString();
                ParseQuery<ParseObject> query = ParseQuery.getQuery("StudentDatabase");
                query.whereEqualTo("Name", name);
                query.whereEqualTo("Type", "student");
                query.whereEqualTo("password", password);
                query.whereEqualTo("usn", usn);
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> studentList, ParseException e) {
                        if (e == null) {
                            if(studentList.size()==1) {
                                Log.d("student", "Retrieved " + studentList.size() + " student");
                                Toast.makeText(getBaseContext(), "Login successful.\nWelcome  " + name, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(context, Subjects.class);
                                intent.putExtra("usn", usn);
                                startActivity(intent);
                            }
                            else{Toast.makeText(getBaseContext(), "Invalid user.", Toast.LENGTH_LONG).show();}

                        } else {
                            Log.d("student", "Error: " + e.getMessage());
                            Toast.makeText(getBaseContext(), "Login failed.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

        });

    }
}


