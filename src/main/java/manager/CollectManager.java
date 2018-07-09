package manager;

import bean.json.CommendationListJsonBean;
import provider.CollectProvider;

import java.util.ArrayList;

/**
 * starsky  make file at 2018/7/9
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class CollectManager {

    public ArrayList<CommendationListJsonBean> collectshow(int userid){
        CollectProvider collectProvider = new CollectProvider();
        ArrayList<CommendationListJsonBean> commendationListJsonBeans = collectProvider.collectSelect(userid);
        return commendationListJsonBeans;
    }

    public void collectAdd(String userId,String commendationId){
        CollectProvider collectProvider = new CollectProvider();
        collectProvider.collectAdd(userId,commendationId);
    }

    public void collectdele(String userId,String commendationId){
        CollectProvider collectProvider = new CollectProvider();
        collectProvider.collectdele(userId,commendationId);
    }

}
