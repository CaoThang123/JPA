package vn.iotstar.services;

import java.util.List;

import vn.iotstar.entity.User;

public interface IUserService {
	int count(); // Đếm tổng số User trong CSDL

    List<User> findAll(int page, int pagesize); // Lấy danh sách User có phân trang

    List<User> findByUsername(String uname); // Tìm User theo username

    List<User> findAll(); // Lấy tất cả User

    User findById(int userid); // Tìm User theo ID

    void delete(int userid) throws Exception; // Xóa User theo ID

    void update(User user); // Cập nhật thông tin User

    void insert(User user); // Thêm mới User
}
