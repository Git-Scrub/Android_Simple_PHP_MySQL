package com.example.demonstration_simple_mysql_php_login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view)
    {
        String name = getName();
        String password = getPassword();

        try {
            new AsyncPHPConnection(name, password).execute();
        }
        catch(Exception e)
        {
            Log.d("Error", e.toString());
        }
    }

    private String getName()
    {
        return ((TextView)findViewById(R.id.usernameInput)).getText().toString();
    }

    private String getPassword()
    {
        return ((TextView)findViewById(R.id.inputPassword)).getText().toString();
    }
}
