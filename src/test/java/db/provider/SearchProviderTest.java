package db.provider;

import bean.json.CommendationListJsonBean;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import provider.SearchProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SearchProviderTest {

    @Test
    public void getBigRangeListTest(){
        List<String> bigRangeList = SearchProvider.getBigRangeList("1");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa",bigRangeList);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void getBrandListTest(){
        List<String> brandList = SearchProvider.getBrandList("1");
        for (String s : brandList){
            System.out.println(s);
        }
    }

    @Test
    public void descriptionVagueTest(){
        SearchProvider searchProvider = new SearchProvider();
        ArrayList<CommendationListJsonBean> t = searchProvider.descriptionVague("T");
        for (CommendationListJsonBean commendationListJsonBean:t){
            System.out.println(commendationListJsonBean.getBrandName());
            System.out.println(commendationListJsonBean.getId());
            System.out.println("=======================");
        }
    }
}
