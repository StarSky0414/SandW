package bean.json;

/**
 * starsky  make file at 2018/7/6
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class ShoppingFormBean {
    private String photo_doc;
    private String money;
    private String brandName;
    private int stockNum;
    private String size;
    private int count;
    private int commodityId;

    public int getCommodityId() {
        return commodityId;
    }

    public ShoppingFormBean(String photo_doc, String money, String brandName, int stockNum, String size, int count, int commodityId) {
        this.photo_doc = photo_doc;
        this.money = money;
        this.brandName = brandName;
        this.stockNum = stockNum;
        this.size = size;
        this.count = count;
        this.commodityId=commodityId;
    }

    public String getPhoto_doc() {
        return photo_doc;
    }

    public String getMoney() {
        return money;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getStockNum() {
        return stockNum;
    }

    public String getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }
}
