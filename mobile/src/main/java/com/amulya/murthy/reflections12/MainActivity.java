package com.amulya.murthy.reflections12;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    Button student,teacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        student = (Button) findViewById(R.id.student);
        teacher = (Button) findViewById(R.id.teacher);
        final Context context1 = this;
        teacher.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {

                Intent intent1 = new Intent(context1, Teacher.class);
                startActivity(intent1);

            }

        });

        final Context context = this;
        student.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Student.class);
                startActivity(intent);

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
