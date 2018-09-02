package learncode.nj.com.voicerecorder2;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
   android.support.v7.widget.Toolbar toolbar;
   ViewPager viewPager;
   Pager pager;
   TabLayout tabLayout;
   boolean isReady=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitleMarginStart(56);
        //toolbar.setLogo(R.drawable.ic_launcher_background);
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        viewPager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tabbar);
        setSupportActionBar(toolbar);






        //permission check



        pager=new Pager(getSupportFragmentManager());
        pager.addFragment(Recoder.newInstance(),"Recorder");
        pager.addFragment(Recordings.newInstance(),"Recordings");
        viewPager.setAdapter(pager);
        tabLayout.setupWithViewPager(viewPager);

        if(!checkpermission()){
            reuestPermission();
        }else{
            Toast.makeText(this, "good to go", Toast.LENGTH_SHORT).show();
        }







    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       if (requestCode==1000){

           if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED
                   && grantResults[1]==PackageManager.PERMISSION_GRANTED){
               Toast.makeText(this, "permision granted", Toast.LENGTH_SHORT).show();
           }else{
               finish();
           }

       }
    }


    boolean  checkpermission(){
        boolean qw=false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
           qw= checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED;
           qw &=checkSelfPermission(Manifest.permission.RECORD_AUDIO)==PackageManager.PERMISSION_GRANTED;
        }
        return qw;
    }

    public void reuestPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.RECORD_AUDIO
            },1000);
        }
    }



}
