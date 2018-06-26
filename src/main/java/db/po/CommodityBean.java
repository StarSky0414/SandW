package db.po;

import javax.persistence.*;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
@Entity
@Table(name = "commodity", schema = "sandw", catalog = "")
public class CommodityBean implements POProvider{
    private int id;
    private String photoDoc;
    private Integer brandId;
    private Integer showState;
    private String shotDescribe;
    private Byte sex;
    private String bigRange;
    private String smallRange;
    private String langDescribe;

    public CommodityBean(int id) {
        this.id = id;
    }

    public CommodityBean() {
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
    @Column(name = "photo_doc", nullable = true, length = 50)
    public String getPhotoDoc() {
        return photoDoc;
    }

    public void setPhotoDoc(String photoDoc) {
        this.photoDoc = photoDoc;
    }

    @Basic
    @Column(name = "brand_id", nullable = true)
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "show_state", nullable = true)
    public Integer getShowState() {
        return showState;
    }

    public void setShowState(Integer showState) {
        this.showState = showState;
    }

    @Basic
    @Column(name = "shot_describe", nullable = true, length = 300)
    public String getShotDescribe() {
        return shotDescribe;
    }

    public void setShotDescribe(String shotDescribe) {
        this.shotDescribe = shotDescribe;
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
    @Column(name = "big_range", nullable = true, length = 30)
    public String getBigRange() {
        return bigRange;
    }

    public void setBigRange(String bigRange) {
        this.bigRange = bigRange;
    }

    @Basic
    @Column(name = "small_range", nullable = true, length = 30)
    public String getSmallRange() {
        return smallRange;
    }

    public void setSmallRange(String smallRange) {
        this.smallRange = smallRange;
    }

    @Basic
    @Column(name = "lang_describe", nullable = true, length = -1)
    public String getLangDescribe() {
        return langDescribe;
    }

    public void setLangDescribe(String langDescribe) {
        this.langDescribe = langDescribe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommodityBean that = (CommodityBean) o;

        if (id != that.id) return false;
        if (photoDoc != null ? !photoDoc.equals(that.photoDoc) : that.photoDoc != null) return false;
        if (brandId != null ? !brandId.equals(that.brandId) : that.brandId != null) return false;
        if (showState != null ? !showState.equals(that.showState) : that.showState != null) return false;
        if (shotDescribe != null ? !shotDescribe.equals(that.shotDescribe) : that.shotDescribe != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (bigRange != null ? !bigRange.equals(that.bigRange) : that.bigRange != null) return false;
        if (smallRange != null ? !smallRange.equals(that.smallRange) : that.smallRange != null) return false;
        if (langDescribe != null ? !langDescribe.equals(that.langDescribe) : that.langDescribe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (photoDoc != null ? photoDoc.hashCode() : 0);
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (showState != null ? showState.hashCode() : 0);
        result = 31 * result + (shotDescribe != null ? shotDescribe.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (bigRange != null ? bigRange.hashCode() : 0);
        result = 31 * result + (smallRange != null ? smallRange.hashCode() : 0);
        result = 31 * result + (langDescribe != null ? langDescribe.hashCode() : 0);
        return result;
    }
}
