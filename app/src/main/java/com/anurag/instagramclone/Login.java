package com.anurag.instagramclone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login extends AppCompatActivity {

    private EditText namelogin ,  passwordlogin;
    private Button loginenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        setTitle("Login");

        namelogin = findViewById(R.id.namelogin);
        passwordlogin= findViewById(R.id.passwordlogin);
        loginenter = findViewById(R.id.loginenter);

        if (ParseUser.getCurrentUser() !=null){
            ParseUser.getCurrentUser().logOut();
        }

        loginenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (namelogin.getText().toString().equals("") || passwordlogin.
                        getText().toString().equals("")) {
                    Toast.makeText(Login.this, "Name or Password is Required", Toast.LENGTH_LONG).show();

                } else {
                    final ProgressDialog progressDialog = new ProgressDialog(Login.this);
                    progressDialog.setMessage("Logging In");
                    progressDialog.show();
                    ParseUser.logInInBackground(namelogin.getText().toString(), passwordlogin.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user != null && e == null) {

                                Toast.makeText(Login.this, user.get("username") + " is Logged In "
                                        , Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(Login.this,Home.class);
                                startActivity(intent);
                                progressDialog.dismiss();


                            } else {
                                Toast.makeText(Login.this, e.getMessage()
                                        , Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                            }
                        }
                    });
                }
            }
        });
    }
    public void rootTapped(View view) {
        try {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
