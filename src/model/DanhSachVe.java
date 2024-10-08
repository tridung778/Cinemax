package model;

/**
 *
 * @author Tri Dung
 */
public class DanhSachVe {

    String veID, tenPhim, suatChieuID, caChieu, tenPhong, thoiGianBatDau, ghe, loaiVe, giaVe, ngayMua;

    public String getVeID() {
        return veID;
    }

    public void setVeID(String veID) {
        this.veID = veID;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getSuatChieuID() {
        return suatChieuID;
    }

    public void setSuatChieuID(String suatChieuID) {
        this.suatChieuID = suatChieuID;
    }

    public String getCaChieu() {
        return caChieu;
    }

    public void setCaChieu(String caChieu) {
        this.caChieu = caChieu;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getGhe() {
        return ghe;
    }

    public void setGhe(String ghe) {
        this.ghe = ghe;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }

    public String getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(String giaVe) {
        this.giaVe = giaVe;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public DanhSachVe() {
    }

    public DanhSachVe(String veID, String tenPhim, String suatChieuID, String caChieu, String tenPhong, String thoiGianBatDau, String ghe, String loaiVe, String giaVe, String ngayMua) {
        this.veID = veID;
        this.tenPhim = tenPhim;
        this.suatChieuID = suatChieuID;
        this.caChieu = caChieu;
        this.tenPhong = tenPhong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.ghe = ghe;
        this.loaiVe = loaiVe;
        this.giaVe = giaVe;
        this.ngayMua = ngayMua;
    }


}
