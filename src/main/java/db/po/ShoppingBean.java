package db.po;

import javax.persistence.*;

/**
 * starsky  make file at 2018/7/6
 * 代码是个艺术，请不要侮辱自己的审美
 */
@Entity
@Table(name = "shopping", schema = "sandw", catalog = "")
public class ShoppingBean implements POProvider{
    private int id;
    private String userId;
    private Integer sizeId;
    private Integer orderSign;
    private Integer deleSign;

    public ShoppingBean(String userId, Integer sizeId) {
        this.userId = userId;
        this.sizeId = sizeId;
        orderSign=0;
        deleSign=0;
    }

    public ShoppingBean() {
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
    @Column(name = "user_id", nullable = true, length = 50)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "size_id", nullable = true)
    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    @Basic
    @Column(name = "order_sign", nullable = true)
    public Integer getOrderSign() {
        return orderSign;
    }

    public void setOrderSign(Integer orderSign) {
        this.orderSign = orderSign;
    }

    @Basic
    @Column(name = "dele_sign", nullable = true)
    public Integer getDeleSign() {
        return deleSign;
    }

    public void setDeleSign(Integer deleSign) {
        this.deleSign = deleSign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingBean that = (ShoppingBean) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (sizeId != null ? !sizeId.equals(that.sizeId) : that.sizeId != null) return false;
        if (orderSign != null ? !orderSign.equals(that.orderSign) : that.orderSign != null) return false;
        if (deleSign != null ? !deleSign.equals(that.deleSign) : that.deleSign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (sizeId != null ? sizeId.hashCode() : 0);
        result = 31 * result + (orderSign != null ? orderSign.hashCode() : 0);
        result = 31 * result + (deleSign != null ? deleSign.hashCode() : 0);
        return result;
    }
}
