package pnj.uas.ahmadfarid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import pnj.uas.ahmadfarid.database.DatabasePenemu;


public class TambahDataPenemu extends AppCompatActivity {

    EditText edtId, edtNama, edtTlp, edtEmail, edtAlamat, edtLokasi;
    TextView edtTglNemu;
    Button actionSimpan, actionHapus;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_penemu);
        edtId = findViewById(R.id.edtId);
        edtNama = findViewById(R.id.edtNama);
        edtTlp = findViewById(R.id.edtTlp);
        edtEmail = findViewById(R.id.edtEmail);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtLokasi = findViewById(R.id.edtLokasi);
        edtTglNemu = findViewById(R.id.edtTglNemu);
        actionSimpan = findViewById(R.id.actionSimpan);
        actionHapus = findViewById(R.id.actionHapus);

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            actionSimpan.setText("UPDATE");
            edtId.setEnabled(false);
            edtId.setText(extras.getString("id", ""));
            edtNama.setText(extras.getString("nama", ""));
            edtTlp.setText(extras.getString("tlp", ""));
            edtEmail.setText(extras.getString("email", ""));
            edtAlamat.setText(extras.getString("alamat", ""));
            edtLokasi.setText(extras.getString("lokasi", ""));
            edtTglNemu.setText(extras.getString("tgl_nemu", ""));


        }else {
            actionHapus.setVisibility(View.GONE);
        }

        edtTglNemu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                new DatePickerDialog(TambahDataPenemu.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });


        actionSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }
        });
        actionHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapus();
            }
        });

    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

            edtTglNemu.setText(simpleDateFormat.format(calendar.getTime().getTime()));

        }
    };
    DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);



        }
    };

    void simpan() {

        if (edtId.getText().toString().length() > 0 && edtNama.getText().toString().length() > 0 &&
                edtTlp.getText().toString().length() > 0 && edtEmail.getText().toString().length() > 0 &&
                edtAlamat.getText().toString().length() > 0 && edtLokasi.getText().toString().length() > 0 &&
                edtTglNemu.getText().toString().length() > 0 ) {

            database = new DatabasePenemu(this).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                contentValues.put("id", edtId.getText().toString());
            }

//
            contentValues.put("nama", edtNama.getText().toString());
            contentValues.put("tlp", edtTlp.getText().toString());
            contentValues.put("email", edtEmail.getText().toString());
            contentValues.put("alamat", edtAlamat.getText().toString());
            contentValues.put("lokasi", edtLokasi.getText().toString());
            contentValues.put("tgl_nemu", edtTglNemu.getText().toString());

            if (extras == null) {

                long insert = database.insert("tb_penemu", null, contentValues);
                if (insert != -1) {
                    Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }else{
                long update = database.update("tb_penemu", contentValues, "id=?", new String[]{""+edtId.getText().toString()});
                if (update != -1) {
                    Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            database.close();
        }
    }

    void hapus(){
        database = new DatabasePenemu(this).getWritableDatabase();
        long hapus = database.delete("tb_penemu", "id=?", new String[]{""+edtId.getText().toString()});
        if (hapus != -1) {
            Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
