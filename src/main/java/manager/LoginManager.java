package manager;

import db.po.UserInfoBean;
import provider.SessionProvider;
import provider.UserInfoProvider;

import java.util.Date;
import java.util.UUID;

public class LoginManager {
    public static Boolean loginInfoProve(String user, String passWord) {
        UserInfoBean userInfoBean = UserInfoProvider.queryUserPassWord(user);
        if (userInfoBean == null) {
            return false;
        }
        String sqlPassword = userInfoBean.getPassword();
        if (sqlPassword.equals(passWord)) {
            return true;
        } else {
            return false;
        }
    }

    public static String createSession() {
        UUID uuid = UUID.randomUUID();
        String sessionString = uuid.toString().replace("-", "");
        return sessionString;
    }

    public static Boolean userRegister(String user, String passWord,String nickName) {
        if (!userExist(user)) {
            if (UserInfoProvider.insertUserInfo(user,passWord,nickName)) {
                return true;
            }
        }
        return false;
    }

    private static Boolean userExist(String userName) {
        UserInfoBean userInfoBean = UserInfoProvider.queryUserPassWord(userName);
        return userInfoBean != null;
    }

    public static Boolean changePassWord(String session, String oldPassWord, String changePassWord){
        String userNum = SessionProvider.getUserNum(session);
        return UserInfoProvider.updatePassWord(userNum,oldPassWord,changePassWord);
    }

    public static void changeUserInfo(String session,byte sex,String nickName,Date brithday,String userName){
        String userNum = SessionProvider.getUserNum(session);

        UserInfoProvider.changeUserInfo(userNum,sex,nickName,brithday,userName);
    }
}
