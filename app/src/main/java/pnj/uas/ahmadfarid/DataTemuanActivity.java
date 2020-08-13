package pnj.uas.ahmadfarid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget   .ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pnj.uas.ahmadfarid.adapter.AdapterTemuan;
import pnj.uas.ahmadfarid.adapter.AdapterTemuan;
import pnj.uas.ahmadfarid.model.ModelTemuan;
import pnj.uas.ahmadfarid.utils.Config;

public class DataTemuanActivity extends AppCompatActivity {
    ListView listView;
    AdapterTemuan adapterTemuan;
    Button actionTambahTemuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_temuan);

        listView = findViewById(R.id.listview);
        adapterTemuan = new AdapterTemuan(this, R.layout.item_list_temuan);
        listView.setAdapter(adapterTemuan);
        actionTambahTemuan = findViewById(R.id.actionTambahTemuan);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ModelTemuan TemuanModel = (ModelTemuan) parent.getAdapter().getItem(position);
                Intent intent = new Intent(DataTemuanActivity.this, DetailActivity.class);
                intent.putExtra("id", TemuanModel.getId());
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ModelTemuan modelTemuan = (ModelTemuan) parent.getAdapter().getItem(position);
                Intent intent = new Intent(DataTemuanActivity.this, HapusDataActivity.class);
                intent.putExtra("id", modelTemuan.getId());
                startActivity(intent);
                return true;
            }
        });

        actionTambahTemuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataTemuanActivity.this, TambahDataActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                Config._LIST_TEMUAN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("RESPONSE", "" + response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("temuan");

                    ArrayList<ModelTemuan> datas = new ArrayList<>();

                    for(int i=0; i < jsonArray.length(); i++) {
                        JSONObject item = jsonArray.getJSONObject(i);

                        ModelTemuan modelTemuan = new ModelTemuan();
                        modelTemuan.setId(item.getString("id"));
                        modelTemuan.setNama(item.getString("nama"));
                        modelTemuan.setTlp(item.getString("tlp"));
                        modelTemuan.setLokasi(item.getString("lokasi"));

                        datas.add(modelTemuan);

                    }
                    adapterTemuan.clear();
                    adapterTemuan.addAll(datas);

                    adapterTemuan.notifyDataSetChanged();

                }catch (JSONException ex){
                    Log.e("RESPONSE", "" + ex.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("RESPONSE", "" + error.getMessage());
            }
        });

        requestQueue.add(stringRequest);

    }
}