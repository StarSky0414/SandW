package manager;

import db.po.BrandBean;
import db.po.CommodityBean;
import db.po.POProvider;
import provider.BrandProvider;
import provider.CommodityProvider;
import utiles.BeanToMap;

import java.util.HashMap;

/**
 * starsky  make file at 2018/6/27
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class CommodityManager {

    public static HashMap<String, Object> commodityInfo(int brandId){
        CommodityBean commodityByBrand = CommodityProvider.queryCommodityById(brandId);
        BrandBean brandBean = BrandProvider.queryBrandInfo(brandId);
        HashMap<String, Object> commodityInfoMap = BeanToMap.mergeBeanToMap(new POProvider[]{brandBean, commodityByBrand});
        int id = (Integer) commodityInfoMap.get("id");

        return commodityInfoMap;
    }


}
