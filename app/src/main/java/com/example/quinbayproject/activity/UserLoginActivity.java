package com.example.quinbayproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quinbayproject.R;
import com.example.quinbayproject.api.ApiInterface;
import com.example.quinbayproject.application.CustomApplication;
import com.example.quinbayproject.model2.UserLogin;
import com.example.quinbayproject.model2.UserLoginResponse;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText etUserName;
    private Button btnLogin;

    private Button btnLoginUsingGoogle;
    private EditText etUserPassword;
    private String userName;
    private String userPassword;
    private static final int RC_SIGN_IN = 100;
    private GoogleSignInClient googleSignInClient;
    private FirebaseAuth firebaseAuth;
    private  static final String TAG = "GOGLE_SIGN_IN_TAG";
    ApiInterface apiInterface;
    UserLogin userLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        setContentView(R.layout.activity_user_login);

        btnRegister = findViewById(R.id.btn_user_register);
        btnLogin = findViewById(R.id.btn_login_user);
        etUserName = findViewById(R.id.et_login_user_name);
        etUserPassword = findViewById(R.id.et_login_user_password);
        btnLoginUsingGoogle = findViewById(R.id.btn_login_using_social_media);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build();

        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        firebaseAuth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLoginActivity.this, UserRegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = etUserName.getText().toString().trim();
                userPassword = etUserPassword.getText().toString().trim();
                if(!userName.isEmpty() && !userPassword.isEmpty()){
                    userLogin = new UserLogin();
                    userLogin.setEmail(userName);
                    userLogin.setPassword(userPassword);
                    apicall();
                }
                else{
                    Toast.makeText(UserLoginActivity.this,"All fields Required",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnLoginUsingGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = googleSignInClient.getSignInIntent();
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });

    }

    private void apicall() {

        apiInterface = ((CustomApplication)getApplication()).retrofit.create(ApiInterface.class);
        apiInterface.loginUser(userLogin).enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                Toast.makeText(UserLoginActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                GoogleSignInAccount account = accountTask.getResult(ApiException.class);
                firebaseAuthWithGoogleAccount(account);
                Toast.makeText(UserLoginActivity.this,"LoggedIn Succesfully",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Log.e("error",e+"");
                Toast.makeText(UserLoginActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogleAccount(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
        firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                        String uid = firebaseUser.getUid();
                        String email = firebaseUser.getEmail();
                        if(authResult.getAdditionalUserInfo().isNewUser()){
                            Toast.makeText(UserLoginActivity.this,"New user using google",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(UserLoginActivity.this,"Existing user",Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(UserLoginActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                         Toast.makeText(UserLoginActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
