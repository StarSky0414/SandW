package provider;

import db.po.UserInfoBean;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class SessionProvider {

    private static class SessionBean{
        private String userNum;
        private Date createDate;
        private int userId;

        SessionBean(String userNum, Date createDate,int userId) {
            this.userNum = userNum;
            this.createDate = createDate;
            this.userId=userId;
        }

        String getUserNum() {
            return userNum;
        }

    }

    private static HashMap<String,SessionBean> sessionMap=new HashMap<String, SessionBean>();

    public static void createSession(String userNum , String sessionCache,int userId){
        SessionBean sessionBean = new SessionBean(userNum, new Date(),userId);
        sessionMap.put(sessionCache,sessionBean);
    }

    public static String getUserNum(String sessionCache){
        String userNum="";
        if (sessionMap.containsKey(sessionCache)) {
            userNum = sessionMap.get(sessionCache).getUserNum();
        }
        return  userNum;
    }

    public static int getUserid(String sessionCache){
        int userNum=0;
        if (sessionMap.containsKey(sessionCache)) {
            userNum = sessionMap.get(sessionCache).userId;
        }
        return  userNum;
    }

    @Deprecated
    public static void deleSessionTimer(){}

    public static UserInfoBean getUserInfo(String sessioin){
        String userNum = getUserNum(sessioin);
        UserInfoBean userInfoBean = UserInfoProvider.queryUserInfoByNum(userNum);
        return userInfoBean;
    }

}
