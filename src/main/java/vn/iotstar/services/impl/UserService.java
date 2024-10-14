package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IUser;
import vn.iotstar.dao.impl.UserDao;
import vn.iotstar.entity.User;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService{

	 // Khởi tạo đối tượng UserDao để gọi các phương thức DAO
    private IUser userDao = new UserDao();

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public List<User> findAll(int page, int pagesize) {
        return userDao.findAll(page, pagesize);
    }

    @Override
    public List<User> findByUsername(String uname) {
        return userDao.findByUsername(uname);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int userid) {
        return userDao.findById(userid);
    }

    @Override
    public void delete(int userid) throws Exception {
        userDao.delete(userid);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

}
