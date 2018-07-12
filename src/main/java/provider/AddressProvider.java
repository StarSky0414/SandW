package provider;

import db.po.AddressBookBean;
import db.po.POProvider;
import db.po.UserAddressOptionBean;
import db.utiles.DBUtile;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressProvider {

    public static int insertAddress(String userNum, String surName, String name, String country, String province, String city, String address, String postCode, String phone){
        AddressBookBean addressBookBean = new AddressBookBean(userNum,surName,name,country,province,city,address,postCode,phone);
        DBUtile.saveInfo(addressBookBean);
        return addressBookBean.getId();
    }

    public static void updateAddress(int id, AddressBookBean addressBookBean, String surName, String name, String country, String province, String city, String address, String postCode, String phone){
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("surName",surName);
        parm.put("name",name);
        parm.put("country",country);
        parm.put("province",province);
        parm.put("city",city);
        parm.put("address",address);
        parm.put("postCode",postCode);
        parm.put("phone",phone);
        parm.put("id",id);
        dbUpdata(parm,addressBookBean);
    }

    public static void deleAddress(int addressId){
        AddressBookBean addressBookBean = selectAddress(addressId);
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("deleSign",(byte)1);
        dbUpdata(parm,addressBookBean);
    }

    public static List<AddressBookBean> selectAddressList(String userNum){
        String hql="from AddressBookBean add where add.userNum=:userNum and add.deleSign =0 ";
        HashMap<String, Object> parm = new HashMap<String, Object>();
        parm.put("userNum",userNum);
        List<AddressBookBean> addressBookBeanList = DBUtile.queryInfoList(hql, parm);
        return addressBookBeanList;
    }

    public static AddressBookBean selectAddress(int id){
        String hql="from AddressBookBean add where add.id=:id and add.deleSign =0";
        HashMap<String, Object> parm = new HashMap<String, Object>();
        parm.put("id",id);
        List<AddressBookBean> addressBookBeanList = DBUtile.queryInfoList(hql, parm);
        AddressBookBean addressBookBean = addressBookBeanList.get(0);
        return addressBookBean;
    }

    public static UserAddressOptionBean queryUserAddressOption(String userNum){
        String hql="from UserAddressOptionBean user_address_option " +
                "where user_address_option.userNum=:userNum";
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("userNum",userNum);
        List<Object> userAddressOptionBeanList = DBUtile.queryInfoList(hql, param);
        if (userAddressOptionBeanList.size()==0){
            return null;
        }
        UserAddressOptionBean userAddressOptionBean =(UserAddressOptionBean) userAddressOptionBeanList.get(0);
        return userAddressOptionBean;
    }

    public static void saveUserAddressOption(String userNum, String addressBookNum){
        UserAddressOptionBean userAddressOption = queryUserAddressOption(userNum);
        if (userAddressOption==null){
            userAddressOption = new UserAddressOptionBean(userNum, addressBookNum);
            DBUtile.saveInfo(userAddressOption);
            return;
        }
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("addressBookNum",addressBookNum);
        dbUpdata(param,userAddressOption);

    }

    private static void dbUpdata(Map<String,Object> param, POProvider userAddressOption){
        try {
            DBUtile.upData(param,userAddressOption);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
