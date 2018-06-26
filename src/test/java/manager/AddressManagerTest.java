package manager;

import org.junit.Test;

public class AddressManagerTest {
    @Test
    public void createAddressTest(){
        String userNum="SandW0000502";
        AddressManager.createAddress(userNum,"kang","junran",
                "zhongguo","dalian","dalain","dalianwaiguoyv","117000","15141433601",true);

    }

    @Test
    public void selectAddressTest(){
        AddressManager.AddressBean addressBean = AddressManager.selectAddress(42);
        System.out.println("======");
    }

    @Test
    public void updateAddressTest(){
        AddressManager.updateAddress(42,"SandW0000502","a","aa","aa","aa","aa","aa","aa","aaa",false);
    }
}
