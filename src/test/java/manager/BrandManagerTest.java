package manager;

import org.junit.Test;

import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class BrandManagerTest {

    @Test
    public void getBrandListTest(){
        List<String> brandList = SearchManager.getBrandList();
        for (String s :
                brandList) {
            System.out.println(s);
        }
    }
}
