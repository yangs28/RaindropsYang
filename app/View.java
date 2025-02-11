import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;


//@Author Sean Yang
//Version 2-10-25
public class View extends SurfaceView {

    Paint lightBlue = new Paint();


    public View(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        this.lightBlue.setColor(0xFFADD8E6);
        this.lightBlue.setStyle(Paint.Style.FILL);

    }

    @Override
    public void onDraw(Canvas paper) {
        paper.drawOval(800.0f, 400.0f, 850.0f, 420.0f, this.lightBlue);
    }

}

