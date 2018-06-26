package db.provider;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import provider.SearchProvider;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SearchProviderTest {

    @Test
    public void getBigRangeListTest(){
        List<String> bigRangeList = SearchProvider.getBigRangeList();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa",bigRangeList);
        System.out.println(jsonObject.toString());
    }
}
