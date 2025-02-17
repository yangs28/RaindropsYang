package up.edu.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Subclass of SurfaceView that draws raindrops with unique colors and random locations
 * @author Sean Yang
 * @version 1.0 2-11-25
 */

public class View extends SurfaceView {

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

    Drops mainDrops;


    public View(Context context, AttributeSet attrs) {
        //Ensures that raindrop runs properly and can be drawn
        super(context, attrs);
        setWillNotDraw(false);

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
    }

    @Override
    public void onDraw(Canvas paper) {

        //Creates new Random to allow us to randomize values for quantity and location
        Random rng = new Random();
        //Creates randomized values for number of raindrops drawn
        int ranAmount = rng.nextInt(6, 13);

        for (int x = 0; x < ranAmount; x++) {
            //Creates randomized values for X and Y positions
            float ranX = rng.nextFloat() * 800.0f;
            float ranY = rng.nextFloat() * 800.0f;

            //Before a new raindrop is drawn, stores the information in the dropsArray
            dropsArray[x] = new Drops(ranX + 60, ranY + 60, 30, colorPalette[x]);

            //Draws the raindrop with a radius of 30, random location and also with unique color
            //X and Y values are adjusted so that the circles are not drawn out of bounds
            paper.drawCircle(ranX + 60, ranY + 60, 30, colorPalette[x]);
        }

        //The main raindrop is to be randomly decided by an RNG. Sets that as the mainDrop
        int randomDrop = rng.nextInt(dropsArray.length);
        mainDrops = dropsArray[randomDrop];

    }

}
