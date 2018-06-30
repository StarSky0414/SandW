package manager;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * starsky  make file at 2018/6/30
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class FourRecommendationManagerTest {

    @Test
    public void getFourRecommendation(){
        FourRecommendationManager fourRecommendationManager = new FourRecommendationManager();
        ArrayList<HashMap<String, Object>> resultList = fourRecommendationManager.getFourRecommendation(new String[]{"凉鞋","背包"});
//        System.out.println(JSONObject.fromObject(onceResult).toString());
        JSONObject jsonObject = new JSONObject();
        if (resultList.size()==1){
            jsonObject.put("aaa",resultList.get(0));
        }else {
            jsonObject.put("aaa", resultList);
        }
        System.out.println(jsonObject.toString());
    }
}
