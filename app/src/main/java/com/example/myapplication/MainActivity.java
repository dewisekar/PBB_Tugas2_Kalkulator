package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button  button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonTambah, buttonKurang, buttonKali, buttonBagi,
            buttonKoma, buttonPlusMinus,
            buttonBackspace, buttonClear, buttonSamaDengan;

    TextView fieldEditText, fieldHistori, fieldHasil;

    Double angkaSatu, angkaDua, hasil;
    Double angkaHasil = (double) 0;
    Boolean hasilAkhir = false;
    int lastPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.tombol_nol);
        button1 = (Button) findViewById(R.id.tombol_satu);
        button2 = (Button) findViewById(R.id.tombol_dua);
        button3 = (Button) findViewById(R.id.tombol_tiga);
        button4 = (Button) findViewById(R.id.tombol_empat);
        button5 = (Button) findViewById(R.id.tombol_lima);
        button6 = (Button) findViewById(R.id.tombol_enam);
        button7 = (Button) findViewById(R.id.tombol_tujuh);
        button8 = (Button) findViewById(R.id.tombol_delapan);
        button9 = (Button) findViewById(R.id.tombol_sembilan);

        buttonTambah = (Button) findViewById(R.id.tombol_tambah);
        buttonKurang = (Button) findViewById(R.id.tombol_kurang);
        buttonKali = (Button) findViewById(R.id.tombol_kali);
        buttonBagi = (Button) findViewById(R.id.tombol_bagi);
        buttonSamaDengan = (Button) findViewById(R.id.tombol_sama_dengan);

        buttonKoma = (Button) findViewById(R.id.tombol_koma);

        buttonBackspace = (Button) findViewById(R.id.tombol_backspace);
        buttonClear = (Button) findViewById(R.id.tombol_clear);

        fieldEditText =(TextView) findViewById(R.id.field_edit_text);
        fieldHistori =(TextView) findViewById(R.id.field_histori);
        fieldHasil =(TextView) findViewById(R.id.field_hasil);

        // tombol angka
        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                fieldEditText.setText(fieldEditText.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                fieldEditText.setText(fieldEditText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                fieldEditText.setText(fieldEditText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                fieldEditText.setText(fieldEditText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                fieldEditText.setText(fieldEditText.getText() + "4");
            }
        });

        //tombol hapus
        buttonBackspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String str = fieldEditText.getText().toString();
                if ((str != null) && (str.length() > 0)) {
                    fieldEditText.setText(str.substring(0, str.length() - 1));
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String str = fieldEditText.getText().toString();
                if ((str != null) && (str.length() > 0)) {
                    fieldEditText.setText(null);
                }
            }
        });

        //tombol plus minus, koma
        buttonKoma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String str = fieldEditText.getText().toString();
                if (!str.contains(".")) {
                    fieldEditText.setText(fieldEditText.getText() + ".");
                }
                if(str.length()==0){
                    fieldEditText.setText("0.");
                }
            }
        });

        //tombol operasi
        buttonTambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(angkaSatu==null){
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        angkaSatu = (double) 0;
                        fieldHistori.append("0");
                        lastPressed =1;
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        angkaSatu = Double.parseDouble(nilai);
                        fieldHistori.append(fieldEditText.getText());
                        lastPressed=1;
                    }
                    fieldEditText.setText(null);
                }
                else {
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        angkaDua = (double) 0;

                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + 0);
                        angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                        lastPressed=1;
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        angkaDua = Double.parseDouble(nilai);
                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + fieldEditText.getText());
                        angkaHasil = angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                        lastPressed=1;

                    }
                }
                hasilAkhir=false;
            }
        });

        buttonKurang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(angkaSatu==null){
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        angkaSatu = (double) 0;
                        fieldHistori.append("0");
                        lastPressed=2;
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        angkaSatu = Double.parseDouble(nilai);
                        fieldHistori.append(fieldEditText.getText());
                        lastPressed=2;
                    }
                    fieldEditText.setText(null);
                }
                else {
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        angkaDua = (double) 0;
                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + 0);
                        angkaHasil = angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                        lastPressed=2;
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + fieldEditText.getText());
                        angkaDua = Double.parseDouble(nilai);
                        angkaHasil = angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                        lastPressed=2;

                    }
                }
                hasilAkhir=false;

            }
        });

        buttonKali.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(angkaSatu==null){
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        angkaSatu = (double) 0;
                        fieldHistori.append("0");
                        lastPressed=3;
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        angkaSatu = Double.parseDouble(nilai);
                        fieldHistori.append(fieldEditText.getText());
                        lastPressed=3;
                    }
                    fieldEditText.setText(null);
                }
                else {
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        angkaDua = (double) 0;
                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + 0);
                        angkaHasil = angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                        lastPressed=3;
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + fieldEditText.getText());
                        angkaDua = Double.parseDouble(nilai);
                        angkaHasil = angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                        lastPressed=3;
                    }
                }
                hasilAkhir=false;

            }
        });

        buttonBagi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(angkaSatu==null){
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        angkaSatu = (double) 0;
                        fieldHistori.append("0");
                        lastPressed=4;
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        angkaSatu = Double.parseDouble(nilai);
                        fieldHistori.append(fieldEditText.getText());
                        lastPressed=4;
                    }
                    fieldEditText.setText(null);
                }
                else {
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        angkaDua = (double) 0;
                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + 0);
                        angkaHasil = angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                        lastPressed=4;
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + fieldEditText.getText());
                        angkaDua = Double.parseDouble(nilai);
                        angkaHasil = angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                        lastPressed=4;
                    }
                }
                hasilAkhir=false;

            }
        });

        buttonSamaDengan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(angkaSatu==null && hasilAkhir==false){
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        fieldHistori.append("= 0");
                        fieldHasil.append("0");
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        fieldHistori.append("=" + fieldEditText.getText());
                        fieldHasil.append(fieldEditText.getText());
                    }
                    fieldEditText.setText(null);
                }
                else if(angkaSatu!= null && hasilAkhir==false){
                    String str = fieldEditText.getText().toString();
                    if(str.length()==0){
                        angkaDua = (double) 0;
                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + 0);
                        angkaHasil = angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                    }
                    else{
                        String nilai = fieldEditText.getText().toString().trim();
                        fieldHistori.append("\n" + getLastPressed(lastPressed) + ' ' + fieldEditText.getText());
                        angkaDua = Double.parseDouble(nilai);
                        angkaHasil = angkaHasil = hitung(lastPressed, angkaSatu, angkaDua);
                        angkaSatu = angkaHasil;
                        fieldHasil.setText("= " + angkaHasil.toString());
                        fieldEditText.setText(null);
                    }
                }
                hasilAkhir = true;
            }
        });

    }

    public double hitung(int params, double params_1, double params_2){
        hasil = null;
        if(params==1){
            hasil = params_1 + params_2;
        }
        else if(params==2){
            hasil = params_1 - params_2;
        }
        else if(params==3){
            hasil = params_1 * params_2;
        }
        else if(params==4){
            hasil = params_1 / params_2;
        }
        return hasil;
    }

    public char getLastPressed(int params){
        if(params==1){
            return '+';
        }
        else if(params==2){
            return '-';
        }
        else if(params==3){
            return '×';
        }
        else if(params==4){
            return '÷';
        }
        else{
            return '=';
        }
    }
}
