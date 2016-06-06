package com.zekisanmobile.petsitter2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zekisanmobile.petsitter2.R;
import com.zekisanmobile.petsitter2.customListener.RecyclerViewOnClickListener;
import com.zekisanmobile.petsitter2.util.CircleTransform;
import com.zekisanmobile.petsitter2.util.DateFormatter;
import com.zekisanmobile.petsitter2.util.EntityType;
import com.zekisanmobile.petsitter2.vo.Job;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.ViewHolder>{

    private List<Job> jobList;
    private RecyclerViewOnClickListener listener;
    private Context context;
    private String entity;

    public JobListAdapter(List<Job> jobList, Context context,
                          RecyclerViewOnClickListener listener, String entity) {
        this.jobList = jobList;
        this.context = context;
        this.listener = listener;
        this.entity = entity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Job job = jobList.get(position);
        String photoUrl;

        switch (entity) {
            case EntityType.OWNER:
                photoUrl = job.getOwner().getPhotoUrl().getImage();
                holder.tvName.setText(job.getOwner().getName() + " " + job.getOwner().getSurname());
                break;
            default:
                photoUrl = job.getSitter().getPhotoUrl().getImage();
                holder.tvName.setText(job.getSitter().getName() + " " + job.getSitter().getSurname());
                break;
        }

        Picasso.with(context)
                .load(photoUrl)
                .transform(new CircleTransform())
                .into(holder.ivPhoto);

        holder.tvDateStart.setText(DateFormatter.formattedDateForView(job.getDateStart())
        + " - " + DateFormatter.formattedDateForView(job.getDateFinal()));
        holder.tvLocation.setText(job.getOwner().getDistrict() + " - " +
        job.getOwner().getCity() + " / " + job.getOwner().getState());
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_photo)
        public ImageView ivPhoto;

        @BindView(R.id.tv_name)
        public TextView tvName;

        @BindView(R.id.tv_date_start)
        public TextView tvDateStart;

        @BindView(R.id.tv_location)
        public TextView tvLocation;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(v, getAdapterPosition());
            }
        }
    }

}
