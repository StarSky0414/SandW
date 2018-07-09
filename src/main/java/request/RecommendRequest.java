package request;

import bean.json.CommendationListJsonBean;
import db.utiles.DBUtile;
import net.sf.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * starsky  make file at 2018/7/9
 * 代码是个艺术，请不要侮辱自己的审美
 */

@Controller
@EnableAutoConfiguration
public class RecommendRequest {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/recommend/fivebrand")
    public String fivebrand(){
        String sql="select brand_name from brand limit 0,5";
        List list = DBUtile.queryInfoBySQL(sql, new ArrayList());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brandName",list);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/recommend/tencommodity")
    public String tencommodity(){
        String sql="select photo_doc,brand_name from commodity , brand where brand.id=commodity.brand_id limit 0,5";
        List list = DBUtile.queryInfoBySQL(sql, new ArrayList());

        ArrayList arrayList = new ArrayList();
        for (int i=0;i<list.size();i++){
            Object[] paramArray = (Object[]) list.get(i);
            HashMap hashMap = new HashMap();
            hashMap.put("photoDoc",String.valueOf(paramArray[0]));
            hashMap.put("brandName",String.valueOf(paramArray[1]));
            arrayList.add(hashMap);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tencommodity",arrayList);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }
}
