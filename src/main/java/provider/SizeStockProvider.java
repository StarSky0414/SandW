package provider;

import bean.json.SizeStockJsonBean;
import db.utiles.DBUtile;
import db.utiles.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.validator.constraints.EAN;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * starsky  make file at 2018/6/27
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SizeStockProvider {

    public ArrayList querySizeStock(int commodityId){
        String sql="select size_stock.size,size_stock.stock_num from size_stock where size_stock.commodity_id=?;";
        ArrayList paramList = new ArrayList();
        paramList.add(commodityId);
        List list = DBUtile.queryInfoBySQL(sql, paramList);
        SizeStockJsonBean sizeStockJsonBean = new SizeStockJsonBean();
        for (Object l:list){
            Object[] objects=(Object[]) l;
            sizeStockJsonBean.setSizeStock((String) objects[0],(Integer) objects[1]);
        }
        return sizeStockJsonBean.getSizeStocksList();
    }
}
