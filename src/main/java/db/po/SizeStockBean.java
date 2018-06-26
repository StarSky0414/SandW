package db.po;

import javax.persistence.*;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
@Entity
@Table(name = "size_stock", schema = "sandw", catalog = "")
public class SizeStockBean implements POProvider{
    private int id;
    private Integer commodityId;
    private String size;
    private Integer stockNum;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "commodity_id", nullable = true)
    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    @Basic
    @Column(name = "size", nullable = true, length = 50)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "stock_num", nullable = true)
    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SizeStockBean that = (SizeStockBean) o;

        if (id != that.id) return false;
        if (commodityId != null ? !commodityId.equals(that.commodityId) : that.commodityId != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (stockNum != null ? !stockNum.equals(that.stockNum) : that.stockNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (commodityId != null ? commodityId.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (stockNum != null ? stockNum.hashCode() : 0);
        return result;
    }
}
