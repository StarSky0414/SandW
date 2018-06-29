package provider;

import db.po.UserInfoBean;
import db.utiles.DBUtile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserInfoProvider {
    private static Logger logger=LoggerFactory.getLogger(UserInfoProvider.class);
    public static UserInfoBean queryUserPassWord(String userName){
        String hql="from UserInfoBean userinfo where userinfo.userName=:userName";
        HashMap<String, Object> parm = new HashMap<String, Object>();
        parm.put("userName",userName);
        List<UserInfoBean> userInfoList = DBUtile.queryInfoList(hql, parm);
        if (userInfoList.size()==1){
            return userInfoList.get(0);
        }else {
            return null;
        }
    }

    public static Boolean insertUserInfo(String passWord,String userName,String nickName){
        try{
            UserInfoBean userInfoBean = new UserInfoBean(passWord, userName,nickName);
            DBUtile.saveInfo(userInfoBean);
            return true;
        }catch (Throwable throwable){
            logger.error("[***]insertUserInfo: {}",throwable.getMessage());
            return false;
        }
    }

    public static String getUserNumByName(String userName){
        UserInfoBean userInfoBean = queryUserPassWord(userName);
        return userInfoBean.getUserNum();
    }

    public static int getUserIdByName(String userName){
        UserInfoBean userInfoBean = queryUserPassWord(userName);

        return userInfoBean.getId();
    }

    public static UserInfoBean queryUserInfoByNum(String userNum){
        String hql="from UserInfoBean userinfo where userinfo.userNum=:userNum";
        HashMap<String, Object> parm = new HashMap<String, Object>();
        parm.put("userNum",userNum);
        List<UserInfoBean> userInfoList = DBUtile.queryInfoList(hql, parm);
        if (userInfoList.size()==1){
            return userInfoList.get(0);
        }else {
            return null;
        }
    }

    public static Boolean updatePassWord(String userNum, String oldPassWord, String changePassWord){
        UserInfoBean userInfoBean = queryUserInfoByNum(userNum);
        if (oldPassWord.equals(userInfoBean.getPassword())){
            String hql="update UserInfoBean user_info   set user_info.password=:passWord where user_info.userNum=:userNum ";
            HashMap<String, Object> parm = new HashMap<String, Object>();
            parm.put("passWord",changePassWord);
            parm.put("userNum",userNum);
            DBUtile.upData(hql,parm);
            return true;
        }
        return false;
    }

    public static void changeUserInfo(String userNum,byte sex,String nickName,Date birthday,String userName){
        String hql="update UserInfoBean user_info  set user_info.nickName=:nickName ,user_info.sex=:sex ,user_info.birthday=:birthday ,user_info.userName=:userName where user_info.userNum=:userNum ";
        HashMap<String, Object> parm = new HashMap<String, Object>();
        parm.put("nickName",nickName);
        parm.put("birthday",birthday);
        parm.put("userNum",userNum);
        parm.put("sex",sex);
        parm.put("userName",userName);
        DBUtile.upData(hql,parm);
    }

}
