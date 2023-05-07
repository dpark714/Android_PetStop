package com.example.android_petstop;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MemberInitActivity extends BasicActivity {
    private static final String TAG = "MemberInitActivity";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memeber_init);

        findViewById(R.id.checkButton).setOnClickListener(onClickListener);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    View.OnClickListener onClickListener = (view) -> {
        switch (view.getId()){
            case R.id.checkButton:
                profileUpdate();
                break;
        }
    };
    private void profileUpdate() {
        final String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
        final String phoneNumber = ((EditText) findViewById(R.id.phoneNumberEditText)).getText().toString();
        final String birthday = ((EditText) findViewById(R.id.birthdayEditText)).getText().toString();
        final String zipCode = ((EditText) findViewById(R.id.zipCodeEditText)).getText().toString();

        if(name.length() > 0 && phoneNumber.length() > 9 && birthday.length() > 7 && zipCode.length() >0){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            MemberInfo memberInfo = new MemberInfo(name, phoneNumber, birthday, zipCode);
            if (user != null){
                db.collection("users").document(user.getUid()).set(memberInfo)
                        .addOnSuccessListener(aVoid -> {
                            startToast("Register information: success");
                            finish();
                        })
                        .addOnFailureListener(e -> {
                            startToast("Register information: fail");
                            Log.w(TAG, "Error writing document", e);
                        });
            }
        }else{
            startToast("Fill in the information.");
        }
    }
    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

