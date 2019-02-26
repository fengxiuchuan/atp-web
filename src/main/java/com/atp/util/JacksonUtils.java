package com.atp.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Description Jackson 转换工具类
 * @Author: fengxiuchuan
 * @Date : 2018/10/17 14 40
 */
public class JacksonUtils {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(JacksonUtils.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JacksonUtils() {
    }

    public static String encode(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            logger.error("encode(Object)", e); //$NON-NLS-1$
        } catch (JsonMappingException e) {
            logger.error("encode(Object)", e); //$NON-NLS-1$
        } catch (IOException e) {
            logger.error("encode(Object)", e); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 将json string反序列化成对象
     *
     * @param json
     * @param valueType
     * @return
     */
    public static <T> T decode(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonParseException e) {
            logger.error("decode(String, Class<T>)", e);
        } catch (JsonMappingException e) {
            logger.error("decode(String, Class<T>)", e);
        } catch (IOException e) {
            logger.error("decode(String, Class<T>)", e);
        }
        return null;
    }

    /**
     * 将json array反序列化为对象
     *
     * @param json
     * @param jsonTypeReference
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T decode(String json, TypeReference<T> typeReference) {
        try {
            return (T) objectMapper.readValue(json, typeReference);
        } catch (JsonParseException e) {
            logger.error("decode(String, JsonTypeReference<T>)", e);
        } catch (JsonMappingException e) {
            logger.error("decode(String, JsonTypeReference<T>)", e);
        } catch (IOException e) {
            logger.error("decode(String, JsonTypeReference<T>)", e);
        }
        return null;
    }


    public static void main(String[] args) {
        /*API_ATTRS api_attrs = new API_ATTRS();
        api_attrs.setTime_Stamp(DateUtil.format(new Date(),DateUtil.PATTERN_CLASSICAL_MIS));
        api_attrs.setUser_Token("");
        api_attrs.setSign("");
        REQUEST_DATA REQUEST_DATA = new REQUEST_DATA();
        String postStr = JacksonUtils.encode(RequestUtil.createAppAccessRequest(api_attrs,REQUEST_DATA));
        System.out.println(postStr);*/

        String json = "{\"RESPONSE\":{\"RETURN_CODE\":\"EOS00099\",\"RETURN_DATA\":\"\",\"RETURN_DESC\":\"oauth server is other error,errorType[org.springframework.http.converter.HttpMessageNotReadableException] ,errorInfo[JSON parse error: Can not construct instance of com.alibaba.fastjson.JSONObject: no String-argument constructor/factory method to deserialize from String value ('{\\\"REQUEST\\\":{\\\"API_ATTRS\\\":{\\\"Api_ID\\\":\\\"crc.ssdp.public.appaccess\\\",\\\"Api_Version\\\":\\\"1.0\\\",\\\"App_Sub_ID\\\":\\\"0000000901AO\\\",\\\"App_Token\\\":\\\"0666b1c911e644e5ad7765a623c2c318\\\",\\\"Partner_ID\\\":\\\"00000000\\\",\\\"Sign\\\":\\\"\\\",\\\"Sys_ID\\\":\\\"00000009\\\",\\\"Time_Stamp\\\":\\\"2018-12-10 16:20:36:275\\\",\\\"User_Token\\\":\\\"\\\"},\\\"REQUEST_DATA\\\":{\\\"App_Pub_ID\\\":\\\"O000000101RP\\\",\\\"Scope\\\":\\\"\\\",\\\"Remarks\\\":\\\"\\\"}}}'); nested exception is com.fasterxml.jackson.databind.JsonMappingException: Can not construct instance of com.alibaba.fastjson.JSONObject: no String-argument constructor/factory method to deserialize from String value ('{\\\"REQUEST\\\":{\\\"API_ATTRS\\\":{\\\"Api_ID\\\":\\\"crc.ssdp.public.appaccess\\\",\\\"Api_Version\\\":\\\"1.0\\\",\\\"App_Sub_ID\\\":\\\"0000000901AO\\\",\\\"App_Token\\\":\\\"0666b1c911e644e5ad7765a623c2c318\\\",\\\"Partner_ID\\\":\\\"00000000\\\",\\\"Sign\\\":\\\"\\\",\\\"Sys_ID\\\":\\\"00000009\\\",\\\"Time_Stamp\\\":\\\"2018-12-10 16:20:36:275\\\",\\\"User_Token\\\":\\\"\\\"},\\\"REQUEST_DATA\\\":{\\\"App_Pub_ID\\\":\\\"O000000101RP\\\",\\\"Scope\\\":\\\"\\\",\\\"Remarks\\\":\\\"\\\"}}}')\\n at [Source: java.io.PushbackInputStream@679cc1b3; line: 1, column: 1]]\",\"RETURN_STAMP\":\"2018-12-10 16:20:35:894\"}}\n";
        JSONObject jsonObject = JSON.parseObject(json);
        String responseStr = jsonObject.get("RESPONSE").toString();
        String returnCode = JSON.parseObject(responseStr).getString("RETURN_CODE");
        System.out.println(returnCode);
        System.out.println("---");
    }
}
