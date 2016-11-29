package com.example.demonstration_simple_mysql_php_login;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Lionel on 10/31/2016.
 */
public class AsyncPHPConnection extends AsyncTask<String, Integer, Long>
{
    private URL url;
    // 10.65.6.75
    final String request = "http://10.0.2.2/some_php_page.php";
    String username,
           password;

    public AsyncPHPConnection(String name, String password) throws Exception
    {
        this.username = name;
        this.password = password;
    }

    private void postToURL() throws IOException
    {
        // Create the URL
        this.url = new URL(request + "?username=" + this.username + "&password=" + this.password);

        // Open the connection..
        URLConnection httpConnection = url.openConnection();

        // HEre we're getting the response.
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        String line = null;
        while((line =reader.readLine()) != null)
        {
            Log.d("responseFromServer", line);
        }

        reader.close();
    }

    @Override
    protected Long doInBackground(String... params) {
        try {
            postToURL();
        }
        catch(IOException e)
        {
            Log.d("Error", e.toString());
        }

        return null;
    }
}
