package learncode.nj.com.tictactoe;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button[][] bt=new Button[3][3];
    TextView  pl1,pl2;
    Button reset;
    private String TAG="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<3;i++){
            for (int j=0; j<3;j++){
                String id ="bt_"+i+j;

                int resid= getResources().getIdentifier(id,"id",getPackageName());
                bt[i][j]=findViewById(resid);
                bt[i][j].setOnClickListener(clickListener);
            }
        }
        pl1=findViewById(R.id.player1);
        pl2=findViewById(R.id.player2);
        reset=findViewById(R.id.reset);
        reset.setOnClickListener(clickListener);
    }









    int click=0;
    boolean iscross=false;
    //String tic="X";
    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (click != 9) {
                switch (view.getId()) {
                    case R.id.bt_00:
                        buttonclcick(view,iscross);
                        break;
                    case R.id.bt_01:
                        buttonclcick(view,iscross);
                        break;
                    case R.id.bt_02:
                        buttonclcick(view,iscross);
                        break;
                    case R.id.bt_10:
                        buttonclcick(view,iscross);
                        break;
                    case R.id.bt_11:
                        buttonclcick(view,iscross);
                        break;
                    case R.id.bt_12:
                        buttonclcick(view,iscross);
                        break;
                    case R.id.bt_20:
                        buttonclcick(view,iscross);
                        break;
                    case R.id.bt_21:
                        buttonclcick(view,iscross);
                        break;
                    case R.id.bt_22:
                        buttonclcick(view,iscross);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "oppsss...", Toast.LENGTH_SHORT).show();
                }
                click++;

                if(click==9){
                    Toast.makeText(MainActivity.this, "checking result", Toast.LENGTH_SHORT).show();

                    checkResult();
                }
                    //toggling the player
                if(iscross){
                    iscross=false;
                }else{
                    iscross=true;
                }
            }
            if(view.getId()==R.id.reset){
                reset();
            }

        }
    };

    public void buttonclcick(View v,boolean state){
        Button b=(Button)v;
        if(!state){
        b.setText("X");}else{
            b.setText("O");
        }
    }

    public void reset(){
        for(int i=0;i<3;i++){
            for (int j=0; j<3;j++){

                bt[i][j].setText(null);
                pl1.setText("Player 1   : 0");
                pl2.setText("Player 2   : 0");

            }
            click=0;
            iscross=false;
        }
    }


    public void checkResult(){
        int zero=0;
        int cross=0;
        String text[][]=new String[3][3];
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                text[i][j] = bt[i][j].getText().toString();
                //Toast.makeText(this, "" + text[i][j], Toast.LENGTH_SHORT).show();
                Log.d(TAG, "checkResult: " + text[i][j]);

            }
        }


            for(int k=0;k<3;k++) {
                //for row
                if((text[k][0].equalsIgnoreCase(text[k][1]))   && (text[k][0].equalsIgnoreCase(text[k][2]))){
                    if(text[k][0].equalsIgnoreCase("X")){
                        zero++;
                        pl1.setText("Player 1   : 1");
                    }else{
                        pl2.setText("Player 2   : 1");
                        cross++;
                    }
                    break;
                }



            }
            for(int k=0;k<3;k++) {
                //for row
                if((text[0][k].equalsIgnoreCase(text[1][k]))   && (text[0][k].equalsIgnoreCase(text[2][k]))){
                    if(text[0][k].equalsIgnoreCase("X")){
                        zero++;
                        pl1.setText("Player 1   : 1");
                    }else{
                        pl2.setText("Player 2   : 1");
                        cross++;
                    }
                    break;
                }



            }


            //daigonal test
            if((text[0][0].equalsIgnoreCase(text[1][1])) && (text[0][0].equalsIgnoreCase(text[2][2]))){
                if(text[0][0].equalsIgnoreCase("X")){
                    zero++;
                    pl1.setText("Player 1   : 1");
                }else{
                    pl2.setText("Player 2   : 1");
                    cross++;
                }
            }

            if((text[1][1].equalsIgnoreCase(text[0][1])) && (text[1][1].equalsIgnoreCase(text[2][0]))){
                if(text[1][1].equalsIgnoreCase("X")){
                    zero++;
                    pl1.setText("Player 1   : 1");
                }else{
                    pl2.setText("Player 2   : 1");
                    cross++;
                }
            }



        }

}
