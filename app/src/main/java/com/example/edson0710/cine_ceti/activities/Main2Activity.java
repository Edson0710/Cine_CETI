package com.example.edson0710.cine_ceti.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.edson0710.cine_ceti.R;

import com.example.edson0710.cine_ceti.adapters.RecyclerViewAdapter;
import com.example.edson0710.cine_ceti.model.Peliculas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private final String JSON_URL = "http://192.168.100.73/ejemplojson/peliculas.json";
    private JsonArrayRequest ArrayRequest;
    private RequestQueue requestQueue;
    private List<Peliculas> listPelicul;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listPelicul = new ArrayList<>();
        recyclerView = findViewById(R.id.rv);
        jsoncall();
    }

    public void jsoncall(){

        ArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for(int i = 0 ; i < response.length(); i++){

                    try{
                        jsonObject = response.getJSONObject(i);
                        Peliculas peliculas = new Peliculas();
                        peliculas.setTitulo(jsonObject.getString("titulo"));
                        peliculas.setDuracion(jsonObject.getString("duracion"));
                        peliculas.setF_estreno(jsonObject.getString("f_estreno"));
                        peliculas.setClasificacion(jsonObject.getString("clasificacion"));
                        peliculas.setImagen(jsonObject.getString("imagen"));
                        listPelicul.add(peliculas);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(listPelicul);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Main2Activity.this,error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        requestQueue = Volley.newRequestQueue(Main2Activity.this);
        requestQueue.add(ArrayRequest);

    }

    public void setuprecyclerview(List<Peliculas> listPeliculas) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, listPeliculas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);



    }
}
