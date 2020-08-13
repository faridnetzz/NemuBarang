package pnj.uas.ahmadfarid;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import pnj.uas.ahmadfarid.utils.Config;

public class TambahDataActivity extends AppCompatActivity {
    EditText edtNama, edtTlp, edtLokasi;
    Button actionCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        edtNama = findViewById(R.id.edtNama);
        edtTlp = findViewById(R.id.edtTlp);
        edtLokasi = findViewById(R.id.edtLokasi);

        actionCreate = findViewById(R.id.actionCreate);

        actionCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCreate();
            }
        });
    }

    void getCreate(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Config._CREATE_PEGAWAI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(TambahDataActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                            if (jsonObject.getString("status").equals("OK")) {
                                finish();
                            }

                        }catch (JSONException e){
                            Toast.makeText(TambahDataActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TambahDataActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> parameter = new HashMap<>();
                parameter.put("nama", edtNama.getText().toString());
                parameter.put("tlp", edtTlp.getText().toString());
                parameter.put("lokasi", edtLokasi.getText().toString());


                return parameter;
            }
        };

        requestQueue.add(stringRequest);
    }

}
