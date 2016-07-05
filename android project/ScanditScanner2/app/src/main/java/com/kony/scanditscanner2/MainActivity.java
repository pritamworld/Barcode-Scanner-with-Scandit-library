package com.kony.scanditscanner2;

import android.app.Activity;
import android.os.Bundle;

import com.konylabs.vm.Function;
import com.mirasense.scanditsdk.ScanditSDKAutoAdjustingBarcodePicker;
import com.mirasense.scanditsdk.interfaces.ScanditSDK;
import com.mirasense.scanditsdk.interfaces.ScanditSDKListener;

public class MainActivity extends Activity implements ScanditSDKListener {
    ScanditSDKAutoAdjustingBarcodePicker picker;
    public static String key;
    public static Function callback;
    String[] data = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_main);
        startScanCode(key);
    }

    public void startScanCode(String key) {
        if (picker == null) {
            picker = new ScanditSDKAutoAdjustingBarcodePicker(MainActivity.this,
                    key, ScanditSDK.CAMERA_FACING_BACK);
            setContentView(picker);
            picker.getOverlayView().addListener(this);
            picker.startScanning();
        } else {
            setContentView(picker);
            picker.startScanning();
        }
    }

    /*
    * Callback method for the scanning process
    * */
    @Override
    public void didCancel() {
        data[0] = null;
        try {
            callback.executeAsync(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * Callback method for the scanning process
    * */
    @Override
    public void didScanBarcode(String s, String s1) {
        data[0] = s;
        data[1] = s1;
        try {
            callback.executeAsync(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //callback.execute(data);
        picker.stopScanning();
        finish();
    }

    /*
    * Callback method for the scanning process
    * */
    @Override
    public void didManualSearch(String s) {
        data[0] = s;
        try {
            callback.executeAsync(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
