/*
*Callback function for scanner.
*/
function onScanComplete(result){
  kony.print(JSON.stringify(result));
 // frmHome.lblScanedText.text=JSON.stringify(result);
  frmHome.lblScanedText.text=result;
 // alert(JSON.stringify(result));
}

/*
*Function calls the method in the FFI which indirectly calls the method startScanCode() in the .aar file
*/
function startScan(){
  
scanditBarcodeScanner.startScanning(/**String*/ prop.key,/**Function*/ onScanComplete);

}