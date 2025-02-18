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
 * @author Sean Yang
 * @version B 1.1 2-17-25
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

    boolean hasUpdated;

    //Constructor automatically sets the instance variables using info from the main raindrop
    public DropsManager(RainView mainView) {
        theView = mainView;
        theDrop = theView.getDrops();
        x = (int)theDrop.getXPos();
        y = (int)theDrop.getYPos();
        Log.i("cake", "how many" + x);
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

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}