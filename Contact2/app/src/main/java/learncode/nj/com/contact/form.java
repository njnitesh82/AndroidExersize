package learncode.nj.com.contact;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class form extends AppCompatActivity {
   EditText Ename, Eemail,Enumber;
   Button Esave;
   View Ecard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Ecard=findViewById(R.id.Ecard);
        Ename= findViewById(R.id.Ename);
        Eemail=findViewById(R.id.Eemail);
        Enumber=findViewById(R.id.Enumber);
        Esave=findViewById(R.id.Esave);

        YoYo.with(Techniques.FadeIn).duration(1500).playOn(Ecard);




        final DatabaseReference contact=FirebaseDatabase.getInstance().getReference("contact");


        Esave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uid=contact.push().getKey();
                contact.child(uid).setValue(new contact(uid,
                        Ename.getText().toString(),
                        Eemail.getText().toString(),
                        Enumber.getText().toString())).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(form.this, "data is succesfully entered", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(form.this, "oppsss...try again!!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
