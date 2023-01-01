package com.example.myapplication.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.BBDD.JSON;
import com.example.myapplication.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolderDatos> implements View.OnClickListener{

    public ArrayList<String> datos;
    private View.OnClickListener listener;

    public AdapterPeliculas(String[] datos) {
        if(datos!=null)
        {
            this.datos=new ArrayList<String>(Arrays.asList(datos));
        }
        else
        {
            String[] datosarr={"2 Fast 2 Furious","28 Days Later","A Guy Thing","A Man Apart","A Mighty Wind","Agent Cody Banks","Alex & Emma","American Wedding","Anger Management","Anything Else","Bad Boys II","Bad Santa","Basic","Beyond Borders","big fish","Biker Boyz","Boat Trip","Bringing Down the House","Brother Bear","Bruce Almighty","Bulletproof Monk","Cabin Fever","Calendar Girls","Charlie's Angles: Full Throttle","Cheaper by the Dozen","Cold Creek Manor","Cold Mountain","Confidence","Cradle 2 the Grave","Daddy Day Care","Daredevil","Dark Blue","Darkness Falls","Deliver Us From Eva","Dickie Roberts, Former Child Star","Down With Love","Dr. Seuss' The Cat in the Hat","Dreamcatcher","Dumb and Dumberer","Duplex","Dysfunktional Family","Elf","Final Destination 2","Finding Nemo","Freaky Friday","Freddy vs. Jason","From Justin to Kelly","Gigli","Gods and Generals","Good Boy!","Gothika","Grind","Head of State","Holes","Hollywood Homicide","Honey","House of 1000 Corpses","How to Deal","How to Lose a Guy in 10 Days","Identity","In the Cut","Intolerable Cruelty","It Runs in the Family","Jeepers Creepers 2","Johnny English","Just Married","Kangaroo Jack","Kill Bill - Vol 1","Lara Croft, Tomb Raider","Le Divorce","Legally Blonde 2","Looney Tunes: Back in Action","Lost in Translation","Love Actually","Love Don't Cost a Thing","Malibu's Most Wanted","Marci X","Master and Commander","Matchstick Men","Mona Lisa Smile","Monster","My Boss's Daughter","Mystic River","National Security","Old School","Once Upon A Time in Mexico","Open Range","Out of Time","Paycheck","Peter Pan","Phone Booth","Piglet's Big Movie","Pirates of the Caribbean","Radio","Rugrats Go Wild","Runaway Jury","S.W.A.T.","Scary Movie 3","Seabiscuit","Secondhand Lions","Shanghai Knights","Sinbad: Legend of the Seven Seas","Something's Gotta Give","Spy Kids 3-D: Game Over","Stuck on You","Tears of the Sun","Terminator 3:Rise of the Machines","The Core","The Fighting Temptations","The Haunted Mansion","The Hulk","The Hunted","The In-Laws","The Italian Job","The Jungle Book 2","The Last Samurai","The League of Extraordinary Gentlemen","The Life of David Gale","The Lizze McGuire Movie","The Lord of the Rings III","The Matrix Reloaded","The Matrix Revolutions","The Medallion","The Missing","The Order","The Real Cancun","The Recruit","The Rundown","The School of Rock","The Texas Chainsaw Massacre","Timeline","Tupac: Resurrection","Under the Tuscan Sun","Underworld","Uptown Girls","View from the Top","What a Girl Wants","Willard","Wrong Turn","X2: X-Men United"};
            this.datos=new ArrayList<String>(Arrays.asList(datosarr));
        }

    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,null,false);
        vista.setOnClickListener(this);
        return new ViewHolderDatos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null)
        {
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            dato=itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String s) {
            dato.setText(s);
        }

        public String getNombre(){
            return (String) dato.getText();
        }
    }

}
