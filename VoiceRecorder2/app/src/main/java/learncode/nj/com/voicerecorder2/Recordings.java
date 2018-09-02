package learncode.nj.com.voicerecorder2;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.audiofx.EnvironmentalReverb;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;



public class Recordings extends Fragment {

    public static String TAG="MainActivity";
    ListView list;
    MediaPlayer mpl;


    public Recordings() {
    }
    public static Recordings newInstance(){
        Recordings recordings=new Recordings();
        return  recordings;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    @Override
    public void onStart() {
        super.onStart();
        mpl=new MediaPlayer();

        list=getActivity().findViewById(R.id.list);

        File f=new File(Environment.getExternalStorageDirectory(),"/njaudio/");
        File[] listfile=f.listFiles();
        String filename[]=new String[listfile.length];
        final String filepath[]=new String[listfile.length];
        for(int i=0;i<listfile.length;i++){
            filename[i]=listfile[i].getName();
            filepath[i]=listfile[i].getPath();
        }




        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,filename) ;

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: "+filepath[i]);
                if(mpl.isPlaying()){
                    mpl.stop();
                    mpl.release();
                    mpl=new MediaPlayer();
                }else {
                    try {
                        mpl.setDataSource(filepath[i]);
                        mpl.prepare();
                        mpl.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recordings,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onPause() {
        super.onPause();
        mpl=null;

    }
}
