package dao;

import dto.PhieuMuonDTO;
import java.sql.*;
import java.util.ArrayList;

public class PhieuMuonDAO {
    private Connection conn;

    public PhieuMuonDAO() {
        this.conn = DBConnect.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu!");
        }
    }

    public ArrayList<PhieuMuonDTO> getAll() {
        ArrayList<PhieuMuonDTO> phieumuonlist = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM phieumuon";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PhieuMuonDTO phieumuon = new PhieuMuonDTO();
                phieumuon.setMaPhieuMuon(rs.getInt("maphieumuon"));
                phieumuon.setMaNV(rs.getInt("manv"));
                phieumuon.setMaDocGia(rs.getInt("madocgia"));
                phieumuon.setNgayMuon(rs.getDate("ngaymuon"));
                phieumuon.setTinhTrang(rs.getString("tinhtrang"));
                phieumuonlist.add(phieumuon);
            }
            System.out.println("getAll trả về " + phieumuonlist.size() + " phiếu mượn");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong getAll: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // Trả về danh sách rỗng để tránh null
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return phieumuonlist;
    }

    public PhieuMuonDTO getById(int maPhieuMuon) {
        PhieuMuonDTO phieumuon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM phieumuon WHERE maphieumuon = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maPhieuMuon);
            rs = stmt.executeQuery();

            if (rs.next()) {
                phieumuon = new PhieuMuonDTO();
                phieumuon.setMaPhieuMuon(rs.getInt("maphieumuon"));
                phieumuon.setMaNV(rs.getInt("manv"));
                phieumuon.setMaDocGia(rs.getInt("madocgia"));
                phieumuon.setNgayMuon(rs.getDate("ngaymuon"));
                phieumuon.setTinhTrang(rs.getString("tinhtrang"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return phieumuon;
    }

    public boolean insert(PhieuMuonDTO phieumuon) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "INSERT INTO phieumuon (manv, madocgia, ngaymuon, tinhtrang) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, phieumuon.getMaNV());
            stmt.setInt(2, phieumuon.getMaDocGia());
            stmt.setDate(3, new java.sql.Date(phieumuon.getNgayMuon().getTime()));
            stmt.setString(4, phieumuon.getTinhTrang());

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean update(PhieuMuonDTO phieumuon) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "UPDATE phieumuon SET manv = ?, madocgia = ?, ngaymuon = ?, tinhtrang = ? WHERE maphieumuon = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, phieumuon.getMaNV());
            stmt.setInt(2, phieumuon.getMaDocGia());
            stmt.setDate(3, new java.sql.Date(phieumuon.getNgayMuon().getTime()));
            stmt.setString(4, phieumuon.getTinhTrang());
            stmt.setInt(5, phieumuon.getMaPhieuMuon());

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean delete(int maPhieuMuon) {
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "DELETE FROM phieumuon WHERE maphieumuon = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maPhieuMuon);

            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối trong PhieuMuonDAO thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}