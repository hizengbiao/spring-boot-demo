package com.zb.hikari.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
/**
 * Description
 *
 * @author
 * @date 2025/3/6
 */
public class MapConverter {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Map<String, Object> convertToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        JsonNode node = MAPPER.valueToTree(obj);

        node.fields().forEachRemaining(entry -> {
            JsonNode value = entry.getValue();
            // 过滤空节点（如 null、空字符串等）
            if (!isValueEmpty(value)) {
                map.put(entry.getKey(), MAPPER.convertValue(value, Object.class));
            }
        });
        return map;
    }

    private static boolean isValueEmpty(JsonNode node) {
        if (node.isNull()) {
            return true;
        }
        if (node.isTextual() && node.asText().trim().isEmpty()) {
            return true;
        }
        if (node.isArray() && node.size() == 0) {
            return true;
        }
        if (node.isObject() && node.size() == 0) {
            return true;
        }
        return false;
    }
}
