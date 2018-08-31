package learncode.nj.com.contact;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
   ImageView im;
   LinearLayout Ltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        im=findViewById(R.id.Lim);
        Ltext=findViewById(R.id.Ltext);


        YoYo.with(Techniques.FadeIn).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
               YoYo.with(Techniques.FadeIn).duration(1000).withListener(new Animator.AnimatorListener() {
                   @Override
                   public void onAnimationStart(Animator animator) {

                   }

                   @Override
                   public void onAnimationEnd(Animator animator) {
                     startActivity(new Intent(MainActivity.this,list.class));
                   }

                   @Override
                   public void onAnimationCancel(Animator animator) {

                   }

                   @Override
                   public void onAnimationRepeat(Animator animator) {

                   }
               }).playOn(Ltext);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        }).playOn(im);


    }
}
