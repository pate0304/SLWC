package ml.jaypatel.slwc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create flow for downling the 30 images per day from pexels api using our key.
        // WIll have to get permission from Pexels paid to use thier premium image download feature ***
        // using the free api key from pexels to test purpose only
        WallpaperManager.getInstance(this).setBitmap();
    }
}
