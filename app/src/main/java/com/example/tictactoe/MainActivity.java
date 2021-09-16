package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Boolean gameActive = true;
    int activeplayer = 0;
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2){
            gameState[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer == 0){
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn Tap to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int [] winPosition: winPositions){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2){
                String winner;
                gameActive = false;
                if(gameState[winPosition[0]] == 0){
                    winner = "X has won the game!";
                }
                else{
                    winner = "O has won the game!";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }
        }
    }

    public void gameReset(View view){
        gameActive = true;
        activeplayer = 0;
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }
}