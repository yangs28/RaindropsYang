package up.edu.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Subclass of SurfaceView that draws raindrops with randomized colors and locations
 * Creates a movable main raindrop that is the color steel blue. Can be controlled manually via the two seekbars
 * When the main raindrop touches another raindrop, it absorbs that raindrop. The main raindrop's color changes to be the
 * average of the two raindrops
 *
 * @author Sean Yang
 * @version B 1.4 2-18-25
 */

public class RainView extends SurfaceView {

    //Creates new Drop object that will be designated as the main raindrop
    public Drops mainDrops;
    //Creates new color steelBlue that is the default color of the main raindrop
    Paint steelBlue = new Paint();

    //Creates a new raindrops array that stores the position and color information of each raindrop
    //This will be used to track each raindrop
    Drops[] dropsArray = new Drops[12];

    //This stores the physical X, Y coordinates of the main raindrop
    float mainX;
    float mainY;

    public RainView(Context context, AttributeSet attrs) {
        //Ensures that raindrop runs properly and can be drawn
        super(context, attrs);
        setWillNotDraw(false);

        // Sets the RGB value for the color using RGB components for steel blue (70, 130, 180)
        this.steelBlue.setColor(Color.rgb(70, 130, 180));
        this.steelBlue.setStyle(Paint.Style.FILL);

        //Creates new RNG to randomly decide the position of the main raindrop
        Random rng = new Random();

        //Randomly determines the position of the main raindrop
        float ranX = rng.nextFloat() * 700.0f;
        float ranY = rng.nextFloat() * 700.0f;
        //Sets the coordinates to be that randomly selected value
        mainX = ranX;
        mainY = ranY;
        //Creates the main raindrop object.
        mainDrops = new Drops(ranX + 60, ranY + 60, 30, steelBlue);

        // Set the RGB components for the main raindrop
        mainDrops.setR(70);
        mainDrops.setG(130);
        mainDrops.setB(180);

        //RNG that selects value from 6-12 for the below array
        int ranAmount = rng.nextInt(6, 13);
        //Generates random array of raindrops. -1 to account for the extra main raindrop
        for (int x = 0; x < ranAmount - 1; x++) {

            //Creates randomly selected X, Y coordinates
            ranX = (rng.nextFloat() * 700.0f) + 60.0f;
            ranY = (rng.nextFloat() * 700.0f) + 60.0f;

            Paint tempPaint = new Paint();

            // Generate random RGB values (0-255)
            ///Got external help from Alexander Leah for this part of the assignment. He helped show me how to make a new Paint
            ///object using ints rather than hexadecmial. Helped immensely for calculating the average color for the collision mechanic
            int tempR = rng.nextInt(256);
            int tempG = rng.nextInt(256);
            int tempB = rng.nextInt(256);
            //Creates a new unique Paint object with those randomly selected RGB values
            tempPaint.setColor(Color.rgb(tempR, tempG, tempB));

            //Draws a new raindrop with random coordinates and a randomly generated color
            dropsArray[x] = new Drops(ranX, ranY, 30, tempPaint);
            //Stores the RGB color components within the drop for calculation
            dropsArray[x].setR(tempR);
            dropsArray[x].setG(tempG);
            dropsArray[x].setB(tempB);
        }


    }

    //Getter method that returns the information of the main raindrop
    public Drops getDrops() {
        return mainDrops;
    }

    @Override
    public void onDraw(Canvas paper) {

        //Draws every raindrop in the raindrops array
        for (int x = 0; x < dropsArray.length; x++) {

            //Only draws the raindrop if the position is alive (not null). If raindrop has been absorbed (null), do not draw it
            if (dropsArray[x] != null) {
                //Get the positional and color data from the array, then draws the circle with that data
                float tempX = dropsArray[x].getXPos();
                float tempY = dropsArray[x].getYPos();
                paper.drawCircle(tempX, tempY, 30, dropsArray[x].getColor());
            }

        }

        //Draws the default position of the main raindrop if it has not moved
        if (mainDrops.hasUpdated == false) {
            //This draws the main raindrop with the default position and color
            paper.drawCircle(mainX, mainY, 30, steelBlue);
        } else {
            //If the main raindrop has been moved, get the new position and redraw it

            // Retrieve the current RGB values from the main rain drop
            int MainR = mainDrops.getR();
            int MainG = mainDrops.getG();
            int MainB = mainDrops.getB();

            //Create a new Paint object using the RGB value
            Paint tempPaint = new Paint();
            tempPaint.setColor(Color.rgb(MainR, MainG, MainB));

            //Now redraw the main raindrop with the updated color and position information
            paper.drawCircle(mainDrops.getXPos(), mainDrops.getYPos(), 30, tempPaint);

            //Runs a new for loop that checks for collision
            for (int a = 0; a < dropsArray.length; a++) {
                //Checks to make sure the raindrop is alive, only runs if it is alive
                if (dropsArray[a] != null) {
                    //Absolute value function that checks to make sure a raindrop is within 45 pixels of another raindrop
                    if (Math.abs(mainDrops.getXPos() - dropsArray[a].getXPos()) <= 45 && Math.abs(mainDrops.getYPos() - dropsArray[a].getYPos()) <= 45) {
                        //If a collision occurs,

                        //Grabs the RGB value of the raindrop that was collided with
                        int tempR = dropsArray[a].getR();
                        int tempG = dropsArray[a].getG();
                        int tempB = dropsArray[a].getB();

                        //Compares the RGB values and creates a new average value
                        int tempMainR = (tempR + mainDrops.getR()) / 2;
                        int tempMainG = (tempG + mainDrops.getG()) / 2;
                        int tempMainB = (tempB + mainDrops.getB()) / 2;

                        //Set the RGB value of the main raindrop to be the calculated average
                        mainDrops.setR(tempMainR);
                        mainDrops.setG(tempMainG);
                        mainDrops.setB(tempMainB);

                        //The raindrop that was collided with is made null, so it will no longer be drawn
                        dropsArray[a] = null;


                    }
                }
            }

        }
    }

}





