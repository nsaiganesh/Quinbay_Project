package com.example.quinbayproject.activity;

import static com.example.quinbayproject.utils.Constants.IP_ADDRESS;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.quinbayproject.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

public class UserLoginActivity extends AppCompatActivity {
GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        View googleButton=findViewById(R.id.sign_in_button);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGoogleSignIn(v);
            }
        });
    }
    public void handleGoogleSignIn(View view)
    {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("error", "signInResult:failed code=" + e.getStatusCode());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account!=null)
        {
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
        }
    }

    public void hideHorizontalDivider(View view)
    {
        EditText editText=(EditText)view;
        String s= editText.getHint().toString();
        Log.i("hi",(""+s.equals(R.string.email_hint)));
        View v1 = findViewById(R.id.dv_email);
        if(s.equals(R.string.email_hint)) {
            v1.setBackgroundColor(ContextCompat.getColor(this, R.color.grey_dark_2));
        }
        v1.setFocusable(true);
    }
    public void userLogin(View view)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        String email=((EditText)findViewById(R.id.ev_log_em)).getText().toString();
        String password=((EditText)findViewById(R.id.ev_log_ps)).getText().toString();
        String url = "http://"+IP_ADDRESS+"/user/signIn";
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("email", email);
            jsonObject.put("password", password);
        }catch (JSONException e){
            e.printStackTrace();
        }


        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest( Request.Method.POST, url,jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("response", response.toString());
                        try {
                            String token = response.getString("token");
                            SharedPreferences sharedPreferences=getSharedPreferences("TOKEN", MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("token",token);
                            editor.commit();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error",error.getMessage());
                    }
                });

        queue.add(jsonObjectRequest);
    }
    public void userSignUp(View view)
    {

        Intent intent=new Intent(this, UserRegisterActivity.class);
        startActivity(intent);
    }
}