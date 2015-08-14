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


public class Teacher extends Activity{

    Button add,remove,feedback;
    EditText userName,userPassword;
    String name,password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher);
        userName = (EditText) findViewById(R.id.teacherName);
        userPassword = (EditText) findViewById(R.id.teacherPassword);
        add = (Button) findViewById(R.id.addStud);
        remove = (Button) findViewById(R.id.removeStud);
        feedback = (Button) findViewById(R.id.feedback);

        final Context context = this;
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getBaseContext(), "Please wait...", Toast.LENGTH_LONG).show();
                name = userName.getText().toString();
                password = userPassword.getText().toString();
                ParseQuery<ParseObject> loginQuery = ParseQuery.getQuery("StudentDatabase");
                loginQuery.whereEqualTo("Name", name);
                loginQuery.whereEqualTo("Type","teacher");
                loginQuery.whereEqualTo("password",password);
                loginQuery.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> teacherList, ParseException e) {
                        if (e == null) {
                            if(teacherList.size()==1) {
                                Log.d("score", "Retrieved " + teacherList.size() + " teacher");
                                Toast.makeText(getBaseContext(), "Login successful.\nWelcome  " + name, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(context, AddStudent.class);
                                startActivity(intent);
                            }else{Toast.makeText(getBaseContext(), "Invalid User.", Toast.LENGTH_LONG).show();}
                        } else {
                            Log.d("score", "Error: " + e.getMessage());
                            Toast.makeText(getBaseContext(), "Login failed.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                userName.setText("");
                userPassword.setText("");
            }

        });
        final Context context1 = this;
        remove.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {


                Toast.makeText(getBaseContext(), "Please wait...", Toast.LENGTH_LONG).show();
                name = userName.getText().toString();
                password = userPassword.getText().toString();
                ParseQuery<ParseObject> loginQuery = ParseQuery.getQuery("StudentDatabase");
                loginQuery.whereEqualTo("Name", name);
                loginQuery.whereEqualTo("Type", "teacher");
                loginQuery.whereEqualTo("password", password);
                loginQuery.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> teacherList, ParseException e) {
                        if (e == null) {
                            if(teacherList.size()==1) {
                                Log.d("score", "Retrieved " + teacherList.size() + " teacher");
                                Toast.makeText(getBaseContext(), "Login successful.\nWelcome  " + name, Toast.LENGTH_LONG).show();
                                Intent intent1 = new Intent(context1, DeleteActivity.class);
                                startActivity(intent1);
                            }
                            else {Toast.makeText(getBaseContext(), "Invalid User.", Toast.LENGTH_LONG).show();}

                        } else {
                            Log.d("score", "Error: " + e.getMessage());
                            Toast.makeText(getBaseContext(), "Login failed.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                userName.setText("");
                userPassword.setText("");
            }
        });

        final Context context2 = this;
        feedback.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {


                Toast.makeText(getBaseContext(), "Please wait...", Toast.LENGTH_LONG).show();
                name = userName.getText().toString();
                password = userPassword.getText().toString();
                ParseQuery<ParseObject> loginQuery = ParseQuery.getQuery("StudentDatabase");
                loginQuery.whereEqualTo("Name", name);
                loginQuery.whereEqualTo("Type", "teacher");
                loginQuery.whereEqualTo("password", password);
                loginQuery.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> teacherList, ParseException e) {
                        if (e == null) {
                            if(teacherList.size() == 1) {
                                String sub = "";
                                Log.d("teacher", "Retrieved " + teacherList.size() + " teacher");
                                Toast.makeText(getBaseContext(), "Login successful.\nWelcome  " + name, Toast.LENGTH_LONG).show();
                                for (ParseObject teacher : teacherList) {
                                    sub = teacher.getString("Subject");
                                }
                                Intent intent2 = new Intent(context2, Feedback.class);
                                intent2.putExtra("name", name);
                                intent2.putExtra("sub", sub);
                                startActivity(intent2);
                            }
                            else {Toast.makeText(getBaseContext(), "Invalid User.", Toast.LENGTH_LONG).show();}

                        } else {
                            Log.d("score", "Error: " + e.getMessage());
                            Toast.makeText(getBaseContext(), "Login failed.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }

}

