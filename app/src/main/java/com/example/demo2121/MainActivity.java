package com.example.demo2121;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private EditText etEmail, etPassword;
private buttton createUser;
private TextView tvMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        createUser = findViewById(R.id.createUser);
        tvMsg = findViewById(R.id.tvMsg);

        @Override
                public void createUsers(View view) {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            if(email.isEmpty() || password.isEmpty()){
                tvMsg.setText("Email or password is empty");
            } else{
                ProgressDialog pd=new ProgressDialog(this);
                pd.setTitle("Connecting");
                pd.setMessage("Creating user...");
                pd.show();
                refAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pd.dismiss();
                    }
                        if(task.isSuccessful()){
                           Logi.i("Main activity", "createUserWithEmailAndPassword:success");

                }
        }
    }
}