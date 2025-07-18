package com.s4680244.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.s4680244.Models.Entity;
import com.s4680244.R;
import com.s4680244.Screens.DetailScreen;

import java.util.List;

public class EntityAdapter extends RecyclerView.Adapter<EntityAdapter.EntityViewHolder> {

    private List<Entity> entityList;
    private Context ctx;
    public EntityAdapter(List<Entity> entityList , Context ctx) {
        this.entityList = entityList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public EntityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_entity, parent, false);
        return new EntityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntityViewHolder holder, int position) {
        Entity entity = entityList.get(position);
        holder.tvSpecies.setText(entity.getSpecies());
        holder.tvScientificName.setText(entity.getScientificName());
        holder.outerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx.startActivity(new Intent(ctx , DetailScreen.class).putExtra("entity" , entityList.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public static class EntityViewHolder extends RecyclerView.ViewHolder {
        TextView tvSpecies, tvScientificName;
        LinearLayout outerLayout;

        public EntityViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSpecies = itemView.findViewById(R.id.tvSpecies);
            tvScientificName = itemView.findViewById(R.id.tvScientificName);
            outerLayout = itemView.findViewById(R.id.outerLayout);
        }
    }
}
