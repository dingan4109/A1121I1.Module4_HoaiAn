package dictionary.repository;

import java.util.HashMap;
import java.util.Map;

public class DicMap implements DicMapInterface{
    private Map<String,String> dicMap = new HashMap<>();
    {
        dicMap.put("hello","xin chào");
        dicMap.put("bye","tạm biệt");
        dicMap.put("student","học sinh");
        dicMap.put("teacher","giáo viên");
        dicMap.put("class","lớp");
    }

    public String getValue(String key) {
       return dicMap.get(key);
    }

}
