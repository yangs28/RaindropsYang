package up.edu.raindrops;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;




/**
 * A MainActivity class that makes the Raindrops project run and manages
 * the interface
 *
 * @author Sean Yang
 * @version 1.0 2-11-25
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        RainView newView = this.findViewById(R.id.raindropsView);
        DropsManager newManager = new DropsManager(newView);


        SeekBar vertSeekBar = findViewById(R.id.verticalSeekBar);
        vertSeekBar.setProgress(newManager.getYPos());

        SeekBar horizontalSeekbar = findViewById(R.id.horizontalSeekBar);
        horizontalSeekbar.setProgress(newManager.getXPos());

        vertSeekBar.setOnSeekBarChangeListener(newManager);
        horizontalSeekbar.setOnSeekBarChangeListener(newManager);



    }
}