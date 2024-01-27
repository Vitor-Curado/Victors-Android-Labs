package algonquin.cst2335.data.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import algonquin.cst2335.brag0033.databinding.ActivityMainBinding;
import algonquin.cst2335.data.data.MainViewModel;

// Typing comments as ordered in Making Git Branches 1/6
// Comments typed successfully
// I am now doing the doo doo doo

public class MainActivity extends AppCompatActivity {

    private MainViewModel model;
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        // The next step is to replace the setConventView() function call with:
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        // editString was cast using toString()
        variableBinding.mytext.setText(model.editString.toString());

        variableBinding.mybutton.setOnClickListener(click ->
        {
            model.editString.postValue(variableBinding.myedittext.getText().toString());
            variableBinding.mytext.setText("Your edit has: " + model.editString);
        });

        model.editString.observe(this, s ->
        {
            variableBinding.mytext.setText("Your edit text has " + s);
        });

        // Lab 5/6 session:
        model.selected.observe(this, selected ->
        {
            variableBinding.checkBox.setChecked(selected);
            variableBinding.radioButton.setChecked(selected);
            variableBinding.switch1.setChecked(selected);
        });

        // Lastly, call setOnCheckedChangeListener( ) on each button,
        // but use the Lambda function version.
        variableBinding.checkBox.setOnCheckedChangeListener((btn, isChecked) ->
        {
            model.selected.postValue(isChecked);
            Toast toast = Toast.makeText(this /* MyActivity */, "The value is now: " + isChecked , Toast.LENGTH_SHORT);
            toast.show();
        });

        variableBinding.radioButton.setOnCheckedChangeListener((btn, isChecked) ->
        {
            model.selected.postValue(isChecked);
            Toast toast = Toast.makeText(this /* MyActivity */, "The value is now: " + isChecked , Toast.LENGTH_SHORT);
            toast.show();
        });

        variableBinding.switch1.setOnCheckedChangeListener((btn, isChecked) ->
        {
            model.selected.postValue(isChecked);
            Toast toast = Toast.makeText(this /* MyActivity */, "The value is now: " + isChecked , Toast.LENGTH_SHORT);
            toast.show();
        });

        // Part 6/6:
        // Use ViewBinding in Java to initialize the variable with an onClickListener()
        variableBinding.myimagebutton.setOnClickListener(click ->
        {
            Toast.makeText(this, "The width = " + variableBinding.myimagebutton.getWidth() + "and height = " + variableBinding.myimagebutton.getHeight(), Toast.LENGTH_SHORT).show();
        });
    }
}