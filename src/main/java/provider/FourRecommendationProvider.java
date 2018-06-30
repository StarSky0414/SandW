package provider;

import bean.json.FourRecommendationJsonBean;
import db.utiles.DBUtile;

import java.util.ArrayList;
import java.util.List;

/**
 * starsky  make file at 2018/6/30
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class FourRecommendationProvider {

    public ArrayList<FourRecommendationJsonBean> fourRecommendationBySmallRange(String smallRange){
        String sql="select\n" +
                "  commodity.id,\n" +
                "  commodity.photo_doc,\n" +
                "  commodity.money,\n" +
                "  brand.brand_name\n" +
                "from commodity,brand\n" +
                "where brand.id=commodity.brand_id and commodity.small_range=?\n" +
                "order by id desc limit 0,4;";
        ArrayList arrayList = new ArrayList();
        arrayList.add(smallRange);
        List list = DBUtile.queryInfoBySQL(sql, arrayList);

        ArrayList<FourRecommendationJsonBean> fourRecommendationJsonBeanArrayList = new ArrayList<FourRecommendationJsonBean>();
        for (int i=0;i<list.size();i++){
            Object[] paramArray = (Object[]) list.get(i);
            FourRecommendationJsonBean fourRecommendationJsonBean = new FourRecommendationJsonBean(
                    (Integer) paramArray[0],
                    (String) paramArray[1],
                    (String) paramArray[3],
                    (String) paramArray[2]);
            fourRecommendationJsonBeanArrayList.add(fourRecommendationJsonBean);
        }

        return fourRecommendationJsonBeanArrayList;

    }
}
