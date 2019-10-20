package com.lamart.site.mymotiv.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lamart.site.mymotiv.R;

public class LoginPageActivity extends Activity {

    private static EditText password;
    private static Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        initComponent();
    }

    private void initComponent(){
        password = findViewById(R.id.editTextPassword);
        signIn = findViewById(R.id.login_button);
        signIn.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startMenuActivity();
        }
    };

    private void startMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        LoginPageActivity.this.finish();
    }

    public static void setText(String code){
        if(password != null){
            password.setText(code);
            signIn.performClick();
        }
    }
}
