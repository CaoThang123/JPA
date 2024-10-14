package vn.iotstar.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID tự động tăng
    @Column(name = "UserId")
    private int id;

    @Column(name = "Username", columnDefinition = "NVARCHAR(50)")
    @NotEmpty(message = "Username không được để trống")
    private String username;

    @Column(name = "Email", columnDefinition = "NVARCHAR(100)")
    @NotEmpty(message = "Email không được để trống")
    private String email;

    @Column(name = "Password", columnDefinition = "NVARCHAR(100)")
    @NotEmpty(message = "Password không được để trống")
    private String password;

    @Column(name = "Fullname", columnDefinition = "NVARCHAR(100)")
    private String fullname;

    @Column(name = "Images", columnDefinition = "NVARCHAR(500) NULL")
    private String images;

    @Column(name = "Phone", columnDefinition = "NVARCHAR(15) NULL")
    private String phone;

    @Column(name = "RoleId", columnDefinition = "NVARCHAR(50)")
    private String roleid;

    @Temporal(TemporalType.DATE) // Lưu ngày tháng
    @Column(name = "CreateDate")
    private Date createDate;

    // Constructor không tham số (bắt buộc trong JPA)
    public User() {}

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
