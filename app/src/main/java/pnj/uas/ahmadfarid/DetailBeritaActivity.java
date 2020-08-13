package pnj.uas.ahmadfarid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailBeritaActivity extends AppCompatActivity {
    ImageView imgBerita;
    TextView txtJudul, txtDeskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        imgBerita = findViewById(R.id.imgBerita);
        txtJudul = findViewById(R.id.txtJudul);
        txtDeskripsi = findViewById(R.id.txtDeskripsi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();

        if(extras!=null) {
            getSupportActionBar().setTitle(extras.getString("judul", ""));
            txtJudul.setText(extras.getString("judul", ""));
            txtDeskripsi.setText(extras.getString("deskripsi", ""));
            Picasso.get().load(extras.getString("image", "")).into(imgBerita);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}