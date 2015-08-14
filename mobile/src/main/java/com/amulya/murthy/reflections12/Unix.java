package com.amulya.murthy.reflections12;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class Unix extends Fragment {

    Button good,average,excellent,good1,average1,excellent1,good2,average2,excellent2,home;
    int rating;
    String usn,subject;
    EditText userName,userPassword,userUsn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.unix, container, false);
        good = (Button)view.findViewById(R.id.ugood);
        average = (Button)view.findViewById(R.id.uavg);
        excellent = (Button)view.findViewById(R.id.uexcellent);
        good1 = (Button)view.findViewById(R.id.ugood1);
        average1 = (Button)view.findViewById(R.id.uavg1);
        excellent1 = (Button)view.findViewById(R.id.uexcellent1);
        good2 = (Button)view.findViewById(R.id.ugood2);
        average2 = (Button)view.findViewById(R.id.uavg2);
        excellent2 = (Button)view.findViewById(R.id.uexcellent2);
        home = (Button)view.findViewById(R.id.home);
        usn = getArguments().getString("usn");
        userName = (EditText) view.findViewById(R.id.name_unique);
        userPassword = (EditText) view.findViewById(R.id.password_unique);
        userUsn = (EditText) view.findViewById(R.id.usn_unique);

        good.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 1;
                subject = "u1";
                add(rating,subject);
                Log.d("Database Operations", "Unix Field1 inserted");
            }

        });

        average.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 2;
                subject = "u1";
                add(rating,subject);
                Log.d("Database Operations", "Unix Field1 inserted");
            }

        });
        excellent.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 3;
                subject = "u1";
                add(rating,subject);
                Log.d("Database Operations", "Unix Field1 inserted");
            }

        });

        good1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 1;
                subject = "u2";
                add(rating,subject);
                Log.d("Database Operations", "Unix Field2 inserted");
            }

        });

        average1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 2;
                subject = "u2";
                add(rating,subject);
                Log.d("Database Operations", "Unix Field2 inserted");
            }

        });
        excellent1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 3;
                subject = "u2";
                add(rating,subject);
                Log.d("Database Operations", "Unix Field2 inserted");
            }

        });
        good2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 1;
                subject = "u3";
                add(rating,subject);
                Log.d("Database Operations", "Unix Field3 inserted");
            }

        });

        average2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 2;
                subject = "u3";
                add(rating,subject);
                Log.d("Database Operations", "Unix Field3 inserted");
            }

        });
        excellent2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 3;
                subject = "u3";
                add(rating,subject);
                Log.d("Database Operations", "Unix Field3 inserted");
            }

        });

        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                getActivity().finish();
            }
        });
        return view;
    }

    public void add(final int RATING,final String SUBJECT)
    {

        ParseQuery<ParseObject> studentQuery = ParseQuery.getQuery("StudentDatabase");
        studentQuery.whereEqualTo("usn",usn);
        studentQuery.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> StudList, ParseException e) {

                if (e == null) {
                    String rate = "";
                    Log.d("math", "Retrieved " + StudList.size() + " student");
                    for (ParseObject student : StudList) {
                        if(RATING == 1)
                            rate = "good";
                        else if(RATING == 2)
                            rate = "average";
                        else
                            rate = "excellent";
                        switch(SUBJECT) {
                            case "u1": student.put("UnixField1", rate);
                                break;
                            case "u2":student.put("UnixField2", rate);
                                break;
                            case "u3":student.put("UnixField3", rate);
                                break;
                        }
                        student.saveInBackground();
                        Toast.makeText(getActivity().getBaseContext(), "Rating is recorded.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
