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
 *
 * @author Sean Yang
 * @version B 1.1 2-17-25
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

    int eat = 0;
    Paint newColor;

    public RainView(Context context, AttributeSet attrs) {
        //Ensures that raindrop runs properly and can be drawn
        super(context, attrs);
        setWillNotDraw(false);

        //Creates new RNG to randomly decide the position of the main raindrop
        Random rng = new Random();

        float ranX = rng.nextFloat() * 700.0f;
        float ranY = rng.nextFloat() * 700.0f;
        mainX = ranX;
        mainY = ranY;
        //Sets the main raindrop to be equal to those coordinates
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


    }

    //Getter method that returns the information of the main raindrop
    public Drops getDrops() {
        return mainDrops;
    }

    @Override
    public void onDraw(Canvas paper) {

        //Creates new Random to allow us to randomize values for quantity and location
        Random rng = new Random();
        //Creates randomized values for number of raindrops drawn
        int ranAmount = rng.nextInt(6, 13);

        for (int x = 0; x < ranAmount - 1; x++) {
            //Creates randomized values for X and Y positions

            if (mainDrops.hasUpdated == false) {
                Log.i("drops", "hasUpdated is False!");


                float ranX = (rng.nextFloat() * 700.0f) + 60.0f;
                float ranY = (rng.nextFloat() * 700.0f) + 60.0f;

                Log.i("drops", "Create an old drop here!" + ranX + ranY);


                //Before a new raindrop is drawn, stores the information in the dropsArray
                dropsArray[x] = new Drops(ranX, ranY, 30, colorPalette[x]);

                //Draws the raindrop with a radius of 30, random location and also with unique color
                //X and Y values are adjusted so that the circles are not drawn out of bounds
                paper.drawCircle(ranX + 60, ranY + 60, 30, colorPalette[x]);
            } else {
                Log.i("drops", "hasUpdated is True!");

                for (int z = 0; z < dropsArray.length; z++) {


                        if (dropsArray[z] != null) {

                        if (Math.abs(mainDrops.getXPos() - dropsArray[z].getXPos()) <= 10 == false
                                && Math.abs(mainDrops.getYPos() - dropsArray[z].getYPos()) <= 10 == false) {
                            float tempX = dropsArray[z].getXPos();
                            float tempY = dropsArray[z].getYPos();
                            Paint tempColor = dropsArray[z].getColor();
                            Log.i("drops", "Create a new drop here!" + tempX + tempY);
                            paper.drawCircle(tempX, tempY, 30, colorPalette[z]);
                        }

                    }
                }

            }

            if (mainDrops.hasUpdated == false) {
                //This draws the main raindrop with the stored positional values
                paper.drawCircle(mainX, mainY, 30, colorPalette[11]);
            } else {

                paper.drawCircle(mainDrops.getXPos(), mainDrops.getYPos(), 30, colorPalette[11]);

                for (int a = 0; a < dropsArray.length - 1; a++) {
                    if (dropsArray[a] != null) {
                        if (Math.abs(mainDrops.getXPos() - dropsArray[a].getXPos()) <= 10 && Math.abs(mainDrops.getYPos() - dropsArray[a].getYPos()) <= 10
                        ) {

                            paper.drawCircle(mainDrops.getXPos(), mainDrops.getYPos(), 30 + eat, colorPalette[11]);

                            Log.i("drops", "Touched! X");
                        }
                    }
                }

            }
        }

    }


}


