package ml.jaypatel.slwc;

import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;


/**
 * // Create flow for downling the 30 images per day from pexels api using our key.
 * // WIll have to get permission from Pexels paid to use thier premium image download feature ***
 * // using the free api key from pexels to test purpose only
 */
public class MainActivity extends AppCompatActivity {

    WallpaperManager wpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INITIALIZE RECEIVER
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver mReceiver = new Device_Screen_Off();
        registerReceiver(mReceiver, filter);
        //default CONFIG FOR LIB


        // DON'T COPY THIS CODE TO YOUR PROJECT! This is just example of ALL options using.
// See the sample project how to use ImageLoader correctly.
        File cacheDir = StorageUtils.getCacheDirectory(this);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
//                .memoryCacheExtraOptions(1080, 1980) // default = device screen dimensions
//                .diskCacheExtraOptions(1080, 1980, null)
//                .taskExecutor("")
//		.taskExecutorForCachedImages("")
                .threadPoolSize(3) // default
                .threadPriority(Thread.NORM_PRIORITY - 4) // default super high for lockscreen unlock lock
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
//                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
//                .memoryCacheSize(2 * 1024 * 1024)
//                .memoryCacheSizePercentage(13) // default
//                .diskCache(new UnlimitedDiskCache(cacheDir)) // default
//                .diskCacheSize(50 * 1024 * 1024)
//                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(this)) // default
                .imageDecoder(new BaseImageDecoder(true)) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(config);
        //Loading Image with ImageLoader Lib
        ImageLoader imageLoader = ImageLoader.getInstance(); // Get singleton instance


        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(false)  // default
//                .delayBeforeLoading(1000)
                .cacheInMemory(false) // default
                .cacheOnDisk(false) // default
                .considerExifParams(false) // default
//                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
//                .decodingOptions(...)
                .displayer(new SimpleBitmapDisplayer()) // default
                .handler(new Handler()) // default
                .build();

        //WPM instance
        wpm = WallpaperManager.getInstance(this);


        //// Load image, decode it to Bitmap and return Bitmap synchronously
        // Load image, decode it to Bitmap and return Bitmap to callback
        ImageSize targetSize = new ImageSize(1080, 1920); // result Bitmap will be fit to this size
        imageLoader.loadImage("file:///mnt/sdcard/DCIM/Restored/20170722_211307-01.jpeg", targetSize, options, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                // Do whatever you want with Bitmap
                try {

                    wpm.setBitmap(loadedImage);
                    Toast.makeText(getApplicationContext(), "success!", Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }


}


