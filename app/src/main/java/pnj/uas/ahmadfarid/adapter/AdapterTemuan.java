package pnj.uas.ahmadfarid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pnj.uas.ahmadfarid.R;
import pnj.uas.ahmadfarid.model.ModelTemuan;

public class AdapterTemuan extends ArrayAdapter<ModelTemuan> {
    Context context;
    int resource;

    public AdapterTemuan(Context context, int resource){
        super(context,resource);
        this.context = context;
        this.resource = resource;


    }
    class Holder{
        TextView txtNama, txtTlp, txtLokasi;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;
        if(convertView==null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource,parent, false);
            holder.txtNama  = convertView.findViewById(R.id.txtNama);
            holder.txtTlp  = convertView.findViewById(R.id.txtTlp);
            holder.txtLokasi  = convertView.findViewById(R.id.txtLokasi);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        holder.txtNama.setText("Nama : "+   getItem(position).getNama());
        holder.txtTlp.setText("Tlp : "+   getItem(position).getTlp());
        holder.txtLokasi.setText("Lokasi : "+   getItem(position).getLokasi());

        return convertView;
    }
}
