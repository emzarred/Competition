package com.example.pc.competition.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pc.competition.Models.Competition;
import com.example.pc.competition.R;
import com.example.pc.competition.Retrofit.ConfigRetro;
import com.example.pc.competition.Retrofit.IRetro;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.pc.competition.Controllers.myAdapter.MyViewHolder.caption;
import static com.example.pc.competition.Controllers.myAdapter.MyViewHolder.currentMatchday;
import static com.example.pc.competition.Controllers.myAdapter.MyViewHolder.numberOfMatchdays;


public class MainActivity extends AppCompatActivity {
    private List<Competition> list = new ArrayList<>();
    ConfigRetro configRetro = new ConfigRetro();
    Retrofit retrofit = configRetro.getConfig();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("Competition");
            RecyclerView rv = (RecyclerView) findViewById(R.id.list);
            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setAdapter(new myAdapter(list));
        final IRetro cmp = retrofit.create(IRetro.class);
        final Competition competition = new Competition();
        Call<List<Competition>> call = cmp.getAllCompetitions();
        call.enqueue(new Callback<List<Competition>>() {
            @Override
            public void onResponse(Call<List<Competition>> call, Response<List<Competition>> response) {
               caption.setText(competition.getCaption());
                numberOfMatchdays.setText(competition.getNumberOfMatchdays());
               currentMatchday.setText(competition.getCurrentMatchday());

            }

            @Override
            public void onFailure(Call<List<Competition>> call, Throwable t) {

            }
        });


    }
}
