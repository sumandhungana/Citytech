package global.citytech.interns.crm.platform.utils;

import jakarta.json.JsonArray;
import jakarta.json.JsonException;
import jakarta.json.JsonObject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class JsonUtils {
    private static JsonbConfig jsonbConfig = new JsonbConfig();
            //.withPropertyVisibilityStrategy(new PrivateVisibilityStrategy()).withNullValues(true);
    private static Jsonb jsonb = JsonbBuilder.create(jsonbConfig);

    private JsonUtils() {
    }

    public static <T> String toJsonObj(T obj) {
        return jsonb.toJson(obj);
    }

    public static <T> T fromJsonToObj(String jsonString, Class<T> obj) {
        if (!isValidJsonString(jsonString)) {
            throw new IllegalArgumentException(" Invalid Json data.");
        } else {
            return jsonb.fromJson(jsonString, obj);
        }
    }

    public static <T> List<T> fromJsonToList(String jsonString, Class<T> obj) {
        if(!isValidJsonString(jsonString)){
            return Collections.EMPTY_LIST;
        }
        List<Map> mapList = jsonb.fromJson(jsonString, new ArrayList<Map>(){}.getClass().getGenericSuperclass());
        return mapList.stream().map(item -> jsonb.fromJson(jsonb.toJson(item),obj)).collect(Collectors.toList());
    }

    public static <T> List<T> fromJsonToList(String jsonString, Type t) {
        return !isValidJsonString(jsonString) ? Collections.EMPTY_LIST : jsonb.fromJson(jsonString, t);
    }

    public static Map<String, Object> jsonToMap(JsonObject json) throws JsonException {
        Map<String, Object> retMap = new HashMap<>();
        if(json != JsonObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    public static Map<String, Object> toMap(JsonObject object) throws JsonException {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keysItr = object.keySet().iterator();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JsonArray) {
                value = toList((JsonArray) value);
            }

            else if(value instanceof JsonObject) {
                value = toMap((JsonObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JsonArray array) throws JsonException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.size(); i++) {
            Object value = array.get(i);
            if(value instanceof JsonArray) {
                value = toList((JsonArray) value);
            }
            else if(value instanceof JsonObject) {
                value = toMap((JsonObject) value);
            }
            list.add(value);
        }
        return list;
    }

    public static boolean isValidJsonString(String jsonString) {
        if (HelperUtils.isBlankOrNull(jsonString)) {
            return false;
        } else {
            try {
                jsonb.fromJson(jsonString, Object.class);
                return true;
            } catch (Exception var2) {
                return false;
            }
        }
    }
}
