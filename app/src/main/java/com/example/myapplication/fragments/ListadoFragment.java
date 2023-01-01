package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adaptadores.AdapterPeliculas;
import com.example.myapplication.BBDD.JSON;
import com.example.myapplication.R;
import com.example.myapplication.Wraper.Pelicula;
import com.example.myapplication.databinding.FragmentListadoBinding;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ListadoFragment extends Fragment {

    private FragmentListadoBinding binding;

    private AdapterPeliculas adaptador;
    private RecyclerView listado;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentListadoBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listado = view.findViewById(R.id.peliculasID);
        listado.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));


        try {
            InputStream in = new BufferedInputStream(getResources().openRawResource(R.raw.bbdd));
            ArrayList<Pelicula> peliculas= (ArrayList<Pelicula>) JSON.readJsonStream(in);
            String[] datos=new String[peliculas.size()];

            for (int i = 0; i < peliculas.size(); i++) {
                datos[i]=peliculas.get(i).getTitulo();
            }

            adaptador=new AdapterPeliculas(datos);
        } catch (IOException e) {
            e.printStackTrace();
            adaptador=new AdapterPeliculas(null);

        }

        listado.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titulo=adaptador.datos.get(listado.getChildAdapterPosition(view));

                //Snackbar.make(view, titulo, Snackbar.LENGTH_LONG).setAction("Action", null).show();

                Bundle bundle = new Bundle();
                bundle.putString("titulo",titulo);


                NavHostFragment.findNavController(ListadoFragment.this)
                        .navigate(R.id.action_ListadoFragment_to_DetalleFragment,bundle);
            }
        });


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListadoFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}