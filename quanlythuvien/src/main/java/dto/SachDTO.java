package dto;

public class SachDTO {
    private int maSach;
    private String tenSach;
    private int maLoai;
    private int maNXB;
    private int maTacGia;
    private int namXB;
    private int soLuong;
    private int maKeSach;
    private String hinhAnh;

    // Constructor mặc định
    public SachDTO() {
    }

    // Constructor đầy đủ tham số
    public SachDTO(int maSach, String tenSach, int maLoai, int maNXB, int maTacGia, int namXB, int soLuong,
            int maKeSach,
            String hinhAnh) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maLoai = maLoai;
        this.maNXB = maNXB;
        this.maTacGia = maTacGia;
        this.namXB = namXB;
        this.soLuong = soLuong;
        this.maKeSach = maKeSach;
        this.hinhAnh = hinhAnh;
    }

    // Constructor không có mã sách (dùng khi thêm mới)
    public SachDTO(String tenSach, int maLoai, int maNXB, int maTacGia, int namXB, int soLuong, int maKeSach,
            String hinhAnh) {
        this.tenSach = tenSach;
        this.maLoai = maLoai;
        this.maNXB = maNXB;
        this.maTacGia = maTacGia;
        this.namXB = namXB;
        this.soLuong = soLuong;
        this.maKeSach = maKeSach;
        this.hinhAnh = hinhAnh;
    }

    // Tạo constructor mới lấy từ một SachDTO khác
    public void setFromSachDTO(SachDTO sach) {
        if (sach != null) {
            this.maSach = sach.maSach;
            this.tenSach = sach.tenSach;
            this.maLoai = sach.maLoai;
            this.maNXB = sach.maNXB;
            this.maTacGia = sach.maTacGia;
            this.namXB = sach.namXB;
            this.soLuong = sach.soLuong;
            this.maKeSach = sach.maKeSach;
            this.hinhAnh = sach.hinhAnh;
        }
    }

    public SachDTO(int i, String tensach, String maloai, String manxb, String matg, int namxb, int soluong, String make,
            String hinhanh) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Getter và Setter
    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public int getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(int maNXB) {
        this.maNXB = maNXB;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getMaKeSach() {
        return maKeSach;
    }

    public void setMaKeSach(int maKeSach) {
        this.maKeSach = maKeSach;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        this.maTacGia = maTacGia;
    }

    public int getMaKe() {
        return maKeSach;
    }
}