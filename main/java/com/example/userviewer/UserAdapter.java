package com.example.userviewer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<MainData> userElement;

    private Context mContext;

    public UserAdapter(Context context, ArrayList<MainData> userElement) {
        this.userElement = userElement;
        this.mContext = context;
    }

    // Getting our custom View so that news can show in it
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        ViewHolder evh = new ViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MainData currentUser = userElement.get(position);

        String url = currentUser.getAvatar();
        if (url != null) {
            Glide.with(mContext)
                    .load(url)
                    .asBitmap()
                    .thumbnail(0.1f)
                    .into(holder.mImageView);
        }

        holder.titleText.setText(currentUser.getFirstName());

        holder.publisher_text_view.setText(currentUser.getLastName());
    }

    @Override
    public int getItemCount() {
        return userElement.size();
    }

    // Finding ImageView and TextView from UI
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;

        public TextView titleText;

        public TextView publisher_text_view;

        public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.user_image);
            titleText = itemView.findViewById(R.id.user_title_text_view);
            publisher_text_view = itemView.findViewById(R.id.published_at_text_view);
            cardView  = itemView.findViewById(R.id.cardView);

        }

    }

}
