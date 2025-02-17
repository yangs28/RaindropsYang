package up.edu.raindrops;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Custom class Drops that stores the information of a specific Raindrop
 * Stores position, radius, and the color of the object
 * @author Sean Yang
 * @version 1.0 2-11-25
 */
public class Drops {
    private float x;
    private float y;
    private float radius;
    private Paint color;

    public Drops(float x, float y, float radius, Paint color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
}
