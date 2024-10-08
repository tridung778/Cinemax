/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.BieuDoDoanhThu;
import model.DanhSachVe;
import model.TimVe;
import model.Ve;

/**
 *
 * @author 123tu
 */
public class VeDAO extends CinemaxDAO<Ve, String> {

    final String INSERT_SQL = "INSERT INTO Ve (SuatChieuID, Ghe, GiaVe, NgayMua, LoaiVe) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Ve SET SuatChieuID=?, Ghe=?, GiaVe=?, NgayMua=?, LoaiVe=? WHERE VeID=?";
    final String DELETE_SQL = "DELETE FROM Ve WHERE VeID=?";
    final String SELECT_ALL_SQL = "SELECT * FROM Ve";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Ve WHERE VeID=?";
    final String SELECT_TICKET = "SELECT SuatChieu.SuatChieuID, CaChieu,Phim.TenPhim, PhongChieu.PhongID, NgayTaoXuat "
            + "FROM SuatChieu "
            + "JOIN Phim ON SuatChieu.PhimID = Phim.PhimID "
            + "JOIN PhongChieu ON SuatChieu.PhongID = PhongChieu.PhongID "
            + "WHERE Phim.TenPhim = ? AND PhongChieu.PhongID = ? AND NgayTaoXuat like ?"
            + "group by SuatChieu.SuatChieuID";

    final String SELECT_VEID = "select VeID from Ve\n"
            + "ORDER BY VeID\n"
            + "DESC\n"
            + "LIMIT ?";

    final String SELECT_DANHSACHVE = "select VeID,TenPhim,Ve.SuatChieuID,SuatChieu.CaChieu,PhongChieu.PhongID,NgayTaoXuat,Ghe,LoaiVe,GiaVe,NgayMua from SuatChieu\n"
            + "Join Ve\n"
            + "on SuatChieu.SuatChieuID = Ve.SuatChieuID\n"
            + "JOIN Phim\n"
            + "on SuatChieu.PhimID = Phim.PhimID\n"
            + "Join PhongChieu\n"
            + "on SuatChieu.PhongID = PhongChieu.PhongID\n"
            + "where LoaiVe like ? and TenPhim = ? and PhongChieu.PhongID = ? and NgayTaoXuat like ?";

    final String SELECT_TIMGHE = "select Ghe from Ve\n"
            + "inner join SuatChieu SC\n"
            + "on Ve.SuatChieuID = SC.SuatChieuID\n"
            + "where SC.SuatChieuID = ?";

    final String SELECT_ALL_DANHSACH = "select VeID,TenPhim,Ve.SuatChieuID,SuatChieu.CaChieu,PhongChieu.PhongID,NgayTaoXuat,Ghe,LoaiVe,GiaVe,NgayMua from SuatChieu\n"
            + "            Join Ve\n"
            + "            on SuatChieu.SuatChieuID = Ve.SuatChieuID\n"
            + "            JOIN Phim\n"
            + "            on SuatChieu.PhimID = Phim.PhimID\n"
            + "           Join PhongChieu\n"
            + "            on SuatChieu.PhongID = PhongChieu.PhongID\n"
            + "           ORDER BY VeID\n"
            + "ASC";

    final String SELECT_ALL_VE = "SELECT\n"
            + "    SuatChieuID,\n"
            + "    CaChieu,\n"
            + "    Phim.TenPhim,\n"
            + "    PhongChieu.PhongID,\n"
            + "    NgayTaoXuat\n"
            + "FROM SuatChieu\n"
            + "JOIN Phim ON SuatChieu.PhimID = Phim.PhimID\n"
            + "JOIN PhongChieu ON SuatChieu.PhongID = PhongChieu.PhongID\n"
            + "WHERE\n"
            + "  (NgayTaoXuat > CURRENT_DATE)\n"
            + "  OR (\n"
            + "    NgayTaoXuat = CURRENT_DATE AND\n"
            + "    CaChieu IN (\n"
            + "      'Suất 1 (7h-9h)', 'Suất 2 (9h-11h)', 'Suất 3 (13h-15h)',\n"
            + "      'Suất 4 (15h-17h)', 'Suất 5 (17h-19h)', 'Suất 6 (19h-21h)', 'Suất 7 (21h-23h)'\n"
            + "    )\n"
            + "    AND ? BETWEEN\n"
            + "      CONCAT(CURRENT_DATE, ' ', SUBSTRING_INDEX(SUBSTRING_INDEX(CaChieu, '(', -1), '-', 1))\n"
            + "      AND CONCAT(CURRENT_DATE, ' ', SUBSTRING_INDEX(SUBSTRING_INDEX(CaChieu, '-', -1), ')', 1))\n"
            + "  )\n"
            + "ORDER BY NgayTaoXuat, CaChieu;";

    final String SELECT_DOANHTHU = "SELECT Phim.TenPhim,\n"
            + "       SUM(Ve.GiaVe)                                   AS TongDoanhThu,\n"
            + "       COUNT(Ghe)                                      as SoLuongVe,\n"
            + "       GiaPhim,\n"
            + "       CAST(SUM(Ve.GiaVe) - GiaPhim AS DECIMAL(20, 0)) as LoiNhuan\n"
            + "FROM Phim\n"
            + "         JOIN\n"
            + "     SuatChieu ON Phim.PhimID = SuatChieu.PhimID\n"
            + "         JOIN\n"
            + "     Ve ON SuatChieu.SuatChieuID = Ve.SuatChieuID\n"
            + "GROUP BY Phim.TenPhim;";
    final String SELECT_BIEUDODOANHTHU = "SELECT\n"
            + "    Phim.TenPhim,\n"
            + "    SUM(Ve.GiaVe) AS TongDoanhThu\n"
            + "FROM\n"
            + "    Phim\n"
            + "JOIN\n"
            + "    SuatChieu ON Phim.PhimID = SuatChieu.PhimID\n"
            + "JOIN\n"
            + "    Ve ON SuatChieu.SuatChieuID = Ve.SuatChieuID\n"
            + "GROUP BY\n"
            + "    Phim.TenPhim;";

