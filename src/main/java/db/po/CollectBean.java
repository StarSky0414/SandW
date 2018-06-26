package db.po;

import javax.persistence.*;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
@Entity
@Table(name = "collect", schema = "sandw", catalog = "")
public class CollectBean implements POProvider{
    private int id;
    private String userId;
    private String commodity;
    private Byte deleSign;

    public CollectBean(String userId, String commodity) {
        this.userId = userId;
        this.commodity = commodity;
        this.deleSign = 0;
    }

    public CollectBean() {
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
    @Column(name = "commodity", nullable = true, length = 50)
    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
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

        CollectBean that = (CollectBean) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (commodity != null ? !commodity.equals(that.commodity) : that.commodity != null) return false;
        if (deleSign != null ? !deleSign.equals(that.deleSign) : that.deleSign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (commodity != null ? commodity.hashCode() : 0);
        result = 31 * result + (deleSign != null ? deleSign.hashCode() : 0);
        return result;
    }
}
