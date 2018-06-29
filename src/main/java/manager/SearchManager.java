package manager;

import provider.SearchProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SearchManager {

    public static ArrayList getBigRangeList(){
        List<String> bigRangeList = SearchProvider.getBigRangeList();
        ArrayList resultList = new ArrayList();
        for (String string:
             bigRangeList){
            List<Object[]> itemRangeList = SearchProvider.getItemRangeList(string);
            HashMap<String, Object> aloneResult = new HashMap<String, Object>();
            aloneResult.put("bigRangeName",string);
            aloneResult.put("itemRangeList",itemRangeList);
            resultList.add(aloneResult);
        }
        return resultList;
    }

    public static HashMap<String, ArrayList> getBrandList(){
        List<String> brandList = SearchProvider.getBrandList();
        Collections.sort(brandList);
        HashMap<String, ArrayList> resultMap = new HashMap<String, ArrayList>();
        for (String s : brandList) {
            char c = s.charAt(0);
            c = Character.toUpperCase(c);
            if (resultMap.containsKey(String.valueOf(c))) {
                ArrayList arrayList = resultMap.get(String.valueOf(c));
                arrayList.add(s);
                resultMap.put(String.valueOf(c),arrayList);
            }else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(s);
                resultMap.put(String.valueOf(c),arrayList);
            }
        }
        return resultMap;
    }
}
