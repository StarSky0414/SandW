package bean.json;

import java.util.ArrayList;

/**
 * starsky  make file at 2018/6/28
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SizeStockJsonBean {

    public class SizeStockJsonFormBean {
         public String sizeName;
         public int sizeNum;

        public String getSizeName() {
            return sizeName;
        }

        public int getSizeNum() {
            return sizeNum;
        }
    }

    private ArrayList<SizeStockJsonFormBean> sizeStocksList=new ArrayList<SizeStockJsonFormBean>();

    public void setSizeStock(String sizeName,int sizeNum){
        SizeStockJsonFormBean sizeStockTestBean = new SizeStockJsonFormBean();
        sizeStockTestBean.sizeName=sizeName;
        sizeStockTestBean.sizeNum=sizeNum;
        sizeStocksList.add(sizeStockTestBean);
    }

    public ArrayList getSizeStocksList() {
        return sizeStocksList;
    }
}
