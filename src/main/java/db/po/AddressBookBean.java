package db.po;

import javax.persistence.*;

@Entity
@Table(name = "address_book", schema = "sandw", catalog = "")
public class AddressBookBean implements POProvider {
    private int id;
    private String userNum;
    private String surName;
    private String name;
    private String country;
    private String province;
    private String city;
    private String address;
    private String postCode;
    private String phone;
    private Byte deleSign;

    public AddressBookBean(String userNum, String surName, String name, String country, String province, String city, String address, String postCode, String phone) {
        this.userNum = userNum;
        this.surName = surName;
        this.name = name;
        this.country = country;
        this.province = province;
        this.city = city;
        this.address = address;
        this.postCode = postCode;
        this.phone = phone;
        this.deleSign=0;
    }

    public AddressBookBean() {
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
    @Column(name = "sur_name", nullable = true, length = 20)
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 20)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 20)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 20)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "post_code", nullable = true, length = 20)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

        AddressBookBean that = (AddressBookBean) o;

        if (id != that.id) return false;
        if (userNum != null ? !userNum.equals(that.userNum) : that.userNum != null) return false;
        if (surName != null ? !surName.equals(that.surName) : that.surName != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (postCode != null ? !postCode.equals(that.postCode) : that.postCode != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (deleSign != null ? !deleSign.equals(that.deleSign) : that.deleSign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userNum != null ? userNum.hashCode() : 0);
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (deleSign != null ? deleSign.hashCode() : 0);
        return result;
    }
}
