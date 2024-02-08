package algonquin.cst2335.data.ui;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import algonquin.cst2335.brag0033.R;
import algonquin.cst2335.brag0033.databinding.ActivityMainBinding;
import algonquin.cst2335.brag0033.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    public ActivitySecondBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(variableBinding.getRoot());

        // write code to retrieve the Intent object that has the variables
        Intent fromPrevious = getIntent();

        // To retrieve this data, you call getExtra(),
        // but you have to modify it to the data type that is stored
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");

        // Apparently, the instructions tell me I have to call a number?
        // Fetching the number first
        //String phoneNumber = fromPrevious.getStringExtra("")

        // Set up a listener for the call button. Use the variable phoneNumber to call
        findViewById(R.id.call).setOnClickListener(click ->
        {
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + "123-456-7890"));

            // I guess this calls someone?
            startActivity(call);
        });

        // findViewById(R.id.picture).setOnClickListener();

        // Lastly, change the picture using the thing
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ActivityResultLauncher<Intent> cameraResult = registerForActivityResult
                (new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>()
                {
                            @Override
                            public void onActivityResult(ActivityResult result)
                            {
                                if (result.getResultCode() == Activity.RESULT_OK)
                                {
                                    // I HONESTLY
                                    // dunno what I'm doing
                                    // but ok
                                    Intent data = result.getData();
                                    Bitmap thumbnail = data.getParcelableExtra("data");
                                }
                            }
                });

        cameraResult.launch(cameraIntent);
    }
}