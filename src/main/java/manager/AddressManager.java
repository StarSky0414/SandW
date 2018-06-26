package manager;

import db.po.AddressBookBean;
import db.po.UserAddressOptionBean;
import provider.AddressProvider;

import java.util.HashMap;
import java.util.List;

public class AddressManager {

    public static void createAddress(String userNum, String surName, String name, String country, String province, String city, String address, String postCode, String phone,Boolean option){
        int i = AddressProvider.insertAddress(userNum, surName, name, country, province, city, address, postCode, phone);
        if (option) {
            AddressProvider.saveUserAddressOption(userNum, Integer.toString(i));
        }
    }

    public static List<AddressBookBean> selectAddressList(String userNum){
        List<AddressBookBean> addressBookBeans = AddressProvider.selectAddressList(userNum);
        return addressBookBeans;
    }

    public static AddressBean selectAddress(int id){

        AddressBean addressBean = new AddressBean();
        addressBean.addressBook= AddressProvider.selectAddress(id);
        String userNum = addressBean.addressBook.getUserNum();
        UserAddressOptionBean userAddressOption = AddressProvider.queryUserAddressOption(userNum);
        String addressBookNum = userAddressOption.getAddressBookNum();
        if (addressBookNum.equals(Integer.toString(id))){
            addressBean.option=true;
        }else {
            addressBean.option=false;
        }
        return addressBean;
    }

    public static void updateAddress(int id,String userNum, String surName, String name, String country, String province, String city, String address, String postCode, String phone,Boolean option){
        AddressBookBean addressBookBean = AddressProvider.selectAddress(id);
        AddressProvider.updateAddress(id,addressBookBean,surName,name,country,province,city,address,postCode,phone);
        UserAddressOptionBean userAddressOptionBean = AddressProvider.queryUserAddressOption(userNum);
        if (option) {
            AddressProvider.saveUserAddressOption(userNum,Integer.toString(id));
        }else {
            if (userAddressOptionBean.getAddressBookNum().equals(Integer.toString(id))) {
                AddressProvider.saveUserAddressOption(userNum,Integer.toString(0));
            }
        }
    }

    public static void deleAddress(int addressId,String userNum){
        AddressProvider.deleAddress(addressId);
        UserAddressOptionBean userAddressOptionBean = AddressProvider.queryUserAddressOption(userNum);
        if (userAddressOptionBean!=null) {
            if (userAddressOptionBean.getAddressBookNum().equals(Integer.toString(addressId))) {
                AddressProvider.saveUserAddressOption(userNum,"0");
            }
        }
    }

    public static class AddressBean {
        public AddressBookBean addressBook;
        public Boolean option;
    }

}
