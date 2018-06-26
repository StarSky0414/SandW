package provider;

import db.utiles.DBUtile;

import java.util.HashMap;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SearchProvider {

    public static List<String> getBigRangeList(){
        String hql="select DISTINCT(commodity.bigRange) from CommodityBean commodity";
        List<String> bigRangeList = DBUtile.queryInfoList(hql);
        return bigRangeList;
    }
    public static List<Object[]> getItemRangeList(String bigRange){
        String hql="select commodity.smallRange from CommodityBean commodity where commodity.bigRange=:bigRange ";
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("bigRange",bigRange);
        List<Object[]> itemRangeList = DBUtile.queryInfoList(hql,param);
        return itemRangeList;
    }

    public static List<String> getBrandList(){
        String hql="select brandBean.brandName from BrandBean brandBean";
        List<String> brandList = DBUtile.queryInfoList(hql);
        return brandList;
    }
}
