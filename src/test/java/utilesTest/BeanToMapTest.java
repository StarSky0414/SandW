package utilesTest;

import db.po.BrandBean;
import db.po.CollectBean;
import db.po.POProvider;
import org.junit.Test;
import utiles.BeanToMap;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * starsky  make file at 2018/6/27
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class BeanToMapTest {

    @Test
    public  void beanToMap(){
        BrandBean brandBean = new BrandBean();
        brandBean.setId(1);
        brandBean.setBrandCountry("aaa");
        brandBean.setBrandDescribe("vbbb");
        brandBean.setBrandName("cccc");
        HashMap<String, Object> stringObjectHashMap = BeanToMap.beanToMap(brandBean);

        for (Map.Entry<String,Object> entry:stringObjectHashMap.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }


    @Test
    public  void mergeBeanToMap(){
        BrandBean brandBean = new BrandBean();
        brandBean.setId(1);
        brandBean.setBrandCountry("aaa");
        brandBean.setBrandDescribe("vbbb");
        brandBean.setBrandName("cccc");

        CollectBean collectBean = new CollectBean("aa", "aaaaaa");
        POProvider[] poProviders=new POProvider[]{brandBean,collectBean};
        HashMap<String, Object> stringObjectHashMap = BeanToMap.mergeBeanToMap(poProviders);
        for (Map.Entry entry:stringObjectHashMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
