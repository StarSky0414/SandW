package db.provider;

import db.po.BrandBean;
import db.po.CommodityBean;
import org.junit.Test;
import provider.CollectProvider;
import provider.CommodityProvider;

import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class commodityProviderTest {
    int commoditId=1;

    @Test
    public void queryCommodityByIdTest(){
        CommodityBean commodityBean = CommodityProvider.queryCommodityById(1);
        System.out.println(commodityBean.getBigRange());
    }

    @Test
    public void queryCommodityByBrandTest(){
        List<BrandBean> brandBeans = CommodityProvider.queryCommodityByBrand(4);
        System.out.println(brandBeans.size());
    }
}
