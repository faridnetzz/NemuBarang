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
import pnj.uas.ahmadfarid.model.PenemuModel;

public class AdapterPenemu extends ArrayAdapter<PenemuModel> {

    Context context;
    int resource;

    public AdapterPenemu(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;
        if(convertView==null){
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder.txtId = convertView.findViewById(R.id.txtId);
            holder.txtNama = convertView.findViewById(R.id.txtNama);

            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.txtId.setText("Nama : "+ getItem(position).getNama());
        holder.txtNama.setText("Telepon: "+ getItem(position).getTlp());


        return convertView;
    }
    class Holder {
        TextView txtNama, txtTlp, txtId;
    }
}
