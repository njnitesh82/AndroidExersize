package learncode.nj.com.truthdare;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] truthq={
            "What is your Recent lies?",
            "What are you most self-conscious about?",
            "What is the most embarrassing picture of you?",
            "What would you do if you were the opposite sex for a month?",
            "What is the most expensive thing you have stolen?",
            "What is the most childish thing you still do?",
            "Have you ever let someone take the blame for something you did?",
    "What do most of your friends think about you that is totally untrue?",
    "Who here would you most like to make out with?",
    "Have you ever cheated or been cheated on?",
    "What lie have you told that hurt someone?",
    "What is the meanest you have been to someone that didn’t deserve it?",
    "What is something that people think you would never do but you have?",
    "What was the worst encounter you had with a police officer?",
    "Tell me about your most awkward date.",
    "What is the silliest thing you have an emotional attachment to?",
    "What is your deepest darkest fear?",
    "Tell me about your first kiss.",
    "Where is the strangest place you have peed?",
    "Who is the person you most regret kissing?",
    "Have you ever crapped your pants since you were a child?",
    "What is the most embarrassing thing your parents have caught you doing?",
    "What secret about yourself did you tell someone in confidence and then they told a lot of other people?",
    "When was the most inappropriate time you farted?",
    "What is the scariest dream you have ever had?",
    "What is the most embarrassing thing in your room?",
    "Why did you break up with your last boyfriend or girlfriend?",
    "What is the stupidest thing you have ever done?",
    "When was the last time you peed in bed?",
    "Who is the sexiest person here?",
    "What is the grossest thing that has come out of your body?",
    "What terrible thing have you done that you lied to cover up?",
    "Who have you loved but they didn’t love you back?",
    "What is something that you have never told anyone?",
    "What is the most disgusting habit you have?",
    "What was the cruelest joke you played on someone?",
    "What is the most embarrassing thing you have put up on social media?",
    "What bad thing have you done that no one else found out about?",
    "What was the most awkward romantic encounter you have had?",
    "What is the grossest thing you have had in your mouth?",
    "Tell me about the last time someone unexpectedly walked in on you while you were naked.",
    "What is the most embarrassing nickname you have ever had?",
    "What is the biggest lie you have ever told?",
    "What is the most embarrassing photo you have on your phone?",
    "Describe your most recent romantic encounter.",
    "What is the weirdest thing you have done for a boyfriend or girlfriend?",
    "Who here has the nicest butt?",
    "What is your biggest regret?",
    "Is it true that you (whatever you or the group suspects they do / did)?",
    "When was the last time you picked your nose without a tissue?",
    "What do you really hope your parents never find out about?",
    "Tell us your most embarrassing vomit story.",
    "Tell me something you don’t want me to know.",
    "Have you ever made out with someone here?",
    "What is the airspeed velocity of an unladen swallow?",
    "What have you done that people here would judge you most for doing?",
    "What would you do if you were the opposite gender for a day?",
    "Who is your crush?"
    };

    String[] Dare ={
        "For a guy, put on makeup. For a girl, wash off your make up.",

        "Dance with no music for 1 minute.",

        "Try to drink a glass water while standing on your hands.",

        "Let the group pose you in an embarrassing position and take a picture.",

        "Curse like sailor for 20 seconds straight.",

        "Do four cartwheels in row.",

        "Play a song on by slapping your butt cheeks till someone guesses the song.",

        "Give someone your phone and let them send one text to anyone in your contacts.",

        "Depict a human life through interpretive dance.",

        "Lick the floor.",

        "Drink a small cup of a concoction that the group makes. (Don’t make anything that might cause bodily harm. No visits to the emergency room.).",

        "Write something embarrassing somewhere on your body (that can be hidden with clothing) with a permanent marker.",

        "Let someone shave part of your body.",

        "Eat five spoonfuls of a condiment.",

        "Let the group give you a new hairstyle.",

        "Make every person in the group smile, keep going until everyone has cracked a smiled.",

        "Sniff the armpits of everyone in the room.",

        "Let the person to your left draw on your face with a pen.",

        "Make up a 30 second opera about a person or people in the group and perform it.",

        "Serenade the person to your right.",

        "Talk in an accent for the next 3 rounds.",

        "Beg and plead the person to your right not to leave you for that other boy or girl. Weeping, gnashing of teeth, and wailing is encouraged.",

        "Attempt to break dance for 30 seconds.",

        "Kiss the person to your left.",

        "Do the worm.",

        "Do push ups until you can’t do any more, wait 5 seconds, and then do one more.",

        "Sell a piece trash to someone in the group. Use your best salesmanship.",

        "Let the group look through your phone for 2 minutes.",

        "Attempt to do a magic trick.",

        "Switch clothes with someone of the opposite sex in the group for three rounds.",

        "Imitate a celebrity every time you talk for three minutes.",

        "Try to juggle 2 or 3 items of the group’s choosing.",

        "Stick your arm into the trash can past your elbow.",

        "Walk on your hands from one side of the room to the other. You can ask someone to hold your legs if necessary.",

        "Gargle something that shouldn’t be gargled, but won’t hurt you.",

        "Get slapped on the face by the person of your choosing.",

        "Grab a trash can and make a hoop with your hands above the trash can. Have other members of the group try to shoot trash through your impromptu trashketball hoop. (No bottles or other injury causing trash should be thrown. Once again, no trips to the hospital please.)",

        "Spin an imaginary hula hoop around your waist for 3 minutes while the game continues.",

        "Imitate popular YouTube videos until someone can guess the video you are imitating.",

        "Dance to a song of the group’s choosing.",

        "Seduce a member of the same gender in the group.",

        "Break two eggs on your head.",

        "Be someone’s pet for the next 5 minutes.",

        "Compose a poem on the spot based on something the group comes up with.",

        "Poll dance for 1 minute with an imaginary pole.",

        "Take a shower with your clothes on.",

        "Attempt to walk on your hands for as far as you can (don’t break anything with your feet).",

        "Choose someone from the group to give you a spanking.",

        "Post an extremely unflattering picture of yourself to the social media outlet of your choosing.",

        "Make a funny face and keep making it for 2 minutes while the game continues.",

        "Imagine something in your room. Now spell it with your nose and keep spelling it with your nose until someone from the group guesses what you are trying spell.",

        "After the group chooses one rude word, sing a song and insert that rude word once into every line of the song.",

        "Drag your butt on the carpet like a dog from one end of the room to the other. You’ll need to be wearing shorts or pants for this one.",

        "Open a bag of snacks or candy using only your mouth, no hands or feet.",

        "Do your best impression of a baby being born.",

        "Bend at the waist so that you are looking behind you between your legs. Now run backwards until you can tag someone with your butt.",

        "Belly dance like your life depended on it.",

        "Make a tea out of something that isn’t tea (but isn’t dangerous / toxic) and drink it.",

        "Go to the bathroom, take off your underwear and put it on your head. Wear it on your head for the rest of the game.",

        "Act like whatever animal someone yells out for the next 1 minute.",

        "Eat one teaspoon of the spiciest thing you have in the kitchen.",

        "Transfer an icecube from your mouth to the person’s mouth on your right.",

        "Call the 7th contact in your phone and sing them 30 seconds of a song that the group chooses.",

        "No talking. Pretend to be a food. Don’t pretend to eat the food, pretend to be the food. Keep pretending until someone in the group guesses the food you are.",

        "Drop something in the toilet and then reach in to get it.",

        "Find the person whose first name has the same letter as your first name or whoever’s first name’s first letter is closest to yours. Now lick their face. Put 4 ice cubes down your pants.",

        "Sit in a spinning chair and have the group spin you for 30 seconds. Might help to hold a trash can just in case."
    };

    Button go,ready;
    TextView dailogtv;
    ImageView bottel;
    RadioButton truthr,darer;
    int truthlenght=0;
    int darelength=0;
    Dialog da;
    private String TAG="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        truthlenght=truthq.length;
        darelength=Dare.length;
        go=findViewById(R.id.go);
        bottel=findViewById(R.id.bottle);
        truthr=findViewById(R.id.truth);
        darer=findViewById(R.id.dare);
        da=dailog();

        dailogtv=da.findViewById(R.id.tv);
        ready=da.findViewById(R.id.ready);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] dir={0,60,120,180,240,300,360};
                Random rad1=new Random();
                int th=rad1.nextInt(dir.length-1);
                boolean isTruth=false;
                if(truthr.isSelected()){
                    isTruth=true;
                }
                rotate(bottel,dir[th],isTruth);
            }
        });

        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                da.dismiss();
            }
        });





    }






    public void rotate(ImageView v, final int mul, final boolean isTr){
        ObjectAnimator ghb=ObjectAnimator.ofFloat(v, View.ROTATION,0,(4*360)+mul);
        ghb.setDuration(4000);
        ghb.setInterpolator(new AccelerateDecelerateInterpolator());
        ghb.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                Random rad=new Random();
                String finaltruth=truthq[rad.nextInt(truthlenght-1)];
                String finaldare=Dare[rad.nextInt(darelength-1)];
                //Log.d(TAG, "onAnimationEnd:     "+finaltruth);
               // Log.d(TAG, "onAnimationEnd: "+finaldare);
                //Log.d(TAG, "onAnimationEnd: "+String.valueOf(mul));
                if(isTr){
                    dailogtv.setText(finaltruth);
                }else{
                    dailogtv.setText(finaldare);
                }

                da.show();


            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ghb.start();
    }

    public Dialog dailog(){
        Dialog dai=new Dialog(this);
        View v= LayoutInflater.from(this).inflate(R.layout.dailog,null);
        dai.setContentView(v);
        dai.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return dai;
    }
}
