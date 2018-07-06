package db.provider;

import bean.json.ShoppingFormBean;
import org.junit.Test;
import provider.ShoppingProvider;
import java.util.ArrayList;

/**
 * starsky  make file at 2018/7/6
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class ShoppingProviderTest {

    @Test
    public void shoppingShowTest(){
        ShoppingProvider shoppingProvider = new ShoppingProvider();
        ArrayList<ShoppingFormBean> shoppingFormBeans = shoppingProvider.shoppingShow("50");
        for (ShoppingFormBean shoppingFormBean:
             shoppingFormBeans) {
            System.out.println("BrandName:"+shoppingFormBean.getBrandName());
            System.out.println("购买数量:"+shoppingFormBean.getCount());
        }
    }

    @Test
    public void insertShoppingTest(){
        new ShoppingProvider().insertShopping("50",3);
    }

    @Test
    public void dropShoppingTest(){
        new ShoppingProvider().dropShopping("50",9,"XS");
    }
}
