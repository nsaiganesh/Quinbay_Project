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
import com.example.quinbayproject.model2.MerchantLogin;
import com.example.quinbayproject.model2.MerchantLoginResponse;
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

public class MerchantLoginActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText etMerchantName;
    private Button btnLogin;

    private Button btnLoginUsingGoogle;
    private EditText etMerchantPassword;
    private String merchantName;
    private String merchantPassword;
    private static final int RC_SIGN_IN = 100;
    private GoogleSignInClient googleSignInClient;
    private FirebaseAuth firebaseAuth;
    private  static final String TAG = "GOGLE_SIGN_IN_TAG";
    ApiInterface apiInterface;
    MerchantLogin merchantLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        setContentView(R.layout.activity_merchant_login);

        btnRegister = findViewById(R.id.btn_merchant_register);
        btnLogin = findViewById(R.id.btn_login_merchant);
        etMerchantName = findViewById(R.id.et_login_merchant_name);
        etMerchantPassword = findViewById(R.id.et_login_merchant_password);
        btnLoginUsingGoogle = findViewById(R.id.btn_login_using_social_media_merchant);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        firebaseAuth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MerchantLoginActivity.this, MerchantRegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                merchantName = etMerchantName.getText().toString().trim();
                merchantPassword = etMerchantPassword.getText().toString().trim();
                if(!merchantName.isEmpty() && !merchantPassword.isEmpty()){
                    merchantLogin = new MerchantLogin();
                    merchantLogin.setEmail(merchantName);
                    merchantLogin.setPassword(merchantPassword);
                    apicall();
                }
                else{
                    Toast.makeText(MerchantLoginActivity.this,"All fields Required",Toast.LENGTH_SHORT).show();
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
        apiInterface.loginMerchant(merchantLogin).enqueue(new Callback<MerchantLoginResponse>() {
            @Override
            public void onResponse(Call<MerchantLoginResponse> call, Response<MerchantLoginResponse> response) {
                Toast.makeText(MerchantLoginActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                //10.20.2.120:8095/products/getByCategoryMerchant/{}

            }

            @Override
            public void onFailure(Call<MerchantLoginResponse> call, Throwable t) {

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
                Toast.makeText(MerchantLoginActivity.this,"LoggedIn Succesfully",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Log.e("error",e+"");
                Toast.makeText(MerchantLoginActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(MerchantLoginActivity.this,"New user using google",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MerchantLoginActivity.this,"Existing user",Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(MerchantLoginActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MerchantLoginActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
