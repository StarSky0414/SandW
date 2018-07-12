package db;

import db.po.SizeStockBean;
import db.utiles.DBUtile;
import org.junit.Test;

/**
 * starsky  make file at 2018/7/11
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class autoInsert {

    @Test
    public void insertSizeStock(){
        int size=61;
        for (int i=51;i<size;i++) {
            SizeStockBean sizeStockBean = new SizeStockBean();
            sizeStockBean.setCommodityId(i);
            sizeStockBean.setSize("M");
            sizeStockBean.setStockNum(50);
            DBUtile.saveInfo(sizeStockBean);
            System.out.println("insert OK"+i);
            String s = " aaa";
            s.replace("aaaa","aaaa");
        }
    }
}
