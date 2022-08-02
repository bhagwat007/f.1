package com.example.myapplication;


import android.content.Context;
        import android.content.Intent;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

        import java.util.List;

    public class ParentAdapter extends RecyclerView.Adapter<com.example.myapplication.ParentAdapter.ViewHolder> {


        private List<Parentmodelclass> parentmodelclasses;
        private Context mactivity;

        public ParentAdapter(Context context, List<Parentmodelclass> parentmodelclasses) {
this.parentmodelclasses=parentmodelclasses;
mactivity = context;

        }


        @NonNull
        @Override
        public com.example.myapplication.ParentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mactivity).inflate(R.layout.parentadapter, parent, false);

            return new com.example.myapplication.ParentAdapter.ViewHolder(view);

        }
        @Override
        public void onBindViewHolder(@NonNull com.example.myapplication.ParentAdapter.ViewHolder holder, int position) {


                        holder.title.setText(parentmodelclasses.get(position).title);

                        CompletedMatchAdapter childAdapter;
                        childAdapter = new CompletedMatchAdapter(mactivity, parentmodelclasses.get(position).mroundlist);
                        holder.childrv.setLayoutManager(new LinearLayoutManager(mactivity, LinearLayoutManager.HORIZONTAL, false));

                        holder.childrv.setAdapter(childAdapter);
                        childAdapter.notifyDataSetChanged();

                }






        @Override
        public int getItemCount() {
            return parentmodelclasses.size();
        }




            public class ViewHolder extends RecyclerView.ViewHolder {
                RecyclerView childrv;
                public TextView title;

                public ViewHolder(@NonNull View itemView) {
                    super(itemView);
                    childrv = itemView.findViewById(R.id.childrv);
                    title = itemView.findViewById(R.id.adatitle);


                }

            }

        }



