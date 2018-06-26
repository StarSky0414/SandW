package db.provider;
import db.po.AddressBookBean;
import db.po.UserAddressOptionBean;
import org.junit.Test;
import provider.AddressProvider;

import java.util.List;

public class AddressProviderTest {
    @Test
    public void insertAddressTest(){
        AddressProvider.insertAddress("SandW000050","luo",
                "junyuan","中国","辽宁","大连",
                "大连外国语大学","117000","15141433601");
    }

    @Test
    public void updateAddressTest(){
        AddressBookBean addressBookBean = AddressProvider.selectAddress(5);
        AddressProvider.updateAddress(5,addressBookBean,"xtttttttvxx",
                "钧元","中国","辽宁","大连",
                "大连外国语大学","117000","15141433601");
//        AddressProvider.updateAddress();
    }
    @Test
    public void deleAddressTest(){
        AddressProvider.deleAddress(5);
    }

    @Test
    public void selectAddressList(){
        String userNum = "SandW000050";
        List<AddressBookBean> addressBookBeans = AddressProvider.selectAddressList(userNum);
    }
    @Test
    public void queryUserAddressOptionTest(){
        String userNum = "SandW0000501";
        UserAddressOptionBean userAddressOptionBean = AddressProvider.queryUserAddressOption(userNum);
        if (userAddressOptionBean==null){
            System.out.println("暂无结果");
            return;
        }
        System.out.println(userAddressOptionBean.getId());
        System.out.println(userAddressOptionBean.getUserNum());
    }

    @Test
    public void saveUserAddressOptionTest(){
        String userNum = "SandW000051";
        AddressProvider.saveUserAddressOption(userNum,"aaaa");
    }
}
