package algonquin.cst2335.data.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

/**
 * The MainViewModel class implements all the variables required by the MainActivity class.
 * The reason for this is when you change the rotation of your device, Android deletes the
 * current screen and creates a new one for the new rotated orientation.
 * A ViewModel object should only hold data variables, and never View or Widget objects.
 * These can be deleted and recreated so they might not be valid later.
 */
public class MainViewModel extends ViewModel
{
    public MutableLiveData<String> editString = new MutableLiveData<>();

    // Go ahead and add a variable and give it a name that makes sense.
    // It should actually be a MutableLiveData<Boolean> variable since
    // we want to be notified when it changes.
    public MutableLiveData<Boolean> selected = new MutableLiveData<Boolean>();
}
