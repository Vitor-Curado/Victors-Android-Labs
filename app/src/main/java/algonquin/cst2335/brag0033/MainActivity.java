package algonquin.cst2335.brag0033;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import algonquin.cst2335.brag0033.databinding.ActivityMainBinding;

// Typing comments as ordered in Making Git Branches 1/6
// Comments typed successfully
// I am now doing the doo doo doo

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // The next step is to replace the setConventView() function call with:
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        // In your code, use this function to find your id for the TextView:
        TextView mytext = findViewById(R.id.textView);

        Button btn = findViewById(R.id.mybutton);

        // Now in the Java or Kotlin file, load that object into your program:
        // Java:
        EditText myedit = findViewById(R.id.myedittext);

        // Look at the Button documentation and find a function that adds a listener to a button
        // object for when the user clicks on it.
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // In the public void onClick( View v) function that gets run
                // when the user clicks a button, I want you to change the TextView
                // object to show the string "Your edit text has : " + the text
                // currently in the EditText.
                String editString = myedit.getText().toString();

                // Now that you have the string that is in the EditText,
                // you want set the string on the TextView using the setText function:
                mytext.setText("Your edit text has: " + editString);
            }
        });
    }
}