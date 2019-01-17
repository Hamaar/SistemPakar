package com.example.hilmi.sistempakar.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hilmi.sistempakar.R;
import com.example.hilmi.sistempakar.admin.Dashboard;

public class Login extends AppCompatActivity {

    EditText edtUser, edtPass;
    Button btnLogin;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        pd = new ProgressDialog(this);
        edtUser = (EditText)findViewById(R.id.edtUsername);
        edtPass = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        //klik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.dismiss();

                String keyUser = edtUser.getText().toString();
                String keyPass = edtPass.getText().toString();


                if (keyUser.isEmpty() && keyPass.isEmpty()){

                    Toast.makeText(getApplicationContext(), "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();

                }
                if (keyUser.equals("admin") && keyPass.equals("admin")){

                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Username atau Password Salah !", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
