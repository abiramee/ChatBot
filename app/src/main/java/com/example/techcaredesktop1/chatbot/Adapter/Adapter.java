package com.example.techcaredesktop1.chatbot.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.techcaredesktop1.chatbot.Model.Model;
import com.example.techcaredesktop1.chatbot.R;
import com.example.techcaredesktop1.chatbot.ViewHolder.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TechCare Desktop 1 on 9/18/2017.
 */

public class Adapter extends RecyclerView.Adapter<ViewHolder>{
    List<Model> chat = new ArrayList<>();
    Context context;
    LayoutInflater layoutInflater;
    SharedPreferences sharedPreferences;


    public Adapter(Context context, List<Model> storyItems) {
        this.chat = storyItems;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_row, parent, false);
        ViewHolder activity_storyitem = new ViewHolder(view);
        return activity_storyitem;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (chat.get(position).getMsg() == "ok") {
            holder.story1.setVisibility(View.GONE);
            holder.story2.setText(chat.get(position).getResponse());
        } else {
            holder.story2.setVisibility(View.GONE);
            holder.story1.setText(chat.get(position).getResponse());
        }


    }

    @Override
    public int getItemCount() {
        return chat.size();
    }
}
