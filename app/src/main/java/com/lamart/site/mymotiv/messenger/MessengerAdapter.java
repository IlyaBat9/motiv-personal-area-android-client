package com.lamart.site.mymotiv.messenger;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lamart.site.mymotiv.R;

import java.util.ArrayList;
import java.util.List;

public class MessengerAdapter extends BaseAdapter {

    List<MessageView> messageViews = new ArrayList<MessageView>();
    Context context;

    public MessengerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return messageViews.size();
    }

    public void add(MessageView messageView){
        messageViews.add(messageView);
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return messageViews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        MessengerViewHolder holder = new MessengerViewHolder();
        LayoutInflater messageInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        MessageView messageView = messageViews.get(i);
        if (messageView.isBelongsToCurrentUser()) {
            view = messageInflater.inflate(R.layout.my_message, null);
            holder.setMessageBody((TextView) view.findViewById(R.id.message_body));
            view.setTag(holder);
            holder.getMessageBody().setText(messageView.getText());
        } else {
            view = messageInflater.inflate(R.layout.their_message, null);
            holder.setMessageBody((TextView) view.findViewById(R.id.theirMessageText));
            view.setTag(holder);
            holder.getMessageBody().setText(messageView.getText());
        }
        return view;
    }
}
