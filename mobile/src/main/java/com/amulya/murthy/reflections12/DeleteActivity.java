package com.amulya.murthy.reflections12;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class DeleteActivity extends Activity {

    Button delete;
    EditText userName, userPassword,userUsn;
    String username, userpass,userusn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_activity);
        userName = (EditText) findViewById(R.id.stud_name);
        userPassword = (EditText) findViewById(R.id.stud_pass);
        userUsn = (EditText) findViewById(R.id.stud_usn);
        delete = (Button) findViewById(R.id.del_stud);
        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getBaseContext(), "Please wait...", Toast.LENGTH_LONG).show();
                username = userName.getText().toString();
                userusn = userUsn.getText().toString();
                userpass = userPassword.getText().toString();
                ParseQuery<ParseObject> query = ParseQuery.getQuery("StudentDatabase");
                query.whereEqualTo("Name", username);
                query.whereEqualTo("Type", "student");
                query.whereEqualTo("password", userpass);
                query.whereEqualTo("usn", userusn);
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> studentList, ParseException e) {
                        if (e == null) {
                            if((studentList.size() == 0))
                            {
                                Toast.makeText(getBaseContext(), "Student does not exist. ", Toast.LENGTH_LONG).show();
                            }else{
                                Log.d("DeleteActivity", "Retrieved " + studentList.size() + " student");
                                for (ParseObject stud : studentList) {
                                    stud.deleteInBackground(new DeleteCallback() {
                                        @Override
                                        public void done(ParseException e) {
                                            if (e == null) {
                                                Log.d("DeleteActivity", "Student successfully deleted");
                                                Toast.makeText(getBaseContext(), "Student successfully deleted. ", Toast.LENGTH_LONG).show();
                                                finish();
                                            } else {
                                                Log.d("DeleteActivity", "Error: " + e.getMessage());
                                                Toast.makeText(getBaseContext(), "Deletion failed.\nTry again later. ", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                                }
                            }
                        } else {
                            Log.d("student", "Error: " + e.getMessage());
                            Toast.makeText(getBaseContext(), "Deletion failed.\nTry again later. ", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

        });

    }
}