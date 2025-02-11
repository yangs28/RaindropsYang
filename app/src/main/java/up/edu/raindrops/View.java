package up.edu.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class View extends SurfaceView {

  Paint lightBlue = new Paint();

    public View(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        this.lightBlue.setColor(0xFF5D3Fd3);
        this.lightBlue.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas paper) {
        paper.drawOval(800.0f, 400.0f, 850.0f, 420.0f, this.lightBlue);
    }


}
