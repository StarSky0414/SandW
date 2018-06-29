package utiles;

import db.po.POProvider;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * starsky  make file at 2018/6/27
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class BeanToMap {


    /**
     * 该方法用于将实例转换为map
     * @param poProvider  要转换的实例
     * @return 返回转换后的map
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    private static HashMap<String, Object> beanToMapException(POProvider poProvider) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Class aClass = poProvider.getClass();
        Field[] fields = aClass.getDeclaredFields();

        HashMap<String, Object> beanMap = new HashMap<String, Object>();
        for (Field field :
                fields) {
            field.setAccessible(true);
            String name = field.getName();
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, aClass);
            Object invoke = propertyDescriptor.getReadMethod().invoke(poProvider);
            beanMap.put(name,invoke);
        }
        return beanMap;
    }

    /**
     *  该方法用于处理异常信息，便于外部使用
     * @param poProvider
     * @return
     */
    public static HashMap<String, Object> beanToMap(POProvider poProvider){
        HashMap<String, Object>beanMap = null;
        try {
             beanMap = beanToMapException(poProvider);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return beanMap;
    }

    /**
     * 用于合并两个或多个bean，若有相同名字存在，以后面的bean为主
     */

    public static HashMap<String, Object> mergeBeanToMap(POProvider[] poProviders){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        for (POProvider poprovider :
                poProviders) {
            HashMap<String, Object> tempMap = BeanToMap.beanToMap(poprovider);
            for (Map.Entry entry :
                    tempMap.entrySet()) {
                resultMap.put((String) entry.getKey(),entry.getValue());
            }
        }
        return resultMap;
    }
}