    @Override
    public void insert(Ve entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMaSC(), entity.getGhe(), entity.getGiaVe(), entity.getNgayMua(), entity.getLoaiVe());
    }

    @Override
    public void update(Ve entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getMaSC(), entity.getGhe(), entity.getGiaVe(), entity.getNgayMua(), entity.getLoaiVe(), entity.getMaVe());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Ve> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Ve selectById(String id) {
        List<Ve> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Ve> selectBySql(String sql, Object... args) {
        List<Ve> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Ve entity = new Ve();
                entity.setMaVe(rs.getString("VeID"));
                entity.setMaSC(rs.getString("SuatChieuID"));
                entity.setGhe(rs.getString("Ghe"));
                entity.setGiaVe(rs.getDouble("GiaVe"));
                entity.setNgayMua(rs.getString("NgayMua"));
                entity.setLoaiVe(rs.getString("LoaiVe"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<TimVe> findTicket(String ThoiGian, String PhongChieu, String Phim) {
        List<TimVe> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(SELECT_TICKET, Phim, PhongChieu, ThoiGian + "%");
            while (rs.next()) {
                TimVe entity = new TimVe();
                entity.setCaChieu(rs.getString("CaChieu"));
                entity.setMaSuatChieu(rs.getString("SuatChieuID"));
                entity.setTenPhim(rs.getString("TenPhim"));
                entity.setTenPhong(rs.getString("PhongID"));
                entity.setThoiGianChieu(rs.getString("NgayTaoXuat"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String findVeID() {
        Object veID = "";
        try {
            veID = JDBCHelper.value(SELECT_VEID, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veID + "";
    }

    public List<DanhSachVe> inDanhSachVe(String loaiVe, String tenPhim, String tenPhong, String thoiGianBatDau) {
        List<DanhSachVe> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(SELECT_DANHSACHVE, "%" + loaiVe + "%", tenPhim, tenPhong, thoiGianBatDau + "%");
            while (rs.next()) {
                DanhSachVe entity = new DanhSachVe();
                entity.setCaChieu(rs.getString("CaChieu"));
                entity.setSuatChieuID(rs.getString("SuatChieuID"));
                entity.setGhe(rs.getString("Ghe"));
                entity.setGiaVe(rs.getString("GiaVe"));
                entity.setLoaiVe(rs.getString("LoaiVe"));
                entity.setNgayMua(rs.getString("NgayMua"));
                entity.setTenPhim(rs.getString("TenPhim"));
                entity.setTenPhong(rs.getString("PhongID"));
                entity.setThoiGianBatDau(rs.getString("NgayTaoXuat"));
                entity.setVeID(rs.getString("VeID"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> timGhe(String suatChieuID) {
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(SELECT_TIMGHE, suatChieuID);
            while (rs.next()) {
                list.add(rs.getString("Ghe"));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<TimVe> inTatCaVe(String ngayHienTai) {
        List<TimVe> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(SELECT_ALL_VE, ngayHienTai);
            while (rs.next()) {
                TimVe entity = new TimVe();
                entity.setCaChieu(rs.getString("CaChieu"));
                entity.setMaSuatChieu(rs.getString("SuatChieuID"));
                entity.setTenPhim(rs.getString("TenPhim"));
                entity.setTenPhong(rs.getString("PhongID"));
                entity.setThoiGianChieu(rs.getString("NgayTaoXuat"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<DanhSachVe> inTatCaDanhSachVe() {
        List<DanhSachVe> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(SELECT_ALL_DANHSACH);
            while (rs.next()) {
                DanhSachVe entity = new DanhSachVe();
                entity.setCaChieu(rs.getString("CaChieu"));
                entity.setSuatChieuID(rs.getString("SuatChieuID"));
                entity.setGhe(rs.getString("Ghe"));
                entity.setGiaVe(rs.getString("GiaVe"));
                entity.setLoaiVe(rs.getString("LoaiVe"));
                entity.setNgayMua(rs.getString("NgayMua"));
                entity.setTenPhim(rs.getString("TenPhim"));
                entity.setTenPhong(rs.getString("PhongID"));
                entity.setThoiGianBatDau(rs.getString("NgayTaoXuat"));
                entity.setVeID(rs.getString("VeID"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> inDoanhThu() {
        List<String> list = new ArrayList<>();
        int STT = 0;
        try {
            ResultSet rs = JDBCHelper.query(SELECT_DOANHTHU);
            while (rs.next()) {
                STT++;
                String tenPhim = rs.getString("TenPhim");
                String soVe = rs.getString("SoLuongVe");
                String tongDoanhThu = rs.getString("TongDoanhThu");
                String giaPhim = rs.getString("GiaPhim");
                String loiNhuan = rs.getString("LoiNhuan");
                list.add(STT + "," + tenPhim + "," + soVe + "," + tongDoanhThu + "," + giaPhim + "," + loiNhuan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<BieuDoDoanhThu> inBieuDo() {
        List<BieuDoDoanhThu> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(SELECT_BIEUDODOANHTHU);
            while (rs.next()) {
                BieuDoDoanhThu entity = new BieuDoDoanhThu();
                entity.setTenPhim(rs.getString("TenPhim"));
                entity.setTongDoanhThu(rs.getInt("TongDoanhThu"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
