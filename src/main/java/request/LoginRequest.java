package request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import db.enumeration.UserSexEnum;
import db.po.UserInfoBean;
import jdk.nashorn.internal.runtime.UserAccessorProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import provider.SessionProvider;
import provider.UserInfoProvider;
import manager.LoginManager;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import utiles.TimeTool;

import java.util.Date;
import java.util.HashMap;

@Controller
@EnableAutoConfiguration
public class LoginRequest {

    private static Logger logger=LoggerFactory.getLogger(LoginRequest.class);
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/login/loginprove")
    public String loginInfoProve(@RequestParam(value = "userName") String userName,
                                 @RequestParam(value = "passWord") String passWord) {
        Boolean result = false;
        String session = "";
        if (LoginManager.loginInfoProve(userName, passWord)) {
            result = true;
            session = LoginManager.createSession();
            SessionProvider.createSession(UserInfoProvider.getUserNumByName(userName), session,UserInfoProvider.getUserIdByName(userName));
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", result);
        jsonObject.addProperty("session", session);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/login/userRegister")
    public String loginRegister(@RequestParam(value = "userName") String userName,
                                @RequestParam(value = "passWord") String passWord,
                                @RequestParam(value = "nickName") String nickName) {
        Boolean result = false;
        String session = "";
        if (LoginManager.userRegister(userName, passWord, nickName)) {
            result = true;
            session = LoginManager.createSession();
            SessionProvider.createSession(UserInfoProvider.getUserNumByName(userName), session,UserInfoProvider.getUserIdByName(userName));
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", result);
        jsonObject.addProperty("session", session);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/login/userInit")
    public String loginRegister(@RequestParam(value = "session") String session) {
        UserInfoBean userInfo = SessionProvider.getUserInfo(session);

        HashMap hashMap = new HashMap();
        hashMap.put("sessionProve", true);
        hashMap.put("userInfo", userInfo);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        if (userInfo != null) {
            try {
                jsonString = objectMapper.writeValueAsString(hashMap);
                System.out.println(jsonString);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return jsonString;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/login/changepasswd")
    public String changePassWd(@RequestParam(value = "oldPassWd") String oldPassWd,
                               @RequestParam(value = "changePassWd") String changePassWd,
                               @RequestParam(value = "session") String session) {
        Boolean result = LoginManager.changePassWord(session, oldPassWd, changePassWd);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", result);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/user/changeuserinfo")
    public String changeUserInfo(@RequestParam(value = "session") String session,
                                 @RequestParam(value = "nickName") String nickName,
                                 @RequestParam(value = "birthday") String birthday,
                                 @RequestParam(value = "sex") UserSexEnum sex,
                                 @RequestParam(value = "userName") String userName) {

        System.out.println("---------session-----"+session);
        System.out.println("----------nickName----"+nickName);
        System.out.println("--------birthday------"+birthday);
        System.out.println("---------sex-----"+sex);
        System.out.println("---------userName-----"+userName);
        if (!(sex.toString().equals(UserSexEnum.Man.toString()) || sex.toString().equals(UserSexEnum.Girl.toString()))) {
            String ErrorMessage="sex the parameter is error ,please submit Man or Girl .";
            logger.error("[*****] submit Error , changeUserInfo class "+ErrorMessage);
            return ErrorMessage;
        }
        Date birthdayDate = TimeTool.StringToDate(birthday);
        LoginManager.changeUserInfo(session, sex.getSexNumber(), nickName, birthdayDate,userName);
        System.out.println(sex.getSexNumber());
        return "{\"result\":true}";
    }



}
