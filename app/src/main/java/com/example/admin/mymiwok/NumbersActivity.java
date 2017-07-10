package com.example.admin.mymiwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener(){
                public void onAudioFocusChange(int focusChange){
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                        mMediaPlayer.start();

                    }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                        releaseMediaPlayer();

                    }
                }
            };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mp) {

        }

        public void  OnCompletion(MediaPlayer mp){

        }

    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one", "kunye", R.drawable.number_one,R.raw.one));
        words.add(new Word("two", "kubili", R.drawable.number_two,R.raw.two));
        words.add(new Word("three", "kuthathu", R.drawable.number_three,R.raw.three));
        words.add(new Word("four", "kune", R.drawable.number_four,R.raw.four));
        words.add(new Word("five", "kuhlanu", R.drawable.number_five,R.raw.five));
        words.add(new Word("six", " isithupha", R.drawable.number_six,R.raw.six));
        words.add(new Word("seven", "isikhombisa", R.drawable.number_seven,R.raw.seven));
        words.add(new Word("eight", "isishiyagalolunye", R.drawable.number_eight,R.raw.eight));
        words.add(new Word("nine", "isishiyagalombili", R.drawable.number_nine,R.raw.nine));
        words.add(new Word("ten", "ishumi", R.drawable.number_ten,R.raw.ten));

        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            }
        });
    }
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();

    }


    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }


}






