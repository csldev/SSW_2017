package com.compassl.anji.ssw_2017;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.compassl.anji.ssw_2017.R.id.ibt_stop;

public class Playing extends BaseActivity implements View.OnClickListener{

    // ImageView iv_song = (ImageView) findViewById(R.id.iv_song);
    ImageButton bt_playAndPause ;
    ImageButton bt_previous;
    ImageButton bt_next ;
    ImageButton bt_stop ;
    ImageButton bt_circle ;
    private TextView tv_lyc ;
    private TextView tv_text ;
    private TextView tv_title ;
    private ImageView iv_title;
    private SeekBar sb_pro;
    private SeekBar sb_audio;
    private AudioManager audioManager;
    private  int i = 0 ;
    private static final int UPDATE_SEEKBAR = 1;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Thread myThread;

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            try{
                sb_pro.setMax(mediaPlayer.getDuration());}catch (Exception e){e.printStackTrace();}
            switch (message.what) {
                case UPDATE_SEEKBAR:
                    try {
                        sb_pro.setProgress(mediaPlayer.getCurrentPosition());
                    }catch (Exception e){e.printStackTrace();}
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        Intent intent = getIntent();
        i = intent.getIntExtra("which",0);
        tv_lyc = (TextView) findViewById(R.id.tv_lrc);
        tv_text = (TextView) findViewById(R.id.tv_text);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_title = (ImageView) findViewById(R.id.iv_title_image);
        sb_pro = (SeekBar) findViewById(R.id.sb_progress);
        sb_audio = (SeekBar) findViewById(R.id.sb_audio);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        sb_audio.setMax(audioManager.getStreamMaxVolume(android.media.AudioManager.STREAM_MUSIC));
        sb_audio.setProgress(audioManager.getStreamMaxVolume(android.media.AudioManager.STREAM_MUSIC));
        sb_audio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, AudioManager.FLAG_SHOW_UI);
            }
        });

        sb_pro.setMax(mediaPlayer.getDuration());
        sb_pro.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    Message message = new Message();
                    message.what = UPDATE_SEEKBAR;
                    handler.sendMessage(message);
                }
            }
        });
        myThread.start();

        bt_playAndPause = (ImageButton) findViewById(R.id.ibt_playAndPause);
        bt_previous = (ImageButton) findViewById(R.id.ibt_previous);
        bt_next = (ImageButton) findViewById(R.id.ibt_next);
        bt_stop = (ImageButton) findViewById(R.id.ibt_stop);
        bt_circle = (ImageButton) findViewById(R.id.ibt_circle);

        bt_playAndPause.setOnClickListener(this);
        bt_stop.setOnClickListener(this);
        bt_next.setOnClickListener(this);
        bt_previous.setOnClickListener(this);
        bt_circle.setOnClickListener(this);

        playSong(i);
    }

    private void initMediaPlayer(int i){
        mediaPlayer.reset();
        switch (i){
            case 1:
                //iv_song.setImageResource(R.drawable.ssw01aqjx);
                tv_lyc.setText(R.string.lyc_01);
                tv_text.setText(R.string.bs_01);
                tv_title.setText(R.string.one);
                iv_title.setImageResource(R.drawable.ssw01aqjx);
                mediaPlayer = MediaPlayer.create(this,R.raw.ssw01aqjx);
                break;
            case 2:
                // iv_song.setImageResource(R.drawable.ssw02ssw);
                tv_lyc.setText(R.string.lyc_02);
                tv_text.setText(R.string.bs_02);
                tv_title.setText(R.string.two);
                iv_title.setImageResource(R.drawable.ssw02ssw);
                mediaPlayer = MediaPlayer.create(this,R.raw.ssw02ssw);
                break;
            case 3:
                //  iv_song.setImageResource(R.drawable.ssw03zxl);
                tv_lyc.setText(R.string.lyc_03);
                tv_text.setText(R.string.bs_03);
                tv_title.setText(R.string.three);
                iv_title.setImageResource(R.drawable.ssw03zxl);
                mediaPlayer = MediaPlayer.create(this,R.raw.ssw03zxl);
                break;
            case 4:
                //  iv_song.setImageResource(R.drawable.ssw04xty);
                tv_lyc.setText(R.string.lyc_04);
                tv_text.setText(R.string.bs_04);
                tv_title.setText(R.string.four);
                iv_title.setImageResource(R.drawable.ssw04xty);
                mediaPlayer = MediaPlayer.create(this,R.raw.ssw04xty);
                break;
            case 5:
                // iv_song.setImageResource(R.drawable.ssw05yzwwdg);
                tv_lyc.setText(R.string.lyc_05);
                tv_text.setText(R.string.bs_05);
                tv_title.setText(R.string.five);
                iv_title.setImageResource(R.drawable.ssw05yzwwdg);
                mediaPlayer = MediaPlayer.create(this,R.raw.ssw05yzwwdg);
                break;
            case 6:
                //   iv_song.setImageResource(R.drawable.ssw06yyc);
                tv_lyc.setText(R.string.lyc_06);
                tv_text.setText(R.string.bs_06);
                tv_title.setText(R.string.six);
                iv_title.setImageResource(R.drawable.ssw06yyc);
                mediaPlayer = MediaPlayer.create(this,R.raw.ssw06yyc);
                break;
            case 7:
                //  iv_song.setImageResource(R.drawable.ssw07ylq);
                tv_lyc.setText(R.string.lyc_07);
                tv_text.setText(R.string.bs_07);
                tv_title.setText(R.string.seven);
                iv_title.setImageResource(R.drawable.ssw07ylq);
                mediaPlayer = MediaPlayer.create(this,R.raw.ssw07ylq);
                break;
            case 8:
                //  iv_song.setImageResource(R.drawable.ssw08xc);
                tv_lyc.setText(R.string.lyc_08);
                tv_text.setText(R.string.bs_08);
                tv_title.setText(R.string.eight);
                iv_title.setImageResource(R.drawable.ssw08xc);
                mediaPlayer = MediaPlayer.create(this,R.raw.ssw08xc);
                break;
            case 9:
                //  iv_song.setImageResource(R.drawable.ssw09bjlnxt);
                tv_lyc.setText(R.string.lyc_09);
                tv_text.setText(R.string.bs_09);
                tv_title.setText(R.string.nine);
                iv_title.setImageResource(R.drawable.ssw09bjlnxt);
                mediaPlayer = MediaPlayer.create(this,R.raw.ssw09bjlnxt);
                break;
            case 99 :
                playSong(1);
                break;
        }
    }


    private void playSong(int j) {
        i=j;
        initMediaPlayer(i);
        //mediaPlayer.setLooping(true);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d("completion", "complete");
                playNext();
            }
        });
        mediaPlayer.start();
    }


    public static void actionStart(Context context,int i){
        Intent intent = new Intent(context,Playing.class);
        intent.putExtra("which",i);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_playAndPause:
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    bt_playAndPause.setImageResource(R.drawable.pause);
                }else {
                    mediaPlayer.pause();
                    bt_playAndPause.setImageResource(R.drawable.play);
                }
                break;
            case R.id.ibt_circle:
                if(mediaPlayer.isLooping()){
                    mediaPlayer.setLooping(false);
                    bt_circle.setImageResource(R.drawable.allplay);
                }else {
                    mediaPlayer.setLooping(true);
                    bt_circle.setImageResource(R.drawable.single);
                }
                break;
            case R.id.ibt_previous :
                playPrevious();
                break;
            case R.id.ibt_next:
                playNext();
                break;
            case ibt_stop :
                if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    initMediaPlayer(i);
                }
                finish();
                break;
        }
    }

    private void playNext() {
        if (i==9){playSong(1);}
        else{playSong(++i);}
    }

    private void playPrevious() {
        if(i==1){
            playSong(9);
        }else {playSong(--i);}
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
