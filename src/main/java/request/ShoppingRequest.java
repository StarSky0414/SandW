package request;

import bean.json.ShoppingFormBean;
import manager.ShoppingManager;
import net.sf.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import provider.SessionProvider;

import java.util.ArrayList;

/**
 * starsky  make file at 2018/7/6
 * 代码是个艺术，请不要侮辱自己的审美
 */

@Controller
@EnableAutoConfiguration
public class ShoppingRequest {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/shopping/shoppinglist")
    public String shoppingShow(@RequestParam (value = "session")String session){
        int userid = SessionProvider.getUserid(session);
        ShoppingManager shoppingManager = new ShoppingManager();
        ArrayList<ShoppingFormBean> shoppingFormBeans = shoppingManager.shoppingListShow(String.valueOf(userid));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("shoppingList",shoppingFormBeans);
        System.out.println(jsonObject.toString());
        System.out.println("This is UserId:"+userid);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/shopping/joinshopping")
    public String joinshopping(@RequestParam(value = "session")String session,
                               @RequestParam(value = "commodityId")int commodityId,
                               @RequestParam(value = "sizeName")String sizeName){
        int userid = SessionProvider.getUserid(session);
        ShoppingManager shoppingManager = new ShoppingManager();
        shoppingManager.shoppingJoin(String.valueOf(userid),sizeName,commodityId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request",true);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/shopping/deleshopping")
    public String deleshopping(@RequestParam(value = "session")String session,
                               @RequestParam(value = "commodityId")int commodityId,
                               @RequestParam(value = "sizeName")String sizeName){
        int userid = SessionProvider.getUserid(session);
        ShoppingManager shoppingManager = new ShoppingManager();
        shoppingManager.shoppingRemoveOnce(userid,commodityId,sizeName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request",true);
        return jsonObject.toString();
    }
}
