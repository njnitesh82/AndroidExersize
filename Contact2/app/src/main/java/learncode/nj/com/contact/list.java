package learncode.nj.com.contact;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {
    View vfloat;
    RecyclerView recyclerView;
    List<contact> sdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView=findViewById(R.id.rec);
        vfloat=findViewById(R.id.floatbutton);
        sdata=new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final DatabaseReference contact= FirebaseDatabase.getInstance().getReference("contact");

        /*contact.orderByChild("name").startAt("n").endAt("n\uf8ff").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        contact.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    sdata.add(ds.getValue(contact.class));
                }
                recyclerView.setAdapter(new Rcadapter(list.this,sdata));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        vfloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(list.this,form.class));
            }
        });
    }
}
