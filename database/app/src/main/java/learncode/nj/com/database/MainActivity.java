package learncode.nj.com.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseReference myRef;

     EditText textd;
     Button click;
     ListView lt;
     List<model> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textd=findViewById(R.id.text);
        click=findViewById(R.id.click);
        lt=findViewById(R.id.list);


        data=new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
         myRef = database.getReference("user");



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String uidf=myRef.push().getKey();

               myRef.child(uidf).setValue(new model(uidf,textd.getText().toString(),"26","a+","good"));
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot df:dataSnapshot.getChildren()) {
                    data.add(df.getValue(model.class));
                }
                List<String> f=new ArrayList<>();

                for(model a:data){
                    f.add(a.name+"|"+a.age+"|"+a.healthstatus);
                }


                 ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.select_dialog_item,f);
                 lt.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
