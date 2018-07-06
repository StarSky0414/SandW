package provider;

import bean.json.ShoppingFormBean;
import db.po.ShoppingBean;
import db.utiles.DBUtile;
import db.utiles.HibernateSession;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * starsky  make file at 2018/7/6
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class ShoppingProvider {

    public ArrayList<ShoppingFormBean> shoppingShow(String userId) {
        String sql = " select    \n" +
                "   commodity.photo_doc,    \n" +
                "   commodity.money,    \n" +
                "   brand.brand_name,    \n" +
                "   size_stock.stock_num,    \n" +
                "   size_stock.size,    \n" +
                "   count(*),\n" +
                "   size_stock.commodity_id\n" +
                " from shopping,commodity,size_stock,brand    \n" +
                " where shopping.size_id=size_stock.id and size_stock.commodity_id=commodity.id and brand.id=commodity.brand_id    \n" +
                " and shopping.user_id=? and shopping.order_sign=0 and shopping.dele_sign=0 group by shopping.size_id";

        ArrayList<String> param = new ArrayList<String>();
        param.add(userId);
        List list = DBUtile.queryInfoBySQL(sql, param);

        ArrayList<ShoppingFormBean> shoppingFormBeans = new ArrayList<ShoppingFormBean>();

        for (int i = 0; i < list.size(); i++) {
            Object[] paramArray = (Object[]) list.get(i);
            ShoppingFormBean shoppingFormBean = new ShoppingFormBean(
                    (String) paramArray[0],
                    (String) paramArray[1],
                    (String) paramArray[2],
                    Integer.valueOf(paramArray[3].toString()) ,
                    (String) paramArray[4],
                    Integer.valueOf(paramArray[5].toString()),
                    Integer.valueOf(paramArray[6].toString())
            );
            shoppingFormBeans.add(shoppingFormBean);
        }
        return shoppingFormBeans;
    }

    public void insertShopping(String userId,int sizeId){
        ShoppingBean shoppingBean = new ShoppingBean(userId, sizeId);
        DBUtile.saveInfo(shoppingBean);
    }

    public int selectSizeId(int commodityId, String sizeName){
        String sql="select size_stock.id from size_stock where commodity_id=? and size=?";
        ArrayList arrayList = new ArrayList();
        arrayList.add(commodityId);
        arrayList.add(sizeName);
        List list = DBUtile.queryInfoBySQL(sql, arrayList);
        return (Integer) list.get(0);
    }

    public void dropShopping(String userId,int commodityId,String sizeName){
        String sql="update shopping set shopping.dele_sign=1 where shopping.user_id=? and  shopping.id in (select id from (select shopping.id from shopping ,size_stock where shopping.size_id=size_stock.id and size_stock.commodity_id=? and size_stock.size=? and shopping.dele_sign=0 limit 0,1)C )";
        ArrayList param = new ArrayList();
        param.add(Integer.valueOf(userId));
        param.add(commodityId);
        param.add(sizeName);

//        Session session = HibernateSession.getSession();

        DBUtile.updateInfoBySQL(sql,param);
    }
}
