package com.example.android_petstop;

import static com.example.android_petstop.R.id.btn_goto_LogIn;
import static com.example.android_petstop.R.id.btn_logIn;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "SignUpActivity";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btn_signUp).setOnClickListener(onClickListener);
        findViewById(R.id.btn_goto_LogIn).setOnClickListener(onClickListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            reload();
//        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_signUp:
                    signUp();
                    break;
                case btn_goto_LogIn:
                    startLogInActivity();
                    break;
            }
        }
    };
    private void signUp() {
        String email = ((EditText) findViewById(R.id.et_signUp_username)).getText().toString();
        String password = ((EditText) findViewById(R.id.et_signUp_password)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.et_signUp_passwordCheck)).getText().toString();

        if(email.length()> 0 && password.length() > 0 && passwordCheck.length()>0){
            if (password.equals(passwordCheck)){
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, (task) -> {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("signUp: success");
                            } else {
                                if (task.getException() != null){
                                    startToast(task.getException().toString());
                                }
                            }
                        });
            }else{
                startToast("Password isn't matched.");
            }
        }else{
            startToast("Enter your email address or password");
        }
    }
    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    private void startLogInActivity(){
        Intent intent = new Intent(this,LogInActivity.class);
        startActivity(intent);
    }
}