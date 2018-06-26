package manager;

import org.junit.Test;

public class loginManagerTest {

    @Test
    public void loginInfoProveTest(){
        Boolean aaa = LoginManager.loginInfoProve("1", "aaaa");
        System.out.println(aaa);
    }

    @Test
    public void createSessionTest(){
        String session = LoginManager.createSession();
        System.out.println(session);
    }

    @Test
    public void userRegisterTest(){
        if (LoginManager.userRegister("bcaaa","aaa","aaa")) {
            System.out.println("ok!");
        }else {
            System.out.println("No!");
        }
    }

}
