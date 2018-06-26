package provider;

import db.po.BrandBean;
import db.po.CommodityBean;
import db.utiles.DBUtile;

import java.util.HashMap;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class CommodityProvider {

    public static CommodityBean queryCommodityById(int commodityBeanId){
        String hql="from CommodityBean commodityBean where commodityBean.id=:commodityBeanId";
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("commodityBeanId",commodityBeanId);
        List<CommodityBean> commodityBeanList = DBUtile.queryInfoList(hql,param);
        CommodityBean commodityBean;
        if (commodityBeanList.size()!=0){
            commodityBean= commodityBeanList.get(0);
        }else {
            commodityBean=new CommodityBean(0);
        }
        return commodityBean;
    }

    public static List<BrandBean> queryCommodityByBrand(int brandId){
        String hql="from CommodityBean commodityBean where commodityBean.brandId =:brandId";
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("brandId",brandId);
        List<BrandBean> brandBeanList = DBUtile.queryInfoList(hql, param);
        return brandBeanList;
    }

}
