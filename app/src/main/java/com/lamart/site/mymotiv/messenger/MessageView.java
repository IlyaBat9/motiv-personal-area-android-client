package com.lamart.site.mymotiv.messenger;

public class MessageView {
    private String text;
    private boolean belongsToCurrentUser;

    public MessageView(String text, boolean belongsToCurrentUser) {
        this.text = text;
        this.belongsToCurrentUser = belongsToCurrentUser;
    }

    public String getText() {
        return text;
    }

    public boolean isBelongsToCurrentUser() {
        return belongsToCurrentUser;
    }
}
