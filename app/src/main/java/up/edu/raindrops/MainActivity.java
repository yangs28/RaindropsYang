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
 * @version 1.4 2-18-25
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

        //Finds the surface view we made in the XML format
        RainView newView = this.findViewById(R.id.raindropsView);
        //Creates a new DropsManager that helps modify position and get all the information
        DropsManager newManager = new DropsManager(newView);
        //Finds the vertical seekbar. Sets the progress to be the Y position of the main raindrop
        SeekBar vertSeekBar = findViewById(R.id.verticalSeekBar);
        vertSeekBar.setProgress(newManager.getYPos());
        //Finds the horizontal seekbar. Sets the progress to be the X position of the main raindrop
        SeekBar horizontalSeekbar = findViewById(R.id.horizontalSeekBar);
        horizontalSeekbar.setProgress(newManager.getXPos());
        //Sets listeners on both the seekbars to the manager
        vertSeekBar.setOnSeekBarChangeListener(newManager);
        horizontalSeekbar.setOnSeekBarChangeListener(newManager);


    }
}