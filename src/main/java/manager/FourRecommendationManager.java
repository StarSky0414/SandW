package manager;

import bean.json.CommendationListJsonBean;
import provider.FourRecommendationProvider;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * starsky  make file at 2018/6/30
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class FourRecommendationManager {

    public ArrayList<HashMap<String, Object>> getFourRecommendation(String[] smallRangesList){
        FourRecommendationProvider fourRecommendationProvider = new FourRecommendationProvider();
        ArrayList<HashMap<String,Object>> itemList=new ArrayList<HashMap<String, Object>>();
        for (String smallRange:smallRangesList){
            HashMap<String, Object> nameValueMAp = new HashMap<String, Object>();
            ArrayList<CommendationListJsonBean> CommendationListJsonBean = fourRecommendationProvider.fourRecommendationBySmallRange(smallRange);
            nameValueMAp.put("itemName",smallRange);
            nameValueMAp.put("itemInfo", CommendationListJsonBean);
            itemList.add(nameValueMAp);
        }
        return itemList;
    }
}
