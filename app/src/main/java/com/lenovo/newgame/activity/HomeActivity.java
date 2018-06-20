package com.lenovo.newgame.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Icon;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.lenovo.newgame.R;
import com.lenovo.newgame.game_2048;
import com.lenovo.newgame.quiz;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.lenovo.newgame.R.drawable.ic_volume_up_black_24dp;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{   public MediaPlayer mp;
    public int soundflag;
    FirebaseAuth mAuth;
    LinearLayout trigno, learnbook, object;
    ImageButton setting, share;
    static final int RC_SIGN_IN =1;
    private static String TAG = "LoginActivity";
    private GoogleApiClient mGoogleSignInClient;
    public static FirebaseUser user;
    ProgressDialog mprogress;
    public DatabaseReference myref;
    public DatabaseReference mchild;
    public StorageReference storeimage;
    private static final String LOCALE_KEY = "localekey";
    private static final String HINDI_LOCALE = "hi";
    private static final String ENGLISH_LOCALE = "en_US";
    private static final String LOCALE_PREF_KEY = "localePref";
    @BindView(R.id.simpleProgressBar)
    RoundCornerProgressBar simpleProgressBar;
    @BindView(R.id.simpleProgressBar2)
    RoundCornerProgressBar simpleProgressBar2;
    @BindView(R.id.simpleProgressBar3)
    RoundCornerProgressBar simpleProgressBar3;
    int basiclevel,objectlevel,trignolevel;
    private Locale locale;
    CircleImageView   profileimage;
    TextView user_name,user_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
//        learn=(LinearLayout) findViewById(R.id.learn);
        trigno = (LinearLayout) findViewById(R.id.trigo);
        learnbook = (LinearLayout) findViewById(R.id.learnbook);
        object = (LinearLayout) findViewById(R.id.object);
        mp = MediaPlayer.create(this, R.raw.bclick);
        SharedPreferences prefs = this.getSharedPreferences(
                "level", Context.MODE_PRIVATE);
        soundflag = prefs.getInt( "sound",1 );
        basiclevel = prefs.getInt("basiclevel",0);
        objectlevel = prefs.getInt("objectlevel",0);
        trignolevel = prefs.getInt("trignolevel",0);
        simpleProgressBar.setProgress((basiclevel-1)*10);
        simpleProgressBar2.setProgress(objectlevel*10);
        simpleProgressBar3.setProgress(trignolevel*10);
        simpleProgressBar3.setMax(100);
        simpleProgressBar2.setMax( 100 );
        simpleProgressBar.setMax( 100 );
        myref = FirebaseDatabase.getInstance().getReference();
        mchild = myref.child("User");
        storeimage = FirebaseStorage.getInstance().getReference();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
        user =mAuth.getCurrentUser();
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                    }
                })
                .addApi( Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        learnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                Intent i = new Intent(HomeActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });
        object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                Intent i = new Intent(HomeActivity.this, object.class);
                startActivity(i);
            }
        });
        trigno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                Intent i = new Intent(HomeActivity.this, TrignoActivity.class);
                startActivity(i);
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



//       username.setText( ""+user.getDisplayName() );
//       email.setText(""+ user.getEmail() );
//       profileimage.setImageURI( user.getPhotoUrl() );

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.inflateHeaderView(R.layout.nav_header_main);
       profileimage=(CircleImageView)view.findViewById(R.id.user_image);
        user_name =(TextView)view.findViewById( R.id.user_name );
        user_email = (TextView)view.findViewById( R.id.email );

//        navigationView.getMenu().getItem(2).getSubMenu().getItem(0).setIcon(R.drawable.logo_2048);
        if (soundflag == 1)
            navigationView.getMenu().getItem(3).getSubMenu().getItem(1).setIcon(R.drawable.ic_volume_up_black_24dp);
        else
            navigationView.getMenu().getItem(3).getSubMenu().getItem(1).setIcon(R.drawable.ic_volume_off_black_24dp);

        if (user != null) {
//            mprogress.show();
//
//            mprogress.dismiss();
            //Toast.makeText(this, user.getPhotoUrl().toString(), Toast.LENGTH_SHORT).show();
            Uri photo=user.getPhotoUrl();
            Glide.with(getApplicationContext()).load(photo).into(profileimage);
            user_name.setText(user.getDisplayName());
            user_email.setText(user.getEmail());

        }



    }

    private void call() {
        if (soundflag == 1)
            mp.start();
    }

    public void easylevel(View view) {
        call();
        Intent intent = new Intent(HomeActivity.this, basic.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.dashboard) {

            Intent i=new Intent(this,Dashboard_Activity.class);
            startActivity(i);
        }  else if (id == R.id.nav_scoreboard)
        {


        }
        else if(id == R.id.game)
        {
            Intent i =new Intent(HomeActivity.this, game_2048.class);
            startActivity(i);
        }
        else if(id == R.id.nav)
        {
            Intent i =new Intent(HomeActivity.this, quiz.class);
            startActivity(i);
        }

        else if (id == R.id.nav_share) {

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        } else if (id == R.id.nav_sound) {

            SharedPreferences prefs = getApplicationContext().getSharedPreferences(
                    "level", Context.MODE_PRIVATE);
            if(soundflag == 1){
                item.setIcon(R.drawable.ic_volume_off_black_24dp);
                prefs.edit().putInt( "sound",0).apply();
                soundflag = 0;
            }
            else{
                item.setIcon( ic_volume_up_black_24dp);
                prefs.edit().putInt( "sound",1).apply();
                soundflag = 1;
            }

        }
        else if (id==R.id.nav_logout){

            updateUI(user);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleSignInClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
                Toast.makeText( this, "LogIn Successfull !!", Toast.LENGTH_SHORT ).show();
//                mprogress.setMessage("Please wait..... ");
//                mprogress.show();
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
                Toast.makeText( this, "LogIn Unsuccessfull!!", Toast.LENGTH_SHORT ).show();
//                mprogress.dismiss();

            }
        }
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    public void updateUI(FirebaseUser user) {

        if (user != null) {
//            mprogress.show();
//
//            mprogress.dismiss();
            //Toast.makeText(this, user.getPhotoUrl().toString(), Toast.LENGTH_SHORT).show();
            Uri photo=user.getPhotoUrl();
            Glide.with(getApplicationContext()).load(photo).into(profileimage);
            user_name.setText(user.getDisplayName());
            user_email.setText(user.getEmail());

        }
        else
        {
            signIn();
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser User= mAuth.getCurrentUser();
                            updateUI( User );


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(HomeActivity.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                        }


                        // ...
                    }
                });
    }
public void game2048(View V){

    Intent i =new Intent(HomeActivity.this, game_2048.class);
    startActivity(i);

}

}
