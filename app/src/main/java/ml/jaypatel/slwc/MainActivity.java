package ml.jaypatel.slwc;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.AtomicFile;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Bitmap img;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create flow for downling the 30 images per day from pexels api using our key.
        // WIll have to get permission from Pexels paid to use thier premium image download feature ***
        // using the free api key from pexels to test purpose only


        String uri =  Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/" + "photo-1499084732479-de2c02d45fcc.jpg";
        Log.d("uri",uri);
        WallpaperManager wpm = WallpaperManager.getInstance(getApplicationContext());
        InputStream ins = null;
        try {
            ins = new URL("absolute/path/of/image").openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            wpm.setStream(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


