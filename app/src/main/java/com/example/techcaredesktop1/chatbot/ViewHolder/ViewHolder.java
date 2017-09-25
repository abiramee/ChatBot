package com.example.techcaredesktop1.chatbot.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.techcaredesktop1.chatbot.R;

/**
 * Created by TechCare Desktop 1 on 9/18/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder{

    public TextView story1;
    public TextView story2;

    public ViewHolder(View itemView) {
        super(itemView);

        story1 = itemView.findViewById(R.id.story1);
        story2 = itemView.findViewById(R.id.story2);
    }
}
