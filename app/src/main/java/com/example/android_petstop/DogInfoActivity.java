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


public class DogInfoActivity extends BasicActivity {
    private static final String TAG = "DogInfoActivity";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_info);

        findViewById(R.id.btn_createAboutMe).setOnClickListener(onClickListener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    View.OnClickListener onClickListener = (view) -> {
        switch (view.getId()) {
            case R.id.btn_createAboutMe:
                profileUpdate();
                break;
        }
    };

    private void profileUpdate() {
        final String username = ((EditText) findViewById(R.id.usernameEditText)).getText().toString();
        final String age = ((EditText) findViewById(R.id.ageEditText)).getText().toString();
        final String breed = ((EditText) findViewById(R.id.breedEditText)).getText().toString();
        final String motto = ((EditText) findViewById(R.id.mottoEditText)).getText().toString();

        if (username.length() > 0 && age.length() > 0 && breed.length() > 0 && motto.length() > 0) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            DogInfo dogInfo = new DogInfo(username, age, breed, motto);
            if (user != null) {
                db.collection("petInfo").document(user.getUid()).set(dogInfo)
                        .addOnSuccessListener(aVoid -> {
                            startToast("Pet information: successfully saved");
                            finish();
                        })
                        .addOnFailureListener(e -> {
                            startToast("Pet information: failure to save");
                            Log.w(TAG, "Error writing document", e);
                        });
            }
            } else {
                startToast("Fill in the information.");
            }
        }
        private void startToast(String msg){
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
