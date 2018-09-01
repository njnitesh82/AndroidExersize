package learncode.nj.com.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout frame;
    Button pre,next;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for pager
        viewPager=findViewById(R.id.vewpager);

        //
        Pager p=new Pager(getSupportFragmentManager());

        p.addFragmment(first.newInstance());
        p.addFragmment(second.newInstance());

        viewPager.setAdapter(p);






        //this code is for fragment

       /* pre=findViewById(R.id.pre);
        next=findViewById(R.id.next);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        Fragment sec=first.newInstance();
        ft.replace(R.id.frame,sec);
        ft.commit();
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                Fragment sec=first.newInstance();
                ft.replace(R.id.frame,sec);
                ft.commit();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                Fragment sec=second.newInstance();
                ft.replace(R.id.frame,sec);
                ft.commit();
            }
        });*/

    }
}
