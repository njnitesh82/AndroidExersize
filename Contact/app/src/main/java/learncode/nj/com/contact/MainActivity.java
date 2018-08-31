package learncode.nj.com.contact;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   FloatingActionButton fb;
   Dialog profile, form, op;
  RecyclerView rc;
  Toolbar toolbar;
  Database dbm;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

            }else{
                finish();
            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Contacts");
        toolbar.setTitleTextColor(Color.WHITE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.CALL_PHONE,
                        Manifest.permission.SEND_SMS}, 100);
            }
        }
        rc=findViewById(R.id.RecyclerView);

        //initilizing the database for use

        dbm = new Database(MainActivity.this);
        if (!dbm.getContact().isEmpty()) {
            refresh();
            //finding id of recycler view
//        rc=findViewById(R.id.recyclerView);
//        rc.setLayoutManager(new LinearLayoutManager(this));
//        rc.setAdapter(new RcAdapter(dbm.getContact(),MainActivity.this));}


            form = new Dialog(this);
            View vd = LayoutInflater.from(this).inflate(R.layout.form, null);
            form.setContentView(vd);
            form.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //setuping forn component
            final EditText formname = form.findViewById(R.id.nametv3);
            final EditText formmobile = form.findViewById(R.id.numbertv3);
            final EditText formemial = form.findViewById(R.id.emailtv3);
            final EditText formadd = form.findViewById(R.id.addresstv3);
            final Button save = form.findViewById(R.id.savetv3);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    dbm.addContact(new Contact(formname.getText().toString(),
                            formmobile.getText().toString(),
                            formemial.getText().toString(),
                            formadd.getText().toString()));
                    form.dismiss();
                }
            });


            fb = findViewById(R.id.floatingActionButton);
            fb.setCompatElevation(10);
            fb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    form.show();
                    //Toast.makeText(MainActivity.this, "" + formname + formmobile + formemial + formadd, Toast.LENGTH_SHORT).show();
                }
            });

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.ref){
            refresh();
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {

            rc.setLayoutManager(new LinearLayoutManager(this));
            rc.setAdapter(new RcAdapter(dbm.getContact(),MainActivity.this));
        }



    }

