package request;


import com.alibaba.fastjson.JSONObject;
import db.po.AddressBookBean;
import manager.AddressManager;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import provider.SessionProvider;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class AddressRequest {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/address/save")
    public String saveAddressInfo(@RequestParam(value = "session")String session,
                                      @RequestParam(value = "addressId",required = false,defaultValue = "0")int addressId,
                                      @RequestParam(value = "surName")String surName,
                                      @RequestParam(value = "name")String name,
                                      @RequestParam(value = "country")String country,
                                      @RequestParam(value = "province")String province,
                                      @RequestParam(value = "city")String city,
                                      @RequestParam(value = "address")String address,
                                      @RequestParam(value = "postCode")String postCode,
                                      @RequestParam(value = "phone")String phone,
                                      @RequestParam(value = "option")Boolean option){
        String userNum = SessionProvider.getUserNum(session);
        if (addressId==0) {
            AddressManager.createAddress(userNum, surName, name, country, province, city, address,
                    postCode, phone, option);

        }else {
            AddressManager.updateAddress(addressId,userNum, surName, name, country, province, city, address,
                    postCode, phone, option);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", true);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/address/list")
    public String getAddressList(@RequestParam(value = "session" )String session) throws UnsupportedEncodingException {
        String userNum = SessionProvider.getUserNum(session);
        List<AddressBookBean> addressBooks = AddressManager.selectAddressList(userNum);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("addressBookList",addressBooks);
        if (addressBooks.size()!=0){
            jsonObject.put("ListNull",false);
        }else {
            jsonObject.put("ListNull",true);
        }
        String string = new String(jsonObject.toString().getBytes("UTF-8"),"UTF-8");
        return string;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/address/info")
    public String getAddressInfo(@RequestParam(value = "addressId")int addressId){
        AddressManager.AddressBean addressBean = AddressManager.selectAddress(addressId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("addressBookInfo",addressBean.addressBook);
        jsonObject.put("option",addressBean.option);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/address/dele")
    public String deleAddressInfo(@RequestParam(value = "session" )String session,
                                  @RequestParam(value = "addressId" ) int addressId) throws UnsupportedEncodingException {
        String userNum = SessionProvider.getUserNum(session);
        AddressManager.deleAddress(addressId,userNum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",true);
        String string = new String(jsonObject.toString().getBytes("UTF-8"),"UTF-8");
//        String string = jsonObject.toString();
        return  string;
    }
}
