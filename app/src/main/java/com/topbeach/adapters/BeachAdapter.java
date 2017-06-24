package com.topbeach.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.topbeach.R;
import com.topbeach.beachdetails.BeachDetails;
import com.topbeach.beachmodel.BeachModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alchimy on 4/25/2017.
 */

public class BeachAdapter extends RecyclerView.Adapter<BeachAdapter.BeachViewHolder> {
    private final String TAG = getClass().getSimpleName();
    private List<BeachModel> beachModelList;
    private Context context;

    public BeachAdapter(List<BeachModel> beachModelList) {
        this.beachModelList = beachModelList;

    }


    @Override
    public BeachViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity, parent, false);
        return new BeachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeachAdapter.BeachViewHolder holder, int position) {
        BeachModel beachModel = beachModelList.get(position);
        holder.countryName.setText(beachModel.getNameCountry());
        holder.cityName.setText(beachModel.getNameCity());
        holder.islandName.setText(beachModel.getNameIsland());
        holder.beachName.setText(beachModel.getNameBeach());
        holder.beachDescription.setText(beachModel.getDescriptionBeach());
        Glide.with(context)
                .load(beachModel.getImageUrl())
                .fitCenter()
                .into(holder.beachImage);


    }

    @Override
    public int getItemCount() {
        return beachModelList.size();
    }

    public class BeachViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.countryName) TextView countryName;
        @BindView(R.id.islandName) TextView islandName;
        @BindView(R.id.cityName) TextView cityName;
        @BindView(R.id.beachName) TextView beachName;
        @BindView(R.id.beachDescription) TextView beachDescription;
        @BindView(R.id.beachImage) ImageView beachImage;


        public BeachViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, BeachDetails.class);
                    intent.putExtra("country", beachModelList.get(getAdapterPosition()).getNameCountry());
                    intent.putExtra("island", beachModelList.get(getAdapterPosition()).getNameIsland());
                    intent.putExtra("city", beachModelList.get(getAdapterPosition()).getNameCity());
                    intent.putExtra("beachName", beachModelList.get(getAdapterPosition()).getNameBeach());
                    intent.putExtra("beachNDescription", beachModelList.get(getAdapterPosition()).getDescriptionBeach());
                    intent.putExtra("image", beachModelList.get(getAdapterPosition()).getImageUrl());
                    context.startActivity(intent);


                }
            });

        }


    }
}
