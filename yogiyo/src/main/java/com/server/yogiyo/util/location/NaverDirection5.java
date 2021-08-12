package com.server.yogiyo.util.location;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;

@Component
public class NaverDirection5 {

    @Value("${naver.API_KEY_ID}")
    private String X_NCP_APIGW_API_KEY_ID;

    @Value("${naver.API_KEY}")
    private String X_NCP_APIGW_API_KEY;


    public String getDistance(String x, String y) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-NCP-APIGW-API-KEY-ID", X_NCP_APIGW_API_KEY_ID);
        headers.add("X-NCP-APIGW-API-KEY", X_NCP_APIGW_API_KEY);
        String body = "";
        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity =
                rest.exchange("https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving?start="+x+"&goal="+y+"&option=traoptimal", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        JSONObject route = new JSONObject(responseEntity.getBody()).getJSONObject("route");
        Object traoptimalObj
                = new JSONObject(route.getJSONArray("traoptimal").get(0).toString()).getJSONObject("summary").get("distance");
        Double distance = Double.parseDouble(traoptimalObj.toString())/1000.0;
        String format = new DecimalFormat("#.##").format(distance);
        return format;
    }

}
