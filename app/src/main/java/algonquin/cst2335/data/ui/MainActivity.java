package algonquin.cst2335.data.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Toast;

import algonquin.cst2335.brag0033.SecondActivity;
import algonquin.cst2335.brag0033.databinding.ActivityMainBinding;
import algonquin.cst2335.data.data.MainViewModel;

// Typing comments as ordered in Making Git Branches 1/6
// Comments typed successfully
// I am now doing the doo doo doo

public class MainActivity extends AppCompatActivity
{
    private MainViewModel model;
    private ActivityMainBinding variableBinding;
    private static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Lab 4: added this line as ordered.
        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );

        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(MainViewModel.class);

        // The next step is to replace the setConventView() function call with:
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        // I guess this is lab 4?
        variableBinding.loginButton.setOnClickListener(click ->
        {
            Intent nextPage = new Intent( MainActivity.this, SecondActivity.class);
            // An Intent object also lets you send variables to the next Activity using the putExtra() functions:
            // (example)
            // if you weren't properly informed, vroom vroom is true
            // nextPage.putExtra("Vroom vroom", true);
            nextPage.putExtra( "EmailAddress", variableBinding.emailEditText.getText().toString() );

            // Then to actually make the transition, you call startActivity with the intent objectstartActivity( nextPage);
            startActivity( nextPage);
        });
    }

    // Added the functions onResume(), onPause(), onStop(), onDestroy(), and onStart as ordered.
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.w(TAG, "The application is now responding to user input");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.w(TAG, "The application no longer responds to user input");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.w(TAG, "The application is no longer visible");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.w(TAG, "Any memory used by the application is freed");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.w(TAG, "The application is now visible on screen");
    }
}