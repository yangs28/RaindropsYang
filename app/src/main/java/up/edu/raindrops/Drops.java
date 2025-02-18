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

    public Drops() {

    }

    public Drops(float _x, float _y, float _radius, Paint _color) {
        x = _x;
        y = _y;
        radius = _radius;
        color = _color;
    }



    public float getXPos() {
        return x;
    }

    public float getYPos() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public Paint getColor() {
        return color;
    }

}
