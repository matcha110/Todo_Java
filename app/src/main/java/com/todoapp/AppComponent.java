package com.todoapp;

import android.app.Application;
import com.todoapp.db.AppDatabase;

public class AppComponent extends Application {
    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this);
    }
}
