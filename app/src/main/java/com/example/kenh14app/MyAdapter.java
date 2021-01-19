package com.example.kenh14app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Activity activity;
    LayoutInflater inflater;
    ArrayList<TinTuc.News> tinTucs;

    public MyAdapter(Activity activity, ArrayList<TinTuc.News> tinTucs) {
        this.activity = activity;
        this.tinTucs = tinTucs;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tinTucs.size();
    }

    @Override
    public Object getItem(int position) {
        return tinTucs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null){
            v = inflater.inflate(R.layout.new_item, null);
        }
        TextView txtTitle = v.findViewById(R.id.txtTitle);
        txtTitle.setText(tinTucs.get(i).getTitle());
        ImageView imgAvatar = v.findViewById(R.id.imgAvatar);
        Picasso.get().load(tinTucs.get(i).getAvatar()).into(imgAvatar);
        TextView txtSapo = v.findViewById(R.id.txtSapo);
        txtSapo.setText(tinTucs.get(i).getSapo());
        TextView txtSource = v.findViewById(R.id.txtSource);
        txtSource.setText("Theo "+tinTucs.get(i).getSource());
        TextView txtShare = v.findViewById(R.id.txtShare);
        txtShare.setText(tinTucs.get(i).getShareCount()+"");
        TextView txtComment = v.findViewById(R.id.txtComment);
        txtComment.setText(tinTucs.get(i).getCommentCount()+"");
        TextView txtNewsRelation = v.findViewById(R.id.txtNewsRelation);
        txtNewsRelation.setText("+ Tin liên quan");

        Animation animation = AnimationUtils.loadAnimation(activity, R.anim.anim_listview);
        v.startAnimation(animation);
        return v;
    }
}
