package manager;

import bean.json.ShoppingFormBean;
import provider.ShoppingProvider;

import java.util.ArrayList;

/**
 * starsky  make file at 2018/7/6
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class ShoppingManager {

    public ArrayList<ShoppingFormBean> shoppingListShow(String userId){
        ShoppingProvider shoppingProvider = new ShoppingProvider();
        ArrayList<ShoppingFormBean> shoppingFormBeans = shoppingProvider.shoppingShow(userId);
        return shoppingFormBeans;
    }

    public void shoppingJoin(String userId,String sizeName,int commodityId){
        ShoppingProvider shoppingProvider = new ShoppingProvider();
        int sizeId = shoppingProvider.selectSizeId(commodityId, sizeName);
        shoppingProvider.insertShopping(userId,sizeId);
    }

    public void shoppingRemoveOnce(int userId,int commodityId,String sizeName){
        ShoppingProvider shoppingProvider = new ShoppingProvider();
        shoppingProvider.dropShopping(String.valueOf(userId),commodityId,sizeName);
    }
}
