package db.provider;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import provider.SearchProvider;
import provider.SizeStockProvider;

import java.util.ArrayList;

/**
 * starsky  make file at 2018/6/27
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SizeStrckProviderTest
{

    @Test
    public void querySizeStockYTest(){
        SizeStockProvider sizeStockProvider = new SizeStockProvider();
        ArrayList arrayList = sizeStockProvider.querySizeStock(1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("OK",arrayList);
        System.out.println(jsonObject.toJSONString());
    }
}
