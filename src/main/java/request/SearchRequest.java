package request;

import bean.json.CommendationListJsonBean;
import com.google.gson.JsonObject;
import manager.SearchManager;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

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
        ArrayList<HashMap> bigRangeList = SearchManager.getBrandList();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("brandlist",bigRangeList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brandList",bigRangeList);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/search/description")
    public String descriptionVague(@RequestParam(value = "description") String desVague) {
        SearchManager searchManager = new SearchManager();
        ArrayList<CommendationListJsonBean> commendationListJsonBeans = searchManager.descriptionVague(desVague);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rangeSearch",commendationListJsonBeans);
        jsonObject.put("findkey",desVague);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/search/rangesearch")
    public String rangeSearch(@RequestParam(value = "rangeSearch") String rangeSearch) {
        SearchManager searchManager = new SearchManager();
        ArrayList<CommendationListJsonBean> commendationListJsonBeans = searchManager.rangeSearch(rangeSearch);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rangeSearch",commendationListJsonBeans);
        jsonObject.put("findkey",rangeSearch);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/search/brandSearch")
    public String brandSearch(@RequestParam(value = "brandSearch") String brandSearch) {
        SearchManager searchManager = new SearchManager();
        ArrayList<CommendationListJsonBean> commendationListJsonBeans = searchManager.brandSearch(brandSearch);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rangeSearch",commendationListJsonBeans);
        jsonObject.put("findkey",brandSearch);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }
}
