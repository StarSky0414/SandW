package provider;

import bean.json.CommendationListJsonBean;
import db.utiles.DBUtile;

import java.util.ArrayList;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SearchProvider {

    public static List<String> getBigRangeList(String sexNum){
//        String hql="select DISTINCT(commodity.bigRange) from CommodityBean commodity";
//        List<String> bigRangeList = DBUtile.queryInfoList(hql);
        String sql="select distinct big_range from commodity where sex=?";
        ArrayList arrayList = new ArrayList();
        arrayList.add(sexNum);
        List bigRangeList = DBUtile.queryInfoBySQL(sql, arrayList);
        return bigRangeList;
    }
    public static List<Object[]> getItemRangeList(String bigRange,String sexNum){
//        String hql="select distinct commodity.smallRange from CommodityBean commodity where commodity.bigRange=:bigRange ";
//        HashMap<String, Object> param = new HashMap<String, Object>();
//        param.put("bigRange",bigRange);
//        List<Object[]> itemRangeList = DBUtile.queryInfoList(hql,param);
        String sql="select distinct small_range from commodity where big_range=? and sex=?";
        ArrayList arrayList = new ArrayList();
        arrayList.add(bigRange);
        arrayList.add(sexNum);
        List itemRangeList = DBUtile.queryInfoBySQL(sql, arrayList);
        return itemRangeList;
    }

    public static List<String> getBrandList(String sexNum){
//        String hql="select brandBean.brandName from BrandBean brandBean where ";
//        List<String> brandList = DBUtile.queryInfoList(hql);

        String sql="select  brand_name from brand where id in (select brand_id from commodity where sex=?)";
        ArrayList arrayList = new ArrayList();
        arrayList.add(sexNum);
        List brandList = DBUtile.queryInfoBySQL(sql, arrayList);
        return brandList;
    }

    public ArrayList<CommendationListJsonBean> descriptionVague(String desString){
        String sql="select commodity.id ,photo_doc,money,brand_name from commodity,brand where brand.id=brand_id and (lang_describe like ? or shot_describe like ?)";
        ArrayList<Object> param = new ArrayList<Object>();
        param.add("%"+desString+"%");
        param.add("%"+desString+"%");
        List list = DBUtile.queryInfoBySQL(sql, param);
        ArrayList<CommendationListJsonBean> CommendationListJsonBeans = parseSqlToList(list);
        return CommendationListJsonBeans;
    }

    public ArrayList<CommendationListJsonBean> rangeSearch(String rangeSearchString){
        String sql="select commodity.id ,photo_doc,money,brand_name from commodity,brand where brand.id=brand_id and (small_range=? or big_range=?)";
        ArrayList<Object> param = new ArrayList<Object>();
        param.add(rangeSearchString);
        param.add(rangeSearchString);
        List list = DBUtile.queryInfoBySQL(sql, param);
        ArrayList<CommendationListJsonBean> CommendationListJsonBeans = parseSqlToList(list);
        return CommendationListJsonBeans;
    }

    public ArrayList<CommendationListJsonBean> brandSearch(String brandSearchString){
        String sql="select commodity.id ,photo_doc,money,brand_name from commodity,brand where brand.id=brand_id and brand_name=?";
        ArrayList<Object> param = new ArrayList<Object>();
        param.add(brandSearchString);
        List list = DBUtile.queryInfoBySQL(sql, param);
        ArrayList<CommendationListJsonBean> CommendationListJsonBeans = parseSqlToList(list);
        return CommendationListJsonBeans;
    }

    private ArrayList<CommendationListJsonBean> parseSqlToList(List list){
        ArrayList<CommendationListJsonBean> commendationListJsonBeanArrayList = new ArrayList<CommendationListJsonBean>();
        for (int i=0;i<list.size();i++){
            Object[] paramArray = (Object[]) list.get(i);
            CommendationListJsonBean commodityListJsonBean = new CommendationListJsonBean(
                    (Integer) paramArray[0],
                    (String) paramArray[1],
                    (String) paramArray[3],
                    (String) paramArray[2]);
            commendationListJsonBeanArrayList.add(commodityListJsonBean);
        }
        return commendationListJsonBeanArrayList;
    }
}


