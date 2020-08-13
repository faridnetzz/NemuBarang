package pnj.uas.ahmadfarid.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabasePenemu extends SQLiteOpenHelper {


    public DatabasePenemu(@Nullable Context context) {
        super(context, "db_penemu", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tb_penemu (id TEXT PRIMARY KEY, nama TEXT, " +
                "tlp TEXT, email TEXT, alamat TEXT, lokasi TEXT,  " +
                "tgl_nemu TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
