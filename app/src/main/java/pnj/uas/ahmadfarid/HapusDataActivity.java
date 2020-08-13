package pnj.uas.ahmadfarid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


public class HapusDataActivity extends AppCompatActivity {

    Button actionYes, actionNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_data);
        actionYes = findViewById(R.id.actionYes);
        actionNo = findViewById(R.id.actionNo);

        actionYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDelete();
                finish();
            }

        });
        actionNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HapusDataActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    void getDelete(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Config._DELETE_PEGAWAI + "?id=" +
                        getIntent().getExtras().getString("id", "0"),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(HapusDataActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                            if (jsonObject.getString("status").equals("OK")) {
                                finish();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(HapusDataActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HapusDataActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> parameter = new HashMap<>();
                parameter.put("id", getIntent().getExtras().getString("id", "0"));
                return parameter;
            }
        };

        requestQueue.add(stringRequest);
    }

}