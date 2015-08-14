package com.amulya.murthy.reflections12;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;


public class Reflection extends Application {

    public void onCreate() {
        Parse.initialize(this, "vSjUPErPuHj9BJbGOFXL2qYGPvFIhJgp99kpv71D", "vbgteHubFnEfJCpYylLaqKL6zxD5cLI9u5dmS9dH");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}