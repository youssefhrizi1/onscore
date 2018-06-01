package com.example.hrizi.onescore;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Singin extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;
    Button singinbtn;
    EditText emailText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        singinbtn = (Button) findViewById(R.id.singinbtn);

         //get emailText and passwordText
        emailText= (EditText) findViewById(R.id.emailText);
        passwordText= (EditText) findViewById(R.id.passwordText);


    }



    public void registerbtn(View view) {
        Intent tosingup= new Intent(Singin.this,Singup.class);
        startActivity(tosingup);
    }
    public void loginbtn(View view) {

        login();
    }

    private void login() {
        if (!validate()) {
            onLoginFailed();
            return;
         }


        singinbtn.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(Singin.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        if(email.equals("a@g.com") &&
                password.equals("admin")) {
            Intent mainintent= new Intent(Singin.this,MainActivity.class);
            startActivity(mainintent);
        }else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_LONG).show();
            Intent tosingin= new Intent(Singin.this,Singin.class);
            startActivity(tosingin);
        }

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here

                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        singinbtn.setEnabled(true);
        finish();
    }

    private void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        singinbtn.setEnabled(true);
    }

    private boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }
    }



