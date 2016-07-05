package com.kony.scanditscanner2;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.codecorp.CortexDecoderLibrary;

import static com.codecorp.internal.Debug.debug;

public class CortexScanner extends Activity //implements CortexDecoderLibrary.CortexDecoderLibraryCallback
{
    CortexDecoderLibrary mCortexDecoderLibrary;
    View mCameraPreview;
    FrameLayout mCameraFrame;
    private Handler mMainHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cortex_scanner);
        mCortexDecoderLibrary = CortexDecoderLibrary.sharedObject(this);
        //mCortexDecoderLibrary.setCallback(new );
        mCameraPreview = mCortexDecoderLibrary.getCameraPreview();
        mCameraFrame = (FrameLayout) findViewById(R.id.mFrameLayout);
        mCameraFrame.removeAllViews();
        mCameraFrame.addView(mCameraPreview, 0);
        mMainHandler = new Handler(Looper.getMainLooper());

    }
    public void startScanning(View view){
        startScanning();
    }
    void startScanning() {
       // debug(TAG, "startScanning()");
       // mCrosshairs.setVisibility(View.VISIBLE);
        //mTap.setVisibility(View.INVISIBLE);
        mCameraFrame.setOnClickListener(null);
        // This can take a while if we need to open the camera, so post
        // it after the UI update.
        mMainHandler.post(new Runnable() {
            @Override
            public void run() {
                mCortexDecoderLibrary.startCameraPreview();
                mCortexDecoderLibrary.startDecoding();
            }
        });
    }
    void stopScanning() {
       // debug(TAG, "stopScanning()");
        //mCrosshairs.setVisibility(View.INVISIBLE);
        //mTap.setVisibility(View.VISIBLE);
        mCortexDecoderLibrary.stopDecoding();
       // mCameraFrame.setOnClickListener(tapListener);
        mCortexDecoderLibrary.stopCameraPreview();
    }


  /*  @Override
    public void receivedDecodedData(String s, CortexDecoderLibrary.SymbologyType symbologyType) {
        Toast.makeText(getApplication(), s, Toast.LENGTH_SHORT).show();
        stopScanning();

    }*/

    @Override
    public void onResume() {
        super.onResume();
        startScanning();
    }
}
