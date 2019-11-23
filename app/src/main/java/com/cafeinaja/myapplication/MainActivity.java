package com.cafeinaja.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.cafeinaja.myapplication.R;

public class MainActivity extends AppCompatActivity {
    private TextView textView8;
    private Button menu,pesan;
    private Context mContext;
    Menu refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.cafe_layout );
        mContext = this;
        refresh = new Menu();
        menu  = findViewById( R.id.MC );
        pesan = findViewById( R.id.pesanan);
        textView8 = findViewById( R.id.textView8 );
        textView8.setText(refresh.cp());
        menu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( mContext, Menu.class )
                .putExtra( "status","create" ));
            }
        } );

        pesan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( mContext,Pesanan.class));
            }
        } );
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Ingin keluar?")
                .setMessage("Apakah anda ingin keluar?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        setResult(RESULT_OK, new Intent().putExtra("EXIT", true));
                        finish();
                    }

                }).create().show();
    }
}
