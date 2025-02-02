package com.example.updatedschedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GroupSessionAdapter extends RecyclerView.Adapter<GroupSessionAdapter.ViewHolder> {

    private List<String> sessionTopics;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String topic);
    }

    public GroupSessionAdapter(List<String> sessionTopics, OnItemClickListener listener) {
        this.sessionTopics = sessionTopics;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_session, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String topic = sessionTopics.get(position);
        holder.topicName.setText(topic);
        holder.itemView.setOnClickListener(v -> listener.onItemClick(topic));
    }

    @Override
    public int getItemCount() {
        return sessionTopics.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView topicName;

        public ViewHolder(View itemView) {
            super(itemView);
            topicName = itemView.findViewById(R.id.sessionTitle);
        }
    }
}
