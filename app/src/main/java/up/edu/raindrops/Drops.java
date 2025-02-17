package up.edu.raindrops;

import android.graphics.Color;
import android.graphics.Paint;

public class Drops {
    private int x;
    private int y;
    private int radius;
    private Paint color;

    public Drops(int x, int y, int radius, Paint color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
}
