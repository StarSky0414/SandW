package provider;

import bean.json.CommendationListJsonBean;
import db.po.CollectBean;
import db.utiles.DBUtile;

import java.util.ArrayList;
import java.util.List;

/**
 * starsky  make file at 2018/7/9
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class CollectProvider {

    public ArrayList<CommendationListJsonBean> collectSelect(int userId){
        String sql="select   commodity.id, \n" +
                "         commodity.photo_doc, \n" +
                "         commodity.money, \n" +
                "         brand.brand_name\n" +
                "from collect,commodity ,brand\n" +
                "where commodity.id=collect.commodity and\n" +
                "      commodity.brand_id=brand.id and\n" +
                "collect.dele_sign=0 and collect.user_id=?";
        ArrayList arrayList = new ArrayList();
        arrayList.add(userId);
        List list = DBUtile.queryInfoBySQL(sql, arrayList);
        ArrayList<CommendationListJsonBean> commendationListJsonBeanArrayList = new ArrayList<CommendationListJsonBean>();
        for (int i=0;i<list.size();i++){
            Object[] paramArray = (Object[]) list.get(i);
            CommendationListJsonBean CommendationListJsonBean = new CommendationListJsonBean(
                    (Integer) paramArray[0],
                    (String) paramArray[1],
                    (String) paramArray[3],
                    (String) paramArray[2]);
            commendationListJsonBeanArrayList.add(CommendationListJsonBean);
        }

        return commendationListJsonBeanArrayList;
    }

    public void collectAdd(String userId,String commodity){
        CollectBean collectBean = new CollectBean(userId, commodity);
        DBUtile.saveInfo(collectBean);
    }

    public void collectdele(String userId, String commendationId) {
        String sql="update collect set  collect.dele_sign=1 where collect.user_id=? and collect.commodity=?";
        ArrayList arrayList = new ArrayList();
        arrayList.add(userId);
        arrayList.add(commendationId);
        DBUtile.updateInfoBySQL(sql,arrayList);
    }
}
