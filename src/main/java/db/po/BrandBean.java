package db.po;

import javax.persistence.*;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
@Entity
@Table(name = "brand", schema = "sandw", catalog = "")
public class BrandBean implements POProvider{
    private int id;
    private String brandName;
    private String brandDescribe;
    private String brandCountry;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brand_name", nullable = true, length = 30)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "brand_describe", nullable = true, length = -1)
    public String getBrandDescribe() {
        return brandDescribe;
    }

    public void setBrandDescribe(String brandDescribe) {
        this.brandDescribe = brandDescribe;
    }

    @Basic
    @Column(name = "brand_country", nullable = true, length = 30)
    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandBean brandBean = (BrandBean) o;

        if (id != brandBean.id) return false;
        if (brandName != null ? !brandName.equals(brandBean.brandName) : brandBean.brandName != null) return false;
        if (brandDescribe != null ? !brandDescribe.equals(brandBean.brandDescribe) : brandBean.brandDescribe != null)
            return false;
        if (brandCountry != null ? !brandCountry.equals(brandBean.brandCountry) : brandBean.brandCountry != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (brandDescribe != null ? brandDescribe.hashCode() : 0);
        result = 31 * result + (brandCountry != null ? brandCountry.hashCode() : 0);
        return result;
    }
}
