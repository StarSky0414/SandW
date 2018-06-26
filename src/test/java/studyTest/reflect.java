package studyTest;

import db.po.AddressBookBean;
import db.po.POProvider;
import db.po.UserAddressOptionBean;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.PropertyPermission;

public class reflect {

    @Test
    public void re() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        UserAddressOptionBean userAddressOptionBean = new UserAddressOptionBean("aa","aa");
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        stringObjectHashMap.put("id",6);
        insert(stringObjectHashMap,userAddressOptionBean);

        Field[] declaredFields = UserAddressOptionBean.class.getDeclaredFields();
        Field f = declaredFields[0];
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(f.getName(), UserAddressOptionBean.class);
        Method readMethod = propertyDescriptor.getReadMethod();
        Integer num = (Integer)readMethod.invoke(userAddressOptionBean);
        System.out.println(num);
        f = declaredFields[1];
        propertyDescriptor = new PropertyDescriptor(f.getName(), UserAddressOptionBean.class);
        readMethod = propertyDescriptor.getReadMethod();
        String str = (String) readMethod.invoke(userAddressOptionBean);
        System.out.println(str);
    }

    private  void  insert(HashMap<String,Object> parmMap,POProvider poProvider) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Field[] declaredFields = UserAddressOptionBean.class.getDeclaredFields();
        for (Field field : declaredFields) {
            String name = field.getName();
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, UserAddressOptionBean.class);
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if (parmMap.containsKey(name))
                writeMethod.invoke(poProvider, parmMap.get(name));
        }

    }
}
