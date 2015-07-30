package com.devf.smolinaa.firstapp.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class ActivityRegister extends AppCompatActivity {


    @InjectView(R.id.editTextFirstName)
    EditText editTextFirstName;

    @InjectView(R.id.editTextLastName)
    EditText editTextLastName;

    @InjectView(R.id.editTextPassword1)
    EditText editTextPassword1;

    @InjectView(R.id.editTextPassword2)
    EditText editTextPassword2;

    @InjectView(R.id.editPhoneNumber)
    EditText editPhoneNumber;

    @InjectView(R.id.editEmail)
    EditText editEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.inject(this);
    }

    public boolean isEmptyFields() {
        return TextUtils.isEmpty(editTextFirstName.getText())
                || TextUtils.isEmpty(editTextLastName.getText())
                || TextUtils.isEmpty(editTextPassword1.getText())
                || TextUtils.isEmpty(editTextPassword2.getText())
                || TextUtils.isEmpty(editEmail.getText())
                || TextUtils.isEmpty(editPhoneNumber.getText());
    }

    @OnClick(R.id.btnCreateAccount)
    public void myClick(View view) {

        if (!isEmptyFields()){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(ActivityRegister.this, R.string.text_message_full_fields, Toast.LENGTH_SHORT).show();

        }

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
