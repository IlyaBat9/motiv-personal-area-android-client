package com.lamart.site.mymotiv.messenger;

import android.widget.TextView;

public class MessengerViewHolder {
    private TextView name;
    private TextView messageBody;

    public MessengerViewHolder(TextView name, TextView messageBody) {
        this.name = name;
        this.messageBody = messageBody;
    }

    public MessengerViewHolder() {
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(TextView messageBody) {
        this.messageBody = messageBody;
    }
}
