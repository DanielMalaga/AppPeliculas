package com.example.myapplication.fragments;

import android.os.Bundle;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.myapplication.Adaptadores.AdapterPeliculas;
import com.example.myapplication.BBDD.JSON;
import com.example.myapplication.R;
import com.example.myapplication.Wraper.Pelicula;
import com.example.myapplication.databinding.FragmentDetalleBinding;
import com.example.myapplication.databinding.FragmentListadoBinding;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetalleFragment extends Fragment {

    private FragmentDetalleBinding binding;
    private String titulo;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titulo=getArguments().getString("titulo");
        TextView tituloT=view.findViewById(R.id.titulo);
        tituloT.setText(titulo);
        TextView descripcion=view.findViewById(R.id.descripcion);
        RatingBar valoracion=view.findViewById(R.id.valoracion);

        InputStream in = new BufferedInputStream(getResources().openRawResource(R.raw.bbdd));

        Pelicula p=JSON.devolverPelicula(titulo,in);

        descripcion.setText(p.getDescripcion());
        valoracion.setRating(p.getValoracion());

        //JSON.leerPeliculas(ruta);

        binding.volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DetalleFragment.this)
                        .navigate(R.id.action_DetalleFragment_to_ListadoFragment);
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
