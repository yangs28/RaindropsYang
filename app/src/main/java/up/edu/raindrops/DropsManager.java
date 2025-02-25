package up.edu.raindrops;

import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import up.edu.raindrops.Drops;

/**
 * Manager class that helps provide the information for the coordinates, color and size
 * of the main raindrop object. Has methods for obtaining and modifying X and Y positions
 *
 * @author Sean Yang
 * @version B 1.4 2-18-25
 */
public class DropsManager implements CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {
    //Stores information for the main raindrop
    private int x;
    private int y;
    private float radius;
    private Paint color;
    //Stores two classes for the view and drop classes
    private RainView theView;
    private Drops theDrop;


    //Constructor automatically sets the instance variables using info from the main raindrop
    public DropsManager(RainView mainView) {
        //Sets the RainView object to be from the parameter
        theView = mainView;
        //Grabs the main raindrop from the RainView object
        theDrop = theView.getDrops();
        //Grabs the XY coordinates of the main raindrop for the instance variables
        x = (int) theDrop.getXPos();
        y = (int) theDrop.getYPos();

    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public Paint getColor() {
        return color;
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        //Compares the ID of the seekbar. Sees if the ID matches the ID of the horizontal seek bar
        if (seekBar.getId() == 2131230939) {
            //If yes, set the X value to be equal to the seekbar's value
            theDrop.setX(seekBar.getProgress());
        } else {
            //If not, set the Y value instead
            theDrop.setY(seekBar.getProgress());
        }

        //When the seekbar detects a change, sets hasUpdated to true. This means we must redraw the surface view
        theDrop.hasUpdated = true;
        theView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}