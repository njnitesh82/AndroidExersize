package learncode.nj.com.voicerecorder2;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class Recoder extends Fragment {
     public MediaRecorder mediaRecorder;
     String path;
     Button rec, stop, play;
     MediaPlayer mp;
     MediaRecorder recorder;


    public static String TAG="MainActivity";


    public Recoder() {

    }


    public static Recoder newInstance() {
        Recoder fragment = new Recoder();

        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    rec=getActivity().findViewById(R.id.rec);
    stop=getActivity().findViewById(R.id.stop);
    play=getActivity().findViewById(R.id.play);

    final File dir= new File(Environment.getExternalStorageDirectory(),"/njaudio/");
    if(!dir.exists())
    {
        dir.mkdir();
    }

    stop.setEnabled(false);
    play.setEnabled(false);

    rec.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            path=dir.getAbsolutePath()+"/"+ UUID.randomUUID()+".mp3";
            setupmediarec(path);
            try {
                mediaRecorder.prepare();
                mediaRecorder.start();
                rec.setEnabled(false);
                stop.setEnabled(true);
                play.setEnabled(true);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    });



    stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rec.setEnabled(true);
                stop.setEnabled(true);
                play.setEnabled(true);
                if(mediaRecorder!=null){
                    mediaRecorder.stop();
                    mediaRecorder.release();
                }
                if(mp!=null){
                    mp.stop();
                    mp.release();
                }
            }
        });





        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             mp=new MediaPlayer();
                try {

                    mp.setDataSource(path);
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recoder, container, false);
    }

    public void setupmediarec(String p){
        mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(p);
    }

}
