package manager;

import bean.json.CommodityJsonBean;
import provider.CommodityProvider;
import provider.SizeStockProvider;

/**
 * starsky  make file at 2018/6/27
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class CommodityManager {

    public CommodityJsonBean commodityInfo(int commodityId, int userId){
        CommodityProvider commodityProvider = new CommodityProvider();
        CommodityJsonBean commodityJsonBean = commodityProvider.queryCommodityById(commodityId, userId);
        SizeStockProvider sizeStockProvider = new SizeStockProvider();
        commodityJsonBean.setSizeStock(sizeStockProvider.querySizeStock(commodityId));
        return commodityJsonBean;

    }


}
