package db.provider;

import db.po.CollectBean;
import org.junit.Test;
import provider.CollectProvider;

import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class CollectProviderTest {

    private static int userId=50;
    private static int commodityId=1;

    @Test
    public void insertCollectTest(){
        CollectProvider.insertCollect(userId,commodityId);
    }

    @Test
    public void queryCollectInfo(){
        CollectBean collectBean = CollectProvider.queryCollectInfo(userId, commodityId);
        System.out.println("id:"+collectBean.getId());
        System.out.println("UserId:"+collectBean.getUserId());
        System.out.println("Commodity:"+collectBean.getCommodity());
        System.out.println("DeleSign:"+collectBean.getDeleSign());
    }

    @Test
    public void queryCollectListTest(){
        
        List<CollectBean> collectBeans = CollectProvider.queryCollectList(userId);
        for (CollectBean collect :
                collectBeans) {
            System.out.println("id:"+collect.getId());
        }
    }
}