package com.example.pc.competition.Controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.competition.Models.Competition;
import com.example.pc.competition.R;
import com.example.pc.competition.Retrofit.ConfigRetro;
import com.example.pc.competition.Retrofit.IRetro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by pc on 17/04/2018.
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {
    ConfigRetro configRetro = new ConfigRetro();
    Retrofit retrofit = configRetro.getConfig();
    private List<Competition> list;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public static TextView caption, currentMatchday,numberOfMatchdays;

        public MyViewHolder(View view) {
            super(view);
            caption = (TextView) view.findViewById(R.id.TvCap);
        // currentMatchday = (TextView) view.findViewById(R.id.TvCm);
            //numberOfMatchdays = (TextView) view.findViewById(R.id.TvNm);
        }
    }


    public myAdapter(List<Competition> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Competition competition = list.get(position);
       holder.caption.setText(competition.getCaption());
       holder.numberOfMatchdays.setText(competition.getNumberOfMatchdays());
        holder.currentMatchday.setText(competition.getCurrentMatchday());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
