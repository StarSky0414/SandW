package provider;

import db.po.BrandBean;
import db.utiles.DBUtile;

import java.util.HashMap;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class BrandProvider {

    public static BrandBean queryBrandInfo(int brandId){
        String hql="from BrandBean brand where brand.id=:id";
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id",brandId);
        List<BrandBean> brandListInfo = DBUtile.queryInfoList(hql, param);
        BrandBean brandInfo = brandListInfo.get(0);
        return brandInfo;
    }
}
