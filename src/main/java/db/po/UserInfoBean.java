package db.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import db.enumeration.UserSexEnum;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_info", schema = "sandw", catalog = "")
@JsonIgnoreProperties({"id","password"})
public class UserInfoBean implements POProvider {
    private int id;
    private String userNum;
    private String password;
    private Byte sex;
    private Date birthday;
    private String userName;
    private String nickName;


    public UserInfoBean(String userName, String password,String nickName) {
        this.password = password;
        this.userName = userName;
        this.nickName =nickName;
        this.sex = UserSexEnum.Girl.getSexNumber();
    }

    public UserInfoBean(Date birthday) {
        this.birthday = birthday;
    }

    public UserInfoBean() {
    }


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_num", nullable = true, length = 50)
    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoBean that = (UserInfoBean) o;

        if (id != that.id) return false;
        if (userNum != null ? !userNum.equals(that.userNum) : that.userNum != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userNum != null ? userNum.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 50)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickname) {
        this.nickName = nickname;
    }
}
