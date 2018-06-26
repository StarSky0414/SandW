import db.po.UserInfoBean;
import db.utiles.DBUtile;
import org.junit.Test;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class DBUtileTest {

    @Test
    public void queryTest(){
        String hql="from UserInfoBean where id=:id";
        HashMap<String, Object> parm = new HashMap<String, Object>();
        parm.put("id",31);
        List<UserInfoBean> userInfoList = DBUtile.queryInfoList(hql,parm);
        for (UserInfoBean userInfo:
             userInfoList) {
            System.out.println("id: "+userInfo.getId());
            System.out.println("UserNum: "+userInfo.getUserNum());
            System.out.println("UserName: "+userInfo.getUserName());
            System.out.println("Password: "+userInfo.getPassword());
            System.out.println("Nickname: "+userInfo.getNickName());
            System.out.println("Sex: "+userInfo.getSex());
            System.out.println("Birthday: "+userInfo.getBirthday());
            System.out.println("=================================");
        }
    }

    @Test
    public void saveInfo(){
        UserInfoBean userInfoBean = new UserInfoBean("aaacccc", "aaa","aaa");
        DBUtile.saveInfo(userInfoBean);
    }

    @Test
    public void upDate(){

        Date date = new Date(2018,1,1);
        UserInfoBean userInfoBean = new UserInfoBean(date);
        userInfoBean.setId(30);
        String hql="update UserInfoBean username set username.userName = :username where id = :id ";
        HashMap<String, Object> parm = new HashMap<String, Object>();
        parm.put("username","tttt");
        parm.put("id",30);

        DBUtile.upData(hql,parm);
    }





}
