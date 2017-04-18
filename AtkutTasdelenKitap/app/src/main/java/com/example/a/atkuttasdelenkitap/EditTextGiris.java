package com.example.a.atkuttasdelenkitap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextGiris extends AppCompatActivity {
    private EditText etg, etp;
  //  private Button btg, btc;

    private void init() {
        etg = (EditText)findViewById(R.id.kullaniciadi);
        etp = (EditText)findViewById(R.id.sifre);
        //btg = (Button)findViewById(R.id.login);
       // btc = (Button)findViewById(R.id.cancel);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        init();
    }

    public void btnCancel(View v) {
        this.finish();
    }

    public void  btnLogin(View v) {
        String usr = etg.getText().toString();
        String pwd = etp.getText().toString();

        if (usr.equals("aaa") && pwd.equals("123")) {
            this.setTitle("Giriş onaylandı");
            Toast.makeText(this, "Hoş geldiniz   " + usr,Toast.LENGTH_LONG).show();
            Intent i = new Intent(EditTextGiris.this,MainActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "isim yada şifre hatalı",Toast.LENGTH_LONG).show();
        }
    }



}
