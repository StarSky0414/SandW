package db.provider;


import org.junit.Test;
import provider.SessionProvider;

public class SessionProviderTest {
    @Test
    public void insertProviderTest(){
        SessionProvider.createSession("SandW000049","0e82f52628ac48aeb0d19fe0fc85fac7");
    }

    @Test
    public void querySessionTese(){
        insertProviderTest();
        String sandW000049 = SessionProvider.getUserNum("0e82f52628ac48aeb0d19fe0fc85fac7");
        System.out.println(sandW000049);
    }
}
