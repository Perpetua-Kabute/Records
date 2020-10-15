package com.androidplayground.paycalc;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {

    private final Context mContext;
    private final List<WorkerInfo> mWorker;
    private List<WorkerInfo> worker;

    public MyAdapter(Context context, List<WorkerInfo> worker) {
        mContext = context;
        mWorker = worker;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_worker_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkerInfo worker =mWorker.get(position);
        holder.mDate.setText(worker.getDate());
        holder.mUnit.setText(worker.getUnit());
    }

    @Override
    public int getItemCount() {
        return mWorker.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView mDate;
        private final TextView mUnit;

        ViewHolder(@NonNull View view) {
            super(view);
            mDate = view.findViewById(R.id.date);
            mUnit = view.findViewById(R.id.unit);
        }
    }

}
