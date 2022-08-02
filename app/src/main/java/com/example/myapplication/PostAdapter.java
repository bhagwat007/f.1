package com.example.myapplication;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<PostModel> mpostList;
    private Context mactivity;
    public PostAdapter(Context context, List<PostModel> postList) {
        mpostList = postList;
        mactivity = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mactivity).inflate(R.layout.seasonlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        PostModel postModel = mpostList.get(position);
        String data = mpostList.get(position).getName();
        holder.name.setText(data);
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Url = postModel.getCompition_url();
                Intent intent = new Intent(mactivity, compition_Activity.class);
                intent.putExtra("Url", Url);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                mactivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mpostList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView1);
        }
    }
}




