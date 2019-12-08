package com.developer.multiplerecycleritem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int TYPE_TAKIP=1;
    private static int TYPE_BEGENI=2;
    private List<NotificationModel> bildirim_list;
    private Context context;

    NotificationAdapter(List<NotificationModel> bildirim_list, Context context){
        this.bildirim_list = bildirim_list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == TYPE_TAKIP) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_bildirim_takip_item, viewGroup, false);
            return new TakipViewHolder(view);

        } else {
            view = LayoutInflater.from(context).inflate(R.layout.custom_bildirim_begeni_item, viewGroup, false);
            return new BegeniViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (bildirim_list.get(position).getRowType().equals("Btakip")) {
            return TYPE_TAKIP;

        } else {
            return TYPE_BEGENI;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if (getItemViewType(position) == TYPE_TAKIP) {
            ((TakipViewHolder) holder).setTakipDetails (bildirim_list.get(position));
        } else {
            ((BegeniViewHolder) holder).setBegeniDetails(bildirim_list.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return bildirim_list.size();
    }


    public class TakipViewHolder extends RecyclerView.ViewHolder {

        public TextView user_fullname;
        public ImageView user_photo;
        public Button follow_btn;
        public TextView info;

        TakipViewHolder(@NonNull View itemView) {
            super(itemView);
            user_fullname = itemView.findViewById(R.id.textView39);
            user_photo = itemView.findViewById(R.id.imageView17);
            follow_btn = itemView.findViewById(R.id.button23);
            info = itemView.findViewById(R.id.textView40);
        }
        public void setTakipDetails(NotificationModel bildirim_list){
            user_fullname.setText(bildirim_list.getUserFullName());
            if (bildirim_list.getIsFollowing().equals("true")){
                follow_btn.setVisibility(View.GONE);
            }else {
                follow_btn.setVisibility(View.VISIBLE);
            }
            Glide
                    .with(context)
                    .load(bildirim_list.getUserPhotoUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(user_photo);
            info.setText(bildirim_list.getnDescription());
        }
    }





    class BegeniViewHolder extends RecyclerView.ViewHolder {
        public TextView user_fullname;
        public ImageView user_photo;
        public ImageView begenifoto;
        public TextView info;
        BegeniViewHolder(@NonNull View itemView) {
            super(itemView);
            user_fullname = itemView.findViewById(R.id.textViewfullname);
            user_photo = itemView.findViewById(R.id.imageViewuser);
            begenifoto = itemView.findViewById(R.id.imageViewliked);
            info = itemView.findViewById(R.id.textViewbilgi);
        }


        public void setBegeniDetails(NotificationModel bildirim_list){
            user_fullname.setText(bildirim_list.getUserFullName());
            Glide
                    .with(context)
                    .load(bildirim_list.getUserPhotoUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(user_photo);
            Glide
                    .with(context)
                    .load(bildirim_list.getLikedPhotoUrl())
                    .transform(new CenterCrop(), new RoundedCorners(16))
                    .into(begenifoto);

            info.setText(bildirim_list.getnDescription());


        }

    }




}