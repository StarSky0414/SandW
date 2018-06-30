package bean.json;

/**
 * starsky  make file at 2018/6/30
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class FourRecommendationJsonBean {
    private int id;
    private String photoDoc;
    private String brandName;
    private String money;

    public int getId() {
        return id;
    }

    public FourRecommendationJsonBean(int id, String photoDoc, String brandName, String money) {
        this.id=id;
        this.photoDoc = photoDoc;
        this.brandName = brandName;
        this.money = money;
    }

    public String getPhotoDoc() {
        return photoDoc;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getMoney() {
        return money;
    }
}
