package up.edu.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Subclass of SurfaceView that draws raindrops with unique colors and random locations
 *
 * @author Sean Yang
 * @version 1.0 2-11-25
 */

public class View extends SurfaceView {

    //Creates 12 unique Paint instance variables so each raindrop has a unique color
    Paint lightBlue = new Paint();
    Paint lightGreen = new Paint();
    Paint coral = new Paint();
    Paint goldenRod = new Paint();
    Paint deepPink = new Paint();
    Paint mediumPurple = new Paint();
    Paint darkOrange = new Paint();
    Paint turquoise = new Paint();
    Paint oliveDrab = new Paint();
    Paint slateGray = new Paint();
    Paint fireBrick = new Paint();
    Paint steelBlue = new Paint();

    //Creates new colorPalette array for storing the Paint objects
    //Will cycle through this array in the for loop that creates new raindrops
    Paint[] colorPalette = new Paint[12];

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

        this.goldenRod.setColor(0xFFDAA520);
        this.goldenRod.setStyle(Paint.Style.FILL);

        this.deepPink.setColor(0xFFFF1493);
        this.deepPink.setStyle(Paint.Style.FILL);

        this.mediumPurple.setColor(0xFF9370DB);
        this.mediumPurple.setStyle(Paint.Style.FILL);

        this.darkOrange.setColor(0xFFFF8C00);
        this.darkOrange.setStyle(Paint.Style.FILL);

        this.turquoise.setColor(0xFF40E0D0);
        this.turquoise.setStyle(Paint.Style.FILL);

        this.oliveDrab.setColor(0xFF6B8E23);
        this.oliveDrab.setStyle(Paint.Style.FILL);

        this.slateGray.setColor(0xFF708090);
        this.slateGray.setStyle(Paint.Style.FILL);

        this.fireBrick.setColor(0xFFB22222);
        this.fireBrick.setStyle(Paint.Style.FILL);

        this.steelBlue.setColor(0xFF4682B4);
        this.steelBlue.setStyle(Paint.Style.FILL);

        //Initiates each position in the Paint array
        colorPalette[0] = lightBlue;
        colorPalette[1] = lightGreen;
        colorPalette[2] = coral;
        colorPalette[3] = goldenRod;
        colorPalette[4] = deepPink;
        colorPalette[5] = mediumPurple;
        colorPalette[6] = darkOrange;
        colorPalette[7] = turquoise;
        colorPalette[8] = oliveDrab;
        colorPalette[9] = slateGray;
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
        float ranX = rng.nextFloat() * 800;
        float ranY = rng.nextFloat() * 800;
        //Draws the raindrop with a width of 50 and height of 30, also with unique color
        paper.drawOval(ranX, ranY, ranX + 50, ranY + 30,  colorPalette[x]);
        }
    }

}
