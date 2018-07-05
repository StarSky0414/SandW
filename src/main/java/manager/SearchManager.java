package manager;

import bean.json.CommendationListJsonBean;
import provider.SearchProvider;

import java.util.*;

/**
 * starsky  make file at 2018/6/25
 * 代码是个艺术，请不要侮辱自己的审美
 */
public class SearchManager {

    public static ArrayList getBigRangeList(){
        ArrayList<HashMap> brandList = new ArrayList<HashMap>();
        HashMap<String, Object> brandNameValue = new HashMap<String, Object>();
        ArrayList stringArrayListHashMap = sexClassifyBigRange("0");
        brandNameValue.put("className","Man");
        brandNameValue.put("classValue",stringArrayListHashMap);
        brandList.add(brandNameValue);

        brandNameValue = new HashMap<String, Object>();
        stringArrayListHashMap = sexClassifyBigRange("1");
        brandNameValue.put("className","Girl");
        brandNameValue.put("classValue",stringArrayListHashMap);
        brandList.add(brandNameValue);

        brandNameValue = new HashMap<String, Object>();
        stringArrayListHashMap = sexClassifyBigRange("2");
        brandNameValue.put("className","Children");
        brandNameValue.put("classValue",stringArrayListHashMap);
        brandList.add(brandNameValue);

        return brandList;
    }

    public static ArrayList<HashMap> getBrandList(){
        ArrayList<HashMap> brandList = new ArrayList<HashMap>();
        HashMap<String, Object> brandNameValue = new HashMap<String, Object>();
        ArrayList stringArrayListHashMap = sexClassifyBrandList("0");
        brandNameValue.put("className","Man");
        brandNameValue.put("classValue",stringArrayListHashMap);
        brandList.add(brandNameValue);

        brandNameValue = new HashMap<String, Object>();
        stringArrayListHashMap = sexClassifyBrandList("1");
        brandNameValue.put("className","Girl");
        brandNameValue.put("classValue",stringArrayListHashMap);
        brandList.add(brandNameValue);

        brandNameValue = new HashMap<String, Object>();
        stringArrayListHashMap = sexClassifyBrandList("2");
        brandNameValue.put("className","Children");
        brandNameValue.put("classValue",stringArrayListHashMap);
        brandList.add(brandNameValue);

        return brandList;
    }

    private static ArrayList sexClassifyBrandList(String sexNum){
        List<String> brandList = SearchProvider.getBrandList(sexNum);
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

        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry :
                resultMap.entrySet()) {
            HashMap hashMap = new HashMap();
            hashMap.put("charClassName",entry.getKey());
            hashMap.put("charClassValue",entry.getValue());
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    private static ArrayList sexClassifyBigRange(String sexNum){
        List<String> bigRangeList = SearchProvider.getBigRangeList(sexNum);
        ArrayList resultList = new ArrayList();
        for (String string:
                bigRangeList){
            List<Object[]> itemRangeList = SearchProvider.getItemRangeList(string,sexNum);
            HashMap<String, Object> aloneResult = new HashMap<String, Object>();
            aloneResult.put("bigRangeName",string);
            aloneResult.put("itemRangeList",itemRangeList);
            resultList.add(aloneResult);
        }
        return resultList;
    }

    public ArrayList<CommendationListJsonBean> descriptionVague(String desString){
        SearchProvider searchProvider = new SearchProvider();
        ArrayList<CommendationListJsonBean> commendationListJsonBeans = searchProvider.descriptionVague(desString);
        return commendationListJsonBeans;
    }

    public ArrayList<CommendationListJsonBean> rangeSearch(String rangeSearchString){
        SearchProvider searchProvider = new SearchProvider();
        ArrayList<CommendationListJsonBean> commendationListJsonBeans = searchProvider.rangeSearch(rangeSearchString);
        return commendationListJsonBeans;
    }

    public ArrayList<CommendationListJsonBean> brandSearch(String brandSearchString){
        SearchProvider searchProvider = new SearchProvider();
        ArrayList<CommendationListJsonBean> commendationListJsonBeans = searchProvider.brandSearch(brandSearchString);
        return commendationListJsonBeans;
    }
}
