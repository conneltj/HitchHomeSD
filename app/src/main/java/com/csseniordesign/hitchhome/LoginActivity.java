package com.csseniordesign.hitchhome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conne_000.myapplication.hitchome_cloud.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

public class LoginActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (userLoggedIn()) {
            //May need to create new activity
            Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        } else {
            setContentView(R.layout.login);
            assignListeners();
        }


    }

    private boolean userLoggedIn() {
        SharedPreferences prefs = this.getSharedPreferences("com.csseniordesign.hitchhome", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String userID = prefs.getString("userID", null);
        new EndpointsLoginTask().execute(new Pair<Context, String>(this, "Please Login"));

        return userID != null;
    }

    public void test() {
        new EndpointsLoginTask().execute(new Pair<Context, String>(this, "Please Login"));
    }

    private void assignListeners() {
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final Button btnSignUp = (Button) findViewById(R.id.btnSignUp);
        final Button btnSkipShit = (Button) findViewById(R.id.btnSkipShit);
        final EditText txtEmail = (EditText) findViewById(R.id.txtEmailAddress);
        final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnSkipShit.setVisibility(View.VISIBLE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //perform action
                //Hide buttons
                btnLogin.setVisibility(View.INVISIBLE);
                btnSignUp.setVisibility(View.INVISIBLE);
                //Show login text fields
                txtEmail.setVisibility(View.VISIBLE);
                txtPassword.setVisibility(View.VISIBLE);
                test();


            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //perform action
                //Hide Buttons

                //Show signup textfields

            }
        });

        btnSkipShit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //perform action
                //Hide Buttons
                Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                //Show signup textfields

            }
        });

    }
}

class EndpointsLoginTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) { //Only do this once)
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://flash-zenith-87406.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            //End options for dev server
            myApiService = builder.build();
        }
        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}

class LoginInfo {
    private String email;
    private String password;
    private Date lastLogin;
    private long userID;

    public String getEmail() {
        return email;
    }

    public void setEmail(String s) {
        email = s;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long l) {
        userID = l;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String s) {
        try {
            password = PasswordHash.createHash(s);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
