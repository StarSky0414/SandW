package db.provider;

import org.junit.Test;
import provider.UserInfoProvider;

public class UserInfoProviderTest {

    @Test
    public void updatePassWordTest(){
        if (UserInfoProvider.updatePassWord("SandW000047","aaa","bbb")) {
            System.out.println("ok!");
        }else {
            System.out.println("NO!");
        }
    }

}
