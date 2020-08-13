package pnj.uas.ahmadfarid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import pnj.uas.ahmadfarid.adapter.AdapterPenemu;
import pnj.uas.ahmadfarid.database.DatabasePenemu;
import pnj.uas.ahmadfarid.model.PenemuModel;

public class ListDataTemuan extends AppCompatActivity {

    ListView listView;
    AdapterPenemu adapterPenemu;
    SQLiteDatabase database;
    Button actionTambahPenemu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_penemu);
        listView = findViewById(R.id.listView);
        actionTambahPenemu = findViewById(R.id.actionTambahPenemu);
        adapterPenemu = new AdapterPenemu(this, R.layout.item_temuan);
        listView.setAdapter(adapterPenemu);

        actionTambahPenemu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListDataTemuan.this, TambahDataPenemu.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PenemuModel model = (PenemuModel) parent.getAdapter().getItem(position);
                Intent intent = new Intent(ListDataTemuan.this, TambahDataPenemu.class);
                intent.putExtra("id", model.getId());
                intent.putExtra("nama", model.getNama());
                intent.putExtra("tlp", model.getTlp());
                intent.putExtra("email", model.getEmail());
                intent.putExtra("alamat", model.getAlamat());
                intent.putExtra("lokasi", model.getLokasi());
                intent.putExtra("tgl_naik", model.getTgl_nemu());


                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getdata();
    }
    void getdata(){

        database = new DatabasePenemu(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM tb_penemu", null);
        ArrayList<PenemuModel> data = new ArrayList<>();
        adapterPenemu.clear();
        data.clear();

        if(cursor.moveToFirst()) {
            do{
                PenemuModel model = new PenemuModel();
                model.setId(cursor.getString(0));
                model.setNama(cursor.getString(1));
                model.setTlp(cursor.getString(2));
                model.setEmail(cursor.getString(3));
                model.setAlamat(cursor.getString(4));
                model.setLokasi(cursor.getString(5));
                model.setTgl_nemu(cursor.getString(6));


                data.add(model);

            }while (cursor.moveToNext());
            cursor.close();
            database.close();

            adapterPenemu.addAll(data);

        }

    }}