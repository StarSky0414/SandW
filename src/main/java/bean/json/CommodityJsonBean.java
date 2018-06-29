package bean.json;

import java.math.BigInteger;
import java.util.List;

/**
 * starsky  make file at 2018/6/29
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class CommodityJsonBean {
    private int id;
    private String money;
    private String photoDoc;
    private byte showState;
    private int brandId;
    private String smallRange;
    private byte sex;
    private String langDescribe;
    private String shortDescribe;
    private String brandName;
    private String brandCountry;
    private String brandDescribe;
    private BigInteger collectSign;

    private List sizeStock;

    public int getId() {
        return id;
    }

    public String getMoney() {
        return money;
    }

    public String getPhotoDoc() {
        return photoDoc;
    }

    public byte getShowState() {
        return showState;
    }

    public int getBrandId() {
        return brandId;
    }

    public String getSmallRange() {
        return smallRange;
    }

    public byte getSex() {
        return sex;
    }

    public String getLangDescribe() {
        return langDescribe;
    }

    public String getShortDescribe() {
        return shortDescribe;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public String getBrandDescribe() {
        return brandDescribe;
    }

    public BigInteger getCollectSign() {
        return collectSign;
    }

    public List getSizeStock() {
        return sizeStock;
    }

    public void setSizeStock(List sizeStock) {
        this.sizeStock = sizeStock;
    }

    public CommodityJsonBean(int id, String money, String photoDoc, byte showState, int brandId, String smallRange, byte sex, String langDescribe, String shortDescribe, String brandName, String brandCountry, String brandDescribe,BigInteger collectSign) {
        this.id = id;
        this.money = money;
        this.photoDoc = photoDoc;
        this.showState = showState;
        this.brandId = brandId;
        this.smallRange = smallRange;
        this.sex = sex;
        this.langDescribe = langDescribe;
        this.shortDescribe = shortDescribe;
        this.brandName = brandName;
        this.brandCountry = brandCountry;
        this.brandDescribe = brandDescribe;
        this.collectSign=collectSign;
    }
}
