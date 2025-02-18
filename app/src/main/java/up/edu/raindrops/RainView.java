package up.edu.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Subclass of SurfaceView that draws raindrops with unique colors and random locations
 * Creates a movable main raindrop that is the color steel blue. Can be controlled manually via the two seekbars
 * When the main raindrop touches another raindrop, it absorbs that raindrop
 *
 * @author Sean Yang
 * @version B 1.2 2-18-25
 */

public class RainView extends SurfaceView {

    public Drops mainDrops;


    //Creates 12 unique Paint instance variables so each raindrop has a unique color
    Paint lightBlue = new Paint();
    Paint lightGreen = new Paint();
    Paint coral = new Paint();
    Paint burntWood = new Paint();
    Paint navyBlue = new Paint();
    Paint mediumPurple = new Paint();
    Paint darkOrange = new Paint();
    Paint turquoise = new Paint();
    Paint oliveDrab = new Paint();
    Paint crimson = new Paint();
    Paint fireBrick = new Paint();
    Paint steelBlue = new Paint();

    //Creates new colorPalette array for storing the Paint objects
    //Will cycle through this array in the for loop that creates new raindrops
    Paint[] colorPalette = new Paint[12];

    //Creates a new raindrops array that stores the position and color information of each raindrop
    //This will be used to track each raindrop
    Drops[] dropsArray = new Drops[12];

    //This stores the physical X, Y coordinates of the main raindrop
    float mainX;
    float mainY;

    Paint newColor;

    public RainView(Context context, AttributeSet attrs) {
        //Ensures that raindrop runs properly and can be drawn
        super(context, attrs);
        setWillNotDraw(false);

        //Creates new RNG to randomly decide the position of the main raindrop
        Random rng = new Random();

        //Randomly determines the position of the main raindrop
        float ranX = rng.nextFloat() * 700.0f;
        float ranY = rng.nextFloat() * 700.0f;
        //Sets the coordinates to be that randomly selected value
        mainX = ranX;
        mainY = ranY;
        //Color of the main raindrop will always be set to the last color in the colorPalette array
        mainDrops = new Drops(ranX + 60, ranY + 60, 30, colorPalette[11]);


        //Sets the color for every Paint object created previously
        this.lightBlue.setColor(0xFFADD8E6);
        this.lightBlue.setStyle(Paint.Style.FILL);

        this.lightGreen.setColor(0xFF90EE90);
        this.lightGreen.setStyle(Paint.Style.FILL);

        this.coral.setColor(0xFFFF7F50);
        this.coral.setStyle(Paint.Style.FILL);

        this.burntWood.setColor(0xFF8A4b08);
        this.burntWood.setStyle(Paint.Style.FILL);

        this.navyBlue.setColor(0xFF0A1F44);
        this.navyBlue.setStyle(Paint.Style.FILL);

        this.mediumPurple.setColor(0xFF9370DB);
        this.mediumPurple.setStyle(Paint.Style.FILL);

        this.darkOrange.setColor(0xFFFF8C00);
        this.darkOrange.setStyle(Paint.Style.FILL);

        this.turquoise.setColor(0xFF40E0D0);
        this.turquoise.setStyle(Paint.Style.FILL);

        this.oliveDrab.setColor(0xFF6B8E23);
        this.oliveDrab.setStyle(Paint.Style.FILL);

        this.crimson.setColor(0xFFDC143C);
        this.crimson.setStyle(Paint.Style.FILL);

        this.fireBrick.setColor(0xFFB22222);
        this.fireBrick.setStyle(Paint.Style.FILL);

        this.steelBlue.setColor(0xFF4682B4);
        this.steelBlue.setStyle(Paint.Style.FILL);

        //Initiates each position in the Paint array
        colorPalette[0] = lightBlue;
        colorPalette[1] = lightGreen;
        colorPalette[2] = coral;
        colorPalette[3] = burntWood;
        colorPalette[4] = navyBlue;
        colorPalette[5] = mediumPurple;
        colorPalette[6] = darkOrange;
        colorPalette[7] = turquoise;
        colorPalette[8] = oliveDrab;
        colorPalette[9] = crimson;
        colorPalette[10] = fireBrick;
        colorPalette[11] = steelBlue;

        //Creates a random array of raindrops between values 6-12
        int ranAmount = rng.nextInt(6, 13);
        //Generates random array of raindrops. -1 to account for the extra main raindrop
        for (int x = 0; x < ranAmount - 1; x++) {

            //Creates randomly selected X, Y coordinates
            ranX = (rng.nextFloat() * 700.0f) + 60.0f;
            ranY = (rng.nextFloat() * 700.0f) + 60.0f;
            Log.i("drops", "Create an old drop here!" + ranX + ranY);
            //Stores all of those values in the raindrops array
            //Before a new raindrop is drawn, stores the information in the dropsArray
            dropsArray[x] = new Drops(ranX, ranY, 30, colorPalette[x]);


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
                Paint tempColor = dropsArray[x].getColor();
                paper.drawCircle(tempX, tempY, 30, colorPalette[x]);
            }

        }

        //Draws the default position of the main raindrop if it has not moved
        if (mainDrops.hasUpdated == false) {
            //This draws the main raindrop with the stored positional values
            paper.drawCircle(mainX, mainY, 30, colorPalette[11]);
        }
        else {
            //If the main raindrop has been moved, get the new position and redraw it
            paper.drawCircle(mainDrops.getXPos(), mainDrops.getYPos(), 30, colorPalette[11]);

            //Runs a new for loop that checks for collision
            for (int a = 0; a < dropsArray.length; a++) {
                //Checks to make sure the raindrop is alive, only runs if it is alive
                if (dropsArray[a] != null) {
                    //Absolute value function that checks to make sure a raindrop is within 45 pixels of another raindrop
                    if (Math.abs(mainDrops.getXPos() - dropsArray[a].getXPos()) <= 45 && Math.abs(mainDrops.getYPos() - dropsArray[a].getYPos()) <= 45
                    ) {
                        //If a collision is detected, that raindrop is killed (made null). Raindrop will no longer be drawn
                        dropsArray[a] = null;
                    }
                }
            }

        }
    }

}





