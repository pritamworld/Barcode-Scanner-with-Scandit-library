package com.kony.scanditScanner;

import com.kony.cortexscan.cortexscanner.CortexScan;

import com.konylabs.android.KonyMain;
import com.konylabs.vm.Function;

import android.content.Intent;

public class ScanditScannerFFI {

	//static  intent;
	public static void startScan(String key,Function fun){
		//obj=new MainActivity();
	//	MainActivity.key=key;
	//	MainActivity.callback=fun;
	/*	if(intent==null)
		 {*/
			//intent =new Intent(KonyMain.getActContext(), MainActivity.class);
			//intent =new Intent(KonyMain.getActContext(), HelloWorld.class);
	//	Intent intent =new Intent(KonyMain.getActContext(), CortexScanner.class);
		// }
	//	KonyMain.getActContext().startActivity(intent);
	}
	public static void launchHello(){
		Intent intent =new Intent(KonyMain.getActContext(), CortexScan.class);
		KonyMain.getActContext().startActivity(intent);
	}
}
