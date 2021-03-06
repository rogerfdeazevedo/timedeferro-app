package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class MapaDaCidadeActivity extends AppCompatActivity {

    private TextView txtView_StatusJogador_Tentativas;

    private ImageView imgView_Lvl1;
    private ImageView imgView_Lvl2;
    private ImageView imgView_Lvl3;
    private ImageView imgView_Lvl4;
    private ImageView imgView_Lvl5;

    private GamePlay gamePlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_da_cidade);
        getSupportActionBar().hide();

        carregarComponentes();
        carregarDadosUI();

        imgView_Lvl1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            resumoDaTretaActivity();
         }
        });

        imgView_Lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resumoDaTretaActivity();
            }
        });

        imgView_Lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resumoDaTretaActivity();
            }
        });

        imgView_Lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resumoDaTretaActivity();
            }
        });

        imgView_Lvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resumoDaTretaActivity();
            }
        });

    }

    private void resumoDaTretaActivity(){
        Intent intent = new Intent(MapaDaCidadeActivity.this, ResumoDaTretaActivity.class);
        startActivity(intent);
        finish();
    }

    private void carregarComponentes(){

        txtView_StatusJogador_Tentativas = findViewById(R.id.mapaDaCidadeActivity_txtView_StatusJogador_Tentativas);

        imgView_Lvl1 = findViewById(R.id.mapaDaCidadeActivity_imgView_Lvl1);
        imgView_Lvl2 = findViewById(R.id.mapaDaCidadeActivity_imgView_Lvl2);
        imgView_Lvl3 = findViewById(R.id.mapaDaCidadeActivity_imgView_Lvl3);
        imgView_Lvl4 = findViewById(R.id.mapaDaCidadeActivity_imgView_Lvl4);
        imgView_Lvl5 = findViewById(R.id.mapaDaCidadeActivity_imgView_Lvl5);

        gamePlay = GamePlayManager.getGamePlay();
    }

    private void carregarDadosUI(){
        carregarStatusJogador();
        controleDeVisibilidadeDeLevel();
    }

    private void carregarStatusJogador(){
        String qtdStr = "" + gamePlay.getJogador().getQtdContinue();
        String tentativas = getString(R.string.game_continue, qtdStr);
        txtView_StatusJogador_Tentativas.setText(tentativas);
    }

    private void controleDeVisibilidadeDeLevel(){

         if(gamePlay.getLevelAtual()==1){
            imgView_Lvl2.setVisibility(View.INVISIBLE);
            imgView_Lvl3.setVisibility(View.INVISIBLE);
            imgView_Lvl4.setVisibility(View.INVISIBLE);
            imgView_Lvl5.setVisibility(View.INVISIBLE);
        }

        if(gamePlay.getLevelAtual()==2){
            imgView_Lvl2.setVisibility(View.VISIBLE);
            imgView_Lvl3.setVisibility(View.INVISIBLE);
            imgView_Lvl4.setVisibility(View.INVISIBLE);
            imgView_Lvl5.setVisibility(View.INVISIBLE);
        }

        if(gamePlay.getLevelAtual()==3){
            imgView_Lvl2.setVisibility(View.VISIBLE);
            imgView_Lvl3.setVisibility(View.VISIBLE);
            imgView_Lvl4.setVisibility(View.INVISIBLE);
            imgView_Lvl5.setVisibility(View.INVISIBLE);
        }

        if(gamePlay.getLevelAtual()==4){
            imgView_Lvl2.setVisibility(View.VISIBLE);
            imgView_Lvl3.setVisibility(View.VISIBLE);
            imgView_Lvl4.setVisibility(View.VISIBLE);
            imgView_Lvl5.setVisibility(View.INVISIBLE);
        }

        if(gamePlay.getLevelAtual()==5){
            imgView_Lvl2.setVisibility(View.VISIBLE);
            imgView_Lvl3.setVisibility(View.VISIBLE);
            imgView_Lvl4.setVisibility(View.VISIBLE);
            imgView_Lvl5.setVisibility(View.VISIBLE);
        }

    }

}