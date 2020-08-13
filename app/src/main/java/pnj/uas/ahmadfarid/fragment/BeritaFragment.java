package pnj.uas.ahmadfarid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import pnj.uas.ahmadfarid.DetailBeritaActivity;
import pnj.uas.ahmadfarid.R;
import pnj.uas.ahmadfarid.adapter.AdapterBerita;
import pnj.uas.ahmadfarid.model.BeritaModel;

public class BeritaFragment extends Fragment {
    ListView listView;
    AdapterBerita adapterBerita;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_berita, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listView);
        adapterBerita = new AdapterBerita(getActivity(),R.layout.item_list_berita);
        listView.setAdapter(adapterBerita);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                BeritaModel datas = (BeritaModel) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getActivity(), DetailBeritaActivity.class);
                intent.putExtra("judul", datas.getTitle());
                intent.putExtra("deskripsi", datas.getDeskrisi());
                intent.putExtra("image", datas.getImage());

                startActivity(intent);

            }
        });

        buatDataBerita();
    }

    void buatDataBerita() {
        String[] judul = {
                "Nurhasanah, Dubber Doraemon Indonesia Meninggal Dunia",
                "Kimetsu No Yaiba Menjadi Manga Terlaris",
                "Manga Spin-off SSSS Gridman resmi Dibatalkan!",
                "Season 2 Anime Dr. Stone Dijadwalkan Tayang Pada Januari 2021"
        };

        String[] deskripsi = {
                "Kabar ini diketahui dari unggahan rekan-rekan sesama dubber yang mengucapkan belasungkawa melalui Facebook pribadi mereka untuk Nurhasanah. Merekapun merasakan kehilangan sosok senior serta sahabat bagi anak-anak melalui Doraemon tersebut. Para penggemar pun juga membanjiri komentar dengan ucapan belasungkawa. ",
                "Meski manga Kimtesu no Yaiba telah berakhir sejak bulan Mei lalu, tapi nampaknya itu tidak menurunkan antusias dari para penggemarnya diluar sana untuk terus mengoleksi volume-volume terbarunya. Hal ini dapat kita lihat dari volume kompilasi 21 dari edisi reguler manga yang sukses terjual lebih dari 1,19 juta eksemplar, dan edisi khusus dari volume yang sama terjual 850 ribu eksemplar.",
                "Mangaka Shun Kazakami melalui akun Twitter resminya pada Rabu (8/7) kemarin mengumumkan bahwa rencana pembuatan manga spin-off dari serial anime SSSS.Gridman yang ceritanya akan berfokus pada karakter Akane Shinjou telah dibatalkan. Kazakami memaparkan bahwa pembatalan tersebut dikarenakan perbedaan pendapat mengenai arah cerita manga tersebut.",
                "Lewat terbitan terbaru Shounen Jump terungkap kalau Season kedua serial anime Dr. Stone yang berjudul Dr. Stone: Stone Wars akan tayang pada bulan Januari tahun depan. Genre: Adventure, Sci-fi, Shonen Studio: TMS Entertainment "
        };

        String[] image = {
                "https://scontent-lga3-2.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/108130084_3071716389550677_7414100620850037690_n.jpg?_nc_ht=scontent-lga3-2.cdninstagram.com&_nc_cat=1&_nc_ohc=3Jb1dPv61loAX-7wf8n&oh=b8ac75e2ec09c9b5e89a7731a389461b&oe=5F341828",
                "https://scontent-lga3-2.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/106791457_195441138583871_9165743487135213000_n.jpg?_nc_ht=scontent-lga3-2.cdninstagram.com&_nc_cat=111&_nc_ohc=JoHOOlqpMdoAX92lDTk&oh=acc7b90dbed045e9fab0b84a15d10fa0&oe=5F352BAD",
                "https://scontent-lga3-1.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/107941960_409261289975812_4780039277593141078_n.jpg?_nc_ht=scontent-lga3-1.cdninstagram.com&_nc_cat=104&_nc_ohc=TfMIl2xFXdYAX93t24Y&oh=d9864959158be3b2cbd78890adfa7a4a&oe=5F340C9B",
                "https://scontent-lga3-2.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/106274921_194035542025500_8850270562135480460_n.jpg?_nc_ht=scontent-lga3-2.cdninstagram.com&_nc_cat=100&_nc_ohc=sYlNjl5-9wUAX9ieN-R&oh=9a2f2170cc7a106719445b3c66bbff13&oe=5F356A8D"

        };

        ArrayList<BeritaModel> data = new ArrayList<>();

        for (int i=0; i < image.length; i++) {
            BeritaModel model = new BeritaModel();
            model.setImage(image[i]);
            model.setTitle(judul[i]);
            model.setDeskrisi(deskripsi[i]);
            data.add(model);
        }

        adapterBerita.addAll(data);
        adapterBerita.notifyDataSetChanged();

    }
}
