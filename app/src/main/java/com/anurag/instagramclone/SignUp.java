package com.anurag.instagramclone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {

    private EditText namesignup , passwordsignup , emailsignup;
    private Button signupenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);
        setTitle("Signup");

        namesignup = findViewById(R.id.namesignup);
        emailsignup = findViewById(R.id.emailsignup);
        passwordsignup= findViewById(R.id.passwordsignup);
        signupenter = findViewById(R.id.signupenter);

//        if (ParseUser.getCurrentUser() !=null){
//            ParseUser.getCurrentUser().logOut();
//        }



        signupenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (namesignup.getText().toString().equals("") || passwordsignup.
                        getText().toString().equals("") || emailsignup.getText().
                        toString().equals("")) {
                    Toast.makeText(SignUp.this, "Please Enter Username or email or password",
                            Toast.LENGTH_LONG).show();


                } else {
                    final ParseUser appuser = new ParseUser();
                    appuser.setUsername(namesignup.getText().toString());
                    appuser.setPassword(passwordsignup.getText().toString());
                    appuser.setEmail(emailsignup.getText().toString());

                    final ProgressDialog progressDialog = new ProgressDialog(SignUp.this);
                    progressDialog.setMessage("Signing Up " + appuser.getUsername());
                    progressDialog.show();

                    appuser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(SignUp.this,
                                        appuser.getUsername() + " is Signed Up",
                                        Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(SignUp.this , Home.class);
                                startActivity(intent);
                                finish();

                                progressDialog.dismiss();
                            } else {
                                Toast.makeText(SignUp.this, e.getMessage()
                                        , Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                            }
                        }
                    });
                }
//                passwordsignup.setOnKeyListener(new View.OnKeyListener() {
//                    @Override
//                    public boolean onKey(View v, int keyCode, KeyEvent event) {
//                        if (keyCode==KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN){
//                            onClick(signupenter);
//                        }
//                        return false;
//                    }
//                });
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
