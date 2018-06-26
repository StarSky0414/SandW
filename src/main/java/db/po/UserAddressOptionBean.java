package db.po;

import javax.persistence.*;

@Entity
@Table(name = "user_address_option", schema = "sandw", catalog = "")
public class UserAddressOptionBean implements POProvider{
    private int id;
    private String userNum;
    private String addressBookNum;
    private Byte deleSign;

    public UserAddressOptionBean( String userNum, String addressBookNum) {
        this.userNum = userNum;
        this.addressBookNum = addressBookNum;
        this.deleSign = 0;
    }

    public UserAddressOptionBean() {
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
    @Column(name = "userNum", nullable = true, length = 50)
    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Basic
    @Column(name = "address_book_num", nullable = true, length = 20)
    public String getAddressBookNum() {
        return addressBookNum;
    }

    public void setAddressBookNum(String addressBookNum) {
        this.addressBookNum = addressBookNum;
    }

    @Basic
    @Column(name = "dele_sign", nullable = true)
    public Byte getDeleSign() {
        return deleSign;
    }

    public void setDeleSign(Byte deleSign) {
        this.deleSign = deleSign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAddressOptionBean that = (UserAddressOptionBean) o;

        if (id != that.id) return false;
        if (userNum != null ? !userNum.equals(that.userNum) : that.userNum != null) return false;
        if (addressBookNum != null ? !addressBookNum.equals(that.addressBookNum) : that.addressBookNum != null)
            return false;
        if (deleSign != null ? !deleSign.equals(that.deleSign) : that.deleSign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userNum != null ? userNum.hashCode() : 0);
        result = 31 * result + (addressBookNum != null ? addressBookNum.hashCode() : 0);
        result = 31 * result + (deleSign != null ? deleSign.hashCode() : 0);
        return result;
    }
}
