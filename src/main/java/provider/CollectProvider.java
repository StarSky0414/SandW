package provider;

import db.po.CollectBean;
import db.utiles.DBUtile;

import java.util.HashMap;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class CollectProvider {

    public static List<CollectBean> queryCollectList(int userId){
        String hql="from CollectBean collect where collect.userId =:userId and collect.deleSign=0";
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("userId",String.valueOf(userId));
        List<CollectBean> collectList = DBUtile.queryInfoList(hql, param);
        return collectList;
    }

    public static void insertCollect(int userId,int commodityId){
        CollectBean collectBean = new CollectBean(String.valueOf(userId), String.valueOf(commodityId));
        DBUtile.saveInfo(collectBean);
    }

    public static CollectBean queryCollectInfo(int userId, int commodity){
        String hql="from CollectBean collect where collect.userId =:userId and collect.commodity=:commodity";
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("userId",String.valueOf(userId));
        param.put("commodity",String.valueOf(commodity));
        List<CollectBean> collectList = DBUtile.queryInfoList(hql, param);
        if (collectList==null){
            return null;
        }
        return collectList.get(0);
    }
//    public static void deleCollect(){
//
//        DBUtile.upData();
//    }
}
