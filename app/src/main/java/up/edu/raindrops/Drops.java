package up.edu.raindrops;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Custom class Drops that stores the information of a specific Raindrop
 * Stores position, radius, and the color of the object. Also stores RGB as 3 individual ints
 * Contains setter methods to update the RGB and position of the raindrop
 *
 * @author Sean Yang
 * @version Part B 1.4 2-18-25
 */
public class Drops {
    private float x;
    private float y;
    private float radius;
    private Paint color;
    private int r;
    private int g;
    private int b;
    boolean hasUpdated = false;

    //Default constructor, creates new raindrop with X, Y, radius and color
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

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }


    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }


}
