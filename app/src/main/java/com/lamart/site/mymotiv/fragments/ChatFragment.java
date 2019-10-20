package com.lamart.site.mymotiv.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.lamart.site.mymotiv.R;
import com.lamart.site.mymotiv.messenger.MessageView;
import com.lamart.site.mymotiv.messenger.MessengerAdapter;

public class ChatFragment extends ListFragment {

    private MessengerAdapter messengerAdapter;
    private EditText messenger_editText;
    private ImageView messenger_image_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment, container, false);
        initComponent(view);
        return view;
    }

    private void initComponent(View view){
        messengerAdapter = new MessengerAdapter(getActivity());
        setListAdapter(messengerAdapter);
        messenger_image_view = view.findViewById(R.id.image_button);
        messenger_editText = view.findViewById(R.id.edit_text_mes);
        messengerAdapter.add(new MessageView("Чем могу вам помочь?", false));
        messenger_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }
    private void sendMessage(){
        String message = messenger_editText.getText().toString().trim();
        if (message.length() > 0) {
            messengerAdapter.add(new MessageView(message, true));
            messenger_editText.getText().clear();
            setSelection(this.getListView().getCount() - 7);
        }
    }
}
