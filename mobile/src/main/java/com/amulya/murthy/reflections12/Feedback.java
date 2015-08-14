package com.amulya.murthy.reflections12;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.parse.CountCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;



public class Feedback extends Activity {
    String username, subject ,subString;
    TextView subName, good, avg, exc, good1, avg1, exc1, good2, avg2, exc2;
    float gd = 0, average = 0, excellent = 0, gd1 = 0, average1 = 0, excellent1 = 0, gd2 = 0, average2 = 0, excellent2 = 0;
    float count1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        Bundle b = getIntent().getExtras();
        username = b.getString("name");
        subject = b.getString("sub");
        subName = (TextView) findViewById(R.id.subName);
        subName.setText(subject);
        good = (TextView) findViewById(R.id.mgoodR1);
        avg = (TextView) findViewById(R.id.mavgR1);
        exc = (TextView) findViewById(R.id.mexcR1);
        good1 = (TextView) findViewById(R.id.mgoodR2);
        avg1 = (TextView) findViewById(R.id.mavgR2);
        exc1 = (TextView) findViewById(R.id.mexcR2);
        good2 = (TextView) findViewById(R.id.mgoodR3);
        avg2 = (TextView) findViewById(R.id.mavgR3);
        exc2 = (TextView) findViewById(R.id.mexcR3);
        {
            ParseQuery<ParseObject> studentQuery = ParseQuery.getQuery("StudentDatabase");
            studentQuery.whereEqualTo("Type", "student");
            studentQuery.countInBackground(new CountCallback() {
                public void done(int count, ParseException e) {
                    if (e == null) {
                        // The count request succeeded. Log the count
                        Log.d("feedback", "Total feedback " + count + " students");
                        count1 = (float) count;
                    } else {
                        // The request failed
                        Log.d("feedback", "No student feedback");
                    }
                }
            });
        }
        if (subject.equals("Mathematics"))
            subString = "Math";
        else if(subject.equals("Graph Theory "))
            subString = "Gt";
        else if(subject.equals("   Unix   "))
            subString = "Unix";

        ParseQuery<ParseObject> field1GoodQuery = ParseQuery.getQuery("StudentDatabase");
        field1GoodQuery.whereEqualTo("Type", "student");
        field1GoodQuery.whereEqualTo(subString + "Field1", "good");
        field1GoodQuery.countInBackground(new CountCallback() {
            public void done(int countGood1, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Log the count
                    Log.d("feedback", "FieldGood1 " + countGood1);
                    gd = (countGood1 / count1)*100;
                    String s1 = String.format("%.2f", gd);
                    good.setText(s1 + "%");
                } else {
                    // The request failed
                }
            }
        });

        ParseQuery<ParseObject> field1AvgQuery = ParseQuery.getQuery("StudentDatabase");
        field1AvgQuery.whereEqualTo("Type", "student");
        field1AvgQuery.whereEqualTo(subString + "Field1", "average");
        field1AvgQuery.countInBackground(new CountCallback() {
            public void done(int countAvg1, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Log the count
                    Log.d("feedback", "FieldAverage1 " + countAvg1);
                    average = (countAvg1 / count1)*100;
                    String s2 = String.format("%.2f", average);
                    avg.setText(s2 + "%");
                } else {
                    // The request failed
                }
            }
        });

        ParseQuery<ParseObject> field1ExcQuery = ParseQuery.getQuery("StudentDatabase");
        field1ExcQuery.whereEqualTo("Type", "student");
        field1ExcQuery.whereEqualTo(subString + "Field1", "excellent");
        field1ExcQuery.countInBackground(new CountCallback() {
            public void done(int countExc1, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Log the count
                    Log.d("feedback", "FieldExcellent1 " + countExc1);
                    excellent = (countExc1 / count1)*100;
                    String s3 = String.format("%.2f", excellent);
                    exc.setText(s3 + "%");
                } else {
                    // The request failed
                }
            }
        });

        ParseQuery<ParseObject> field2GoodQuery = ParseQuery.getQuery("StudentDatabase");
        field2GoodQuery.whereEqualTo("Type", "student");
        field2GoodQuery.whereEqualTo(subString + "Field2", "good");
        field2GoodQuery.countInBackground(new CountCallback() {
            public void done(int countGood2, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Log the count
                    Log.d("feedback", "FieldGood2 " + countGood2);
                    gd1 = (countGood2 / count1)*100;
                    String s4 = String.format("%.2f", gd1);
                    good1.setText(s4 + "%");
                } else {
                    // The request failed
                }
            }
        });

        ParseQuery<ParseObject> field2AvgQuery = ParseQuery.getQuery("StudentDatabase");
        field2AvgQuery.whereEqualTo("Type", "student");
        field2AvgQuery.whereEqualTo(subString + "Field2", "average");
        field2AvgQuery.countInBackground(new CountCallback() {
            public void done(int countAvg2, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Log the count
                    Log.d("feedback", "FieldAverage2 " + countAvg2);
                    average1 = (countAvg2 / count1)*100;
                    String s5 = String.format("%.2f", average1);
                    avg1.setText(s5 + "%");
                } else {
                    // The request failed
                }
            }
        });

        ParseQuery<ParseObject> field2ExcQuery = ParseQuery.getQuery("StudentDatabase");
        field2ExcQuery.whereEqualTo("Type", "student");
        field2ExcQuery.whereEqualTo(subString + "Field2", "excellent");
        field2ExcQuery.countInBackground(new CountCallback() {
            public void done(int countExc2, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Log the count
                    Log.d("feedback", "FieldExcellent2 " + countExc2);
                    excellent1 = (countExc2 / count1)*100;
                    String s6 = String.format("%.2f", excellent1);
                    exc1.setText(s6 + "%");
                } else {
                    // The request failed
                }
            }
        });

        ParseQuery<ParseObject> field3GoodQuery = ParseQuery.getQuery("StudentDatabase");
        field3GoodQuery.whereEqualTo("Type", "student");
        field3GoodQuery.whereEqualTo(subString + "Field3", "good");
        field3GoodQuery.countInBackground(new CountCallback() {
            public void done(int countGood3, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Log the count
                    Log.d("feedback", "FieldGood3 " + countGood3);
                    gd2 = (countGood3 / count1)*100;
                    String s7 = String.format("%.2f", gd2);
                    good2.setText(s7 + "%");
                } else {
                    // The request failed
                }
            }
        });

        ParseQuery<ParseObject> field3AvgQuery = ParseQuery.getQuery("StudentDatabase");
        field3AvgQuery.whereEqualTo("Type", "student");
        field3AvgQuery.whereEqualTo(subString + "Field3", "average");
        field3AvgQuery.countInBackground(new CountCallback() {
            public void done(int countAvg3, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Log the count
                    Log.d("feedback", "FieldAverage3 " + countAvg3);
                    average2 = (countAvg3 / count1)*100;
                    String s8 = String.format("%.2f", average2);
                    avg2.setText(s8 + "%");
                } else {
                    // The request failed
                }
            }
        });

        ParseQuery<ParseObject> field3ExcQuery = ParseQuery.getQuery("StudentDatabase");
        field3ExcQuery.whereEqualTo("Type", "student");
        field3ExcQuery.whereEqualTo(subString + "Field3", "excellent");
        field3ExcQuery.countInBackground(new CountCallback() {
            public void done(int countExc3, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Log the count
                    Log.d("feedback", "FieldExcellent3 " + countExc3);
                    excellent2 = (countExc3 / count1)*100;
                    String s9 = String.format("%.2f", excellent2);
                    exc2.setText(s9 + "%");
                } else {
                    // The request failed
                }
            }
        });


    }

}
