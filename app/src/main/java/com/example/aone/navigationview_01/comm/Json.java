package com.example.aone.navigationview_01.comm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aone on 2016/8/2.
 */
public class Json {

    public Json() {

    }

    /**
     * 对象下有数组，解析其中的一项
     *
     * @param jsonstr  json字符串
     * @param rootname 对象名称或根节点名称
     * @param arg0     属性值
     * @return 返回List<String> 类型
     * @throws JSONException
     */
    public static List<String> get_simple_list(String jsonstr, String rootname, String arg0) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonstr);
        JSONArray jsonArray = jsonObject.getJSONArray(rootname);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject2 = (JSONObject) jsonArray.get(i);
            list.add(jsonObject2.getString(arg0));
        }

        return list;
    }

    /**
     * 对象下有数组，解析json中所有的项目
     *
     * @param jsonstr
     * @param rootname
     * @param params
     * @return
     * @throws JSONException
     */
    public static List<Map<String, Object>> get_map_list(String jsonstr, String rootname, List<Object> params) throws JSONException {

        JSONObject jsonObject = new JSONObject(jsonstr);
        JSONArray jsonArray = jsonObject.getJSONArray(rootname);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = (JSONObject) jsonArray.get(i);
                Map<String, Object> map = new HashMap<String, Object>();
                for (int j = 0; j < params.size(); j++) {
                    if (!params.get(j).toString().equals("alarmstate")) {
                        map.put(params.get(j).toString(), jsonObject2.getString(params.get(j).toString()));
                    } else {
                        int a = jsonObject2.getInt(params.get(j).toString());
                        switch (a) {
                            case 0:
                                map.put(params.get(j).toString(), "通讯正常");
                                break;
                            case 1:
                                map.put(params.get(j).toString(), "上上限报警");
                                break;
                            case 2:
                                map.put(params.get(j).toString(), "上限报警");
                                break;
                            case 3:
                                map.put(params.get(j).toString(), "下下限报警");
                                break;
                            case 4:
                                map.put(params.get(j).toString(), "下限报警");
                                break;
                            case 5:
                                map.put(params.get(j).toString(), "通讯报警");
                                break;
                            case 6:
                                map.put(params.get(j).toString(), "状态报警");
                                break;
                            default:
                                break;
                        }
                    }
                }
                list.add(map);
            }
        }
        return list;
    }

}