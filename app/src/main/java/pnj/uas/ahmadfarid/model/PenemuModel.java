package pnj.uas.ahmadfarid.model;

public class PenemuModel {
String id;
    String nama;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    String tlp;
    String email;
    String alamat;

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTgl_nemu() {
        return tgl_nemu;
    }

    public void setTgl_nemu(String tgl_nemu) {
        this.tgl_nemu = tgl_nemu;
    }

    String lokasi;
    String tgl_nemu;


}
