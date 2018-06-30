package provider;

import bean.json.CommodityJsonBean;
import db.po.BrandBean;
import db.utiles.DBUtile;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class CommodityProvider {

    public CommodityJsonBean queryCommodityById(int commodityBeanId, int userId){
        String sql="select\n" +
                "  commodity.id,\n" +
                "  commodity.money,\n" +
                "  commodity.photo_doc,\n" +
                "  commodity.show_state,\n" +
                "  commodity.brand_id,\n" +
                "  commodity.small_range,\n" +
                "  commodity.sex,\n" +
                "  commodity.lang_describe,\n" +
                "  commodity.shot_describe,\n" +
                "  brand.brand_name,\n" +
                "  brand.brand_country,\n" +
                "  brand.brand_describe,\n" +
                "  if(ifnull((select collect.commodity from collect\n" +
                "  where  collect.user_id=?\n" +
                "         and collect.dele_sign=0\n" +
                "         and collect.commodity=commodity.id),false ),true ,false )\n" +
                "from commodity,brand\n" +
                "where commodity.id=?\n" +
                "      and commodity.brand_id=brand.id";
        ArrayList arrayList = new ArrayList();
        arrayList.add(userId);
        arrayList.add(commodityBeanId);
        List list = DBUtile.queryInfoBySQL(sql, arrayList);
        Object[] paramArray = (Object[]) list.get(0);
        CommodityJsonBean commodityJsonBean = new CommodityJsonBean(
                (Integer) paramArray[0],
                (String) paramArray[1],
                (String) paramArray[2],
                (Byte) paramArray[3],
                (Integer) paramArray[4],
                (String) paramArray[5],
                (Byte) paramArray[6],
                (String) paramArray[7],
                (String) paramArray[8],
                (String) paramArray[9],
                (String) paramArray[10],
                (String) paramArray[11],
                (BigInteger) paramArray[12]
                );

        return commodityJsonBean;
    }




}
