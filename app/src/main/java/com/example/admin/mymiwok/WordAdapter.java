package com.example.admin.mymiwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 7/3/2017.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    private int mColourResourceID;


    public WordAdapter(Context context, ArrayList<Word> words, int colourResourceID) {
        super(context,0 ,words);
        mColourResourceID = colourResourceID;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View ListItemView = convertView;
        if (ListItemView == null){
            ListItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }
        Word currentWord = getItem(position);
        TextView miwokTextView = (TextView) ListItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTextView = (TextView) ListItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());
        ImageView imageView = (ImageView) ListItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());

            imageView.setVisibility(View.VISIBLE);
        }

        else {
            imageView.setVisibility(View.GONE);

        }
        View textContainer = ListItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColourResourceID);
        textContainer.setBackgroundColor(color);

        return ListItemView;
    }
}
