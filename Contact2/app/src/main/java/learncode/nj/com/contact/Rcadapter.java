package learncode.nj.com.contact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Rcadapter extends RecyclerView.Adapter<Rcadapter.Rcholder> {
    Context context;
    List<contact> data;
    public Rcadapter() {
    }

    public Rcadapter(Context context, List<contact> d) {
        this.context = context;
        this.data= new ArrayList();
        this.data = d;
    }

    @NonNull
    @Override
    public Rcholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v= LayoutInflater.from(context).inflate(R.layout.concard,viewGroup,false);

        return new Rcholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Rcholder h, int i) {
      contact single=data.get(i);
      h.Bname.setText(String.valueOf(single.getName().charAt(0)).toUpperCase());
      h.fname.setText(single.getName());
      h.femail.setText(single.getEmail());
      h.fnumber.setText(single.getNumber());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Rcholder extends RecyclerView.ViewHolder{
        TextView Bname, fname, femail,fnumber;
        public Rcholder(@NonNull View itemView) {
            super(itemView);

            Bname=itemView.findViewById(R.id.text);
            fname=itemView.findViewById(R.id.fname);
            femail=itemView.findViewById(R.id.femail);
            fnumber=itemView.findViewById(R.id.fnumber);

        }
    }
}
