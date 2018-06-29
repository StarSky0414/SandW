package bean.json;

import java.util.ArrayList;

/**
 * starsky  make file at 2018/6/28
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SizeStockJsonBean {

    public class SizeStockFormBean {
         public String sizeName;
         public int sizeNum;
    }

    private ArrayList<SizeStockFormBean> sizeStocksList=new ArrayList<SizeStockFormBean>();

    public void setSizeStock(String sizeName,int sizeNum){
        SizeStockFormBean sizeStockTestBean = new SizeStockFormBean();
        sizeStockTestBean.sizeName=sizeName;
        sizeStockTestBean.sizeNum=sizeNum;
        sizeStocksList.add(sizeStockTestBean);
    }

    public ArrayList getSizeStocksList() {
        return sizeStocksList;
    }
}
