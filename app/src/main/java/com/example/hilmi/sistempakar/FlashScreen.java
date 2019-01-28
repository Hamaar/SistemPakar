package com.example.hilmi.sistempakar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hilmi.sistempakar.db.SessionHelper;
import com.example.hilmi.sistempakar.helpers.SQLiteHelper;
import com.example.hilmi.sistempakar.models.Gejala;
import com.example.hilmi.sistempakar.models.Keputusan;
import com.example.hilmi.sistempakar.models.Penyakit;

public class FlashScreen extends AppCompatActivity {

    private int waktu_flash = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_screen);

        if (SessionHelper.getInstance(this).getAppFirstTime()) {
            SQLiteHelper.getInstance(this).addHama(new Penyakit("P1", "Penyakit SNOT CORZYA", "mata"));
            SQLiteHelper.getInstance(this).addHama(new Penyakit("P2", "Penyakit Berak Diare", "mata"));
            SQLiteHelper.getInstance(this).addHama(new Penyakit("P3", "Penyakit Berak Kapur", "mata"));
            SQLiteHelper.getInstance(this).addHama(new Penyakit("P4", "Penyakit Nyilet Atau Kurus", "mata"));
            SQLiteHelper.getInstance(this).addHama(new Penyakit("P5", "Penyakit Egg Binding", "mata"));
            SQLiteHelper.getInstance(this).addHama(new Penyakit("P6", "Penyakit Bulu", "mata"));
            SQLiteHelper.getInstance(this).addHama(new Penyakit("P7", "Penyakit Ganguan Pernafasan", "mata"));

//            SQLiteHelper.getInstance(this).addHama(new Penyakit("P009","Penyakit Bercak Daun","Pengendalian yang pertama secara alami mengatur jarak tanaman yang tidak terlalu rapat.Buanglah bagian batang daun yang terinfeksi."));
//            SQLiteHelper.getInstance(this).addHama(new Penyakit("P010","Penyakit Jamur Upas","Pengendalian yang pertama yaitu secara alami dengan pembersihan rumput di area tanaman, perhatikan kelembaban lahan dengan cara dikurangi jumlah tanaman di lahan, dan buang kulit yang terlihat infeksi."));
//            SQLiteHelper.getInstance(this).addHama(new Penyakit("P011","Penyakit Kanker","Pengendalian yang pertama yaitu secara alami  dengan cara memetik buah apel disaat belum terlalu masak."));
//            SQLiteHelper.getInstance(this).addHama(new Penyakit("P012","Penyakit Busuk Buah","Pengendalian yang pertama yaiut secara alami yang dilakukan adalah dengan memetik buah yang sudah punya kematangan pas dan belum terlalu masak."));
//            SQLiteHelper.getInstance(this).addHama(new Penyakit("P013","Penyakit Busuk Akar","Tanaman yang terserang di cabut sampai ke akar-akarnya dan bekasnya tidak ditanami selama 1 tahun."));
//
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G001","Daun berubah bentuk, berkerut dan mengering"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G002","Pengembunan terhambat"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G003","Buah-buahan mudah gugur"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G004","Kualitas buah jelek"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G005","Tanaman tidak menghasilkan buah"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G006","Daun berbercak kuning, buram, coklat dan mengering"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G007","Buah berbercak keperak-perakan"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G008","Buah berbercak coklat"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G009","Daun berbintik-bintik putih"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G010","Kedua sisi daun menggulung ke atas"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G011","Pertumbuhan daun tidak normal"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G012","Daun pada ujung tunas menjadi kering dan gugur"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G013","Pada buah muda terdapat luka berwarna coklat keabu abuan"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G014","Daun tergerek"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G015","Daun berlubang lubang tidak teratur"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G016","Daun tinggal tulang-tulangnya saja"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G017","Buah yang masih kecil mudah berlubang atau terluka"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G018","Daun berbercak coklat"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G019","Perkembangan daun tidak simetris"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G020","Tunas menjadi coklat, kering dan mati"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G021","Buah berbercak coklat"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G022","Tanaman tinggal tulang dan daun nya saja"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G023","Buah terdapat benjol benjol"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G024","Pada permukaan daun tampak tepung putih"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G025","Tumbuh tunas tidak normal, kerdil"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G026","Buah muda berwarna kecoklat-coklatan"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G027","Kulit buah mudah pecah berkutil-kutil cokelat dan putih"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G028","Buah tua berwarna coklat muda, seperti sawo"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G029","Pada bercak permukaan atas timbul titik titik berwarna hitam kecoklatan"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G030","Buah Tua berwarna coklat muda, seperti buah sawo"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G031","Sebagian daun gugur"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G032","Terdapat bintik-bintik putih pada permukaan kulit tanaman"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G033","Terdapat kerak berwarna merah jambu, setelah tua menjadi lebih muda atau putih"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G034","Kulit kayu dibawah kerak busuk dan kering"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G035","Terdapat bintik atau bulatan kecil berwarna merah tua pada sisi yang telah busuk dan kering lalu cabang menjadi mati"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G036","Batang atau cabang busuk dan mati"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G037","Batang atau cabang berwarna coklat kehitam hitaman"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G038","Batang atau cabang kadang mengeluarkan cairan berwarna kecoklatan"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G039","Buah berbercak kecil atau berwarna kecoklatan"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G040","Buah berair atau rontok"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G041","Warna buah menjadi pucat atau menguning"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G042","Buah berbercak kecil berwarna coklat kehitaman berbentuk bulat"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G043","Buah busuk"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G044","Terdapat bintik hitam dan cenderung melebar"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G045","Buah berbercak coklat dan akhirnya rontok"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G046","Daun layu"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G047","Daun Gugur"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G048","Kulit akar membusuk"));
//            SQLiteHelper.getInstance(this).addGejala(new Gejala("G049","Daun menjalar ke batang dan akhirnya mati"));
//
//
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P1", "G2, G4, G11"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P2", "G4, G10"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P3", "G3, G5, G9"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P4", "G3, G6, G9"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P5", "G7, G8, G10"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P6", "G9, G10"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P7", "G3, G11, G14"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P8", "G10, G12"));
//            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P009","G015,G029,G030,G031"));
//            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P010","G032,G033,G034,G035"));
//            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P011","G036,G037,G038,G039,G040,G041"));
//            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P012","G008,G042,G043,G044,G045"));
//            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G046,G047,G048,G049"));
//
//
            SessionHelper.getInstance(this).setAppFirstTime(false);
        }


        //handler
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {

                                          //setelah loading maka akan langsung berpindah ke home activity
                                          Intent home = new Intent(FlashScreen.this, Index.class);
                                          startActivity(home);
                                          finish();

                                      }
                                  },

                waktu_flash);

    }
}