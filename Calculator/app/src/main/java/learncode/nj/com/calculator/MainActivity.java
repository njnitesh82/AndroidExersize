package learncode.nj.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
     double first, second, result;
     boolean addition=false,
             subtraction=false,
             multiplication=false,
             division=false;
    private String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //finding the view id of the buttons
        Button nine=findViewById(R.id.nine);
        Button eight=findViewById(R.id.eight);
        Button seven=findViewById(R.id.seven);
        Button six=findViewById(R.id.six);
        Button five=findViewById(R.id.five);
        Button four=findViewById(R.id.four);
        Button three=findViewById(R.id.three);
        Button two=findViewById(R.id.two);
        Button one=findViewById(R.id.one);
        Button zero=findViewById(R.id.zero);
        Button deci=findViewById(R.id.deci);
        Button del=findViewById(R.id.del);
        Button div=findViewById(R.id.div);
        Button mul=findViewById(R.id.mul);
        Button sub=findViewById(R.id.sub);
        Button add=findViewById(R.id.add);
        Button eq=findViewById(R.id.equal);

        final TextView tv=findViewById(R.id.tv);

        tv.setText("");


       nine.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            tv.append("9");
           }
       });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append("8");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append("7");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append("6");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append("5");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append("4");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append("3");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append("2");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append("1");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append("0");
            }
        });

        deci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.append(".");
            }
        });


        //operators


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    first=Double.valueOf(tv.getText().toString());
                    tv.setText(null);
                    addition=true;
                    subtraction=false;
                    multiplication=false;
                    division=false;
                }catch (Exception e){}


            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    first=Double.valueOf(tv.getText().toString());
                    tv.setText(null);
                    addition=false;
                    subtraction=true;
                    multiplication=false;
                    division=false;
                }catch (Exception e){}

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    first=Double.valueOf(tv.getText().toString());
                    tv.setText(null);
                    addition=false;
                    subtraction=false;
                    multiplication=true;
                    division=false;
                }catch (Exception e){}

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    first=Double.valueOf(tv.getText().toString());
                    tv.setText(null);
                    addition=false;
                    subtraction=false;
                    multiplication=false;
                    division=true;
                }catch (Exception r){}

            }
        });

        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG, "onClick: data "+tv.getText().toString());
            try {
                second = Double.valueOf(tv.getText().toString());
                if (addition) {
                    result = first + second;
                    tv.setText("" + result);
                } else if (subtraction) {
                    result = first - second;
                    tv.setText("" + result);
                } else if (multiplication) {
                    result = first * second;
                    tv.setText("" + result);

                } else if (division) {
                    result = first / second;
                    tv.setText("" + result);
                }
            }catch (Exception e){}



            }
        });



        //delete

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                String get=tv.getText().toString();
                tv.setText(get.substring(0,get.length()-1));}
                    catch (Exception e){

                  }
            }
        });

        del.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                tv.setText(null);
                return true;
            }
        });



}
}
