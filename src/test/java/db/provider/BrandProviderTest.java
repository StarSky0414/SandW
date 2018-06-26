package db.provider;

import db.po.BrandBean;
import org.junit.Test;
import provider.BrandProvider;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class BrandProviderTest {

    @Test
    public void queryBrandInfoTest(){
        BrandBean brandBean = BrandProvider.queryBrandInfo(1);
        System.out.println("id:"+brandBean.getId());
        System.out.println("Describe:"+brandBean.getBrandDescribe());
        System.out.println("Country:"+brandBean.getBrandCountry());

    }
}
