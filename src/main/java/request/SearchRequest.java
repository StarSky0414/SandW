package request;

import com.alibaba.fastjson.JSONObject;
import manager.SearchManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */

@Controller
@EnableAutoConfiguration
public class SearchRequest {
    private static Logger logger=LoggerFactory.getLogger(LoginRequest.class);

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/search/rangelist")
    public String bigRangeList(){
        ArrayList bigRangeList = SearchManager.getBigRangeList();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bigRangeList",bigRangeList);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/search/brandlist")
    public String brandList(){
        HashMap<String, ArrayList> bigRangeList = SearchManager.getBrandList();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("brandlist",bigRangeList);
        return JSONObject.toJSON(bigRangeList).toString();
    }

}
