package request;

import bean.json.CommodityJsonBean;
import manager.CommodityManager;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import provider.SessionProvider;

/**
 * starsky  make file at 2018/6/29
 * 代码是个艺术，请不要侮辱自己的审美
 */

@Controller
@EnableAutoConfiguration
public class CommodityRequest {

    private static Logger logger=LoggerFactory.getLogger(LoginRequest.class);

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/commodity/commodityinfo")
    public String CommodityInfo(
            @RequestParam(value = "commodityId")int commodityId,
            @RequestParam(value = "session",required = false) String session){
        String userNum = SessionProvider.getUserNum(session);
        CommodityManager commodityManager = new CommodityManager();
        CommodityJsonBean commodityJsonBean = commodityManager.commodityInfo(1, 50);
//        String s = JSONObject.toJSON(commodityJsonBean).toString();
        JSONObject jsonObject = JSONObject.fromObject(commodityJsonBean);
        return jsonObject.toString();
    }
}
