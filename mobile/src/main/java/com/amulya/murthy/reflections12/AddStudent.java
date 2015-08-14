package com.amulya.murthy.reflections12;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.CountCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;


public class AddStudent extends Activity{

    EditText userName,userPassword,confirmPassword,userUsn;
    String name,password,con_pass,usn;
    int length;
    Button register;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.add_stud);
        userName = (EditText) findViewById(R.id.user_name);
        userPassword = (EditText) findViewById(R.id.user_pass);
        confirmPassword = (EditText) findViewById(R.id.con_pass);
        userUsn = (EditText) findViewById(R.id.user_usn);
        register = (Button) findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = userName.getText().toString();
                password = userPassword.getText().toString();
                con_pass = confirmPassword.getText().toString();
                usn = userUsn.getText().toString();
                length = usn.length();

                if (!password.equals(con_pass))
                {
                    Toast.makeText(getBaseContext(),"Passwords did not match.",Toast.LENGTH_LONG).show();
                    userName.setText("");
                    userPassword.setText("");
                    confirmPassword.setText("");
                    userUsn.setText("");
                }
                else if(length > 10)
                {
                    Toast.makeText(getBaseContext(),"University Seat Number too long.",Toast.LENGTH_LONG).show();
                    userName.setText("");
                    userPassword.setText("");
                    confirmPassword.setText("");
                    userUsn.setText("");


                }
                else if(length < 10)
                {
                    Toast.makeText(getBaseContext(),"University Seat Number too short.",Toast.LENGTH_LONG).show();
                    userName.setText("");
                    userPassword.setText("");
                    confirmPassword.setText("");
                    userUsn.setText("");

                }
                else
                {
                    Toast.makeText(getBaseContext(), "Please wait...", Toast.LENGTH_LONG).show();
                    ParseQuery<ParseObject> studentQuery = ParseQuery.getQuery("StudentDatabase");
                    studentQuery.whereEqualTo("Type", "student");
                    studentQuery.whereEqualTo("usn", usn);
                    studentQuery.countInBackground(new CountCallback() {
                        public void done(int count, ParseException e) {
                            if (e == null) {
                                if(count == 0){
                                    ParseObject StudentDatabase = new ParseObject("StudentDatabase");
                                    StudentDatabase.put("Type","student");
                                    StudentDatabase.put("Name",name);
                                    StudentDatabase.put("password",password);
                                    StudentDatabase.put("usn",usn);
                                    StudentDatabase.put("MathField1","excellent");
                                    StudentDatabase.put("MathField2","excellent");
                                    StudentDatabase.put("MathField3","excellent");
                                    StudentDatabase.put("GtField1","excellent");
                                    StudentDatabase.put("GtField2","excellent");
                                    StudentDatabase.put("GtField3","excellent");
                                    StudentDatabase.put("UnixField1","excellent");
                                    StudentDatabase.put("UnixField2","excellent");
                                    StudentDatabase.put("UnixField3","excellent");
                                    StudentDatabase.saveInBackground(new SaveCallback() {
                                        public void done(ParseException e) {
                                            if (e == null) {
                                                // Hooray! Let them use the app now.
                                                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                                                finish();
                                            } else {
                                                // Sign up didn't succeed. Look at the ParseException
                                                // to figure out what went wrong
                                                e.printStackTrace();
                                                Toast.makeText(getApplicationContext(), "Failed to register.\nTry again later.", Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                    });
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Student already exists.", Toast.LENGTH_SHORT).show();
                                }
                                // The count request succeeded. Log the count


                            } else {
                                // The request failed
                                Toast.makeText(getApplicationContext(), "Failed to register.\nTry again later.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }

            }
        });
    }
}
