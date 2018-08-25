package flashlight.learncode.nj.com.flashlight;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivity";
    private static final int REQUEST_CODE =10002 ;
    private static boolean permission=false;
    private CameraManager cameraManager;
    private static String camera_id;
    private Camera camera;
    private Camera.Parameters parameter;
    private boolean isReady=false;
    private boolean isMars=false;
    private boolean state=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //first we will check the device sdk
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
            isMars=true;
            if(hasFlash()){
                if(checkPermission()){
                    Log.d(TAG, "onCreate: checking selfpermission");
                    cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
                    try {
                        Log.d(TAG, "onCreate: getting camera id");
                        camera_id=cameraManager.getCameraIdList()[0];
                        isReady=true;

                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                Toast.makeText(this, "your device do not support the flashlight", Toast.LENGTH_SHORT).show();
            }


        }else{

            //if device below the marshmellow then
            if(hasFlash()){
              camera=Camera.open();
              parameter=camera.getParameters();
              isReady=true;
            }else{
                Toast.makeText(this, "your device do not support the flashlight", Toast.LENGTH_SHORT).show();
            }
        }




      //finding the view by it's id
        final Button toggle=findViewById(R.id.toggle);
        final ImageView image=findViewById(R.id.image);


       toggle.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.M)
           @Override
           public void onClick(View view) {
               YoYo.with(Techniques.RubberBand).playOn(toggle);
                       if (isMars) {
                                   if (!state) {
                                       //button in the on state
                                       try {
                                           Log.d(TAG, "onClick: torch on");
                                           cameraManager.setTorchMode(camera_id,false);
                                           state=true;
                                           image.setImageResource(R.drawable.nboff);
                                           toggle.setText("ON");
                                       } catch (CameraAccessException e) {
                                           e.printStackTrace();
                                       }

                                   } else {
                                       try {
                                           Log.d(TAG, "onClick: torch off");
                                           cameraManager.setTorchMode(camera_id,true);
                                           state=false;
                                           image.setImageResource(R.drawable.nbon);
                                           toggle.setText("OFF");
                                       } catch (CameraAccessException e) {
                                           e.printStackTrace();
                                       }
                                       //button in the off state
                                   }
                       } else {
                              if(!state){
                                  parameter.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
                                  state=true;
                                  camera.setParameters(parameter);
                                  camera.startPreview();
                                  image.setImageResource(R.drawable.nbon);
                                  toggle.setText("ON");
                              }else{
                                  parameter.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                                  state=false;camera.setParameters(parameter);
                                  camera.stopPreview();
                                  image.setImageResource(R.drawable.nboff);
                                  toggle.setText("OFF");
                              }

                       }
           }
       });




    }








    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            }
            else{
                System.exit(0);
            }
        }
    }


    public boolean hasFlash(){

     if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
         return true;
     }
        return false;
    }

    public boolean checkPermission(){
         //checking the device sdk is mashmellow or not
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                //requesting for permission runtime permission
               String [] permissions_f={Manifest.permission.CAMERA};
               requestPermissions(permissions_f,REQUEST_CODE);
            }
        }
        return false;
    }






    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
