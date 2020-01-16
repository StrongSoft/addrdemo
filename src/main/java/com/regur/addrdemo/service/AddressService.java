package com.regur.addrdemo.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.regur.addrdemo.dto.AddressList;
import com.regur.addrdemo.dto.AddressSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Service
public class AddressService {
    private final RestTemplate restTemplate;

    public AddressService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AddressList getAddress(AddressSearch search) throws Exception{
        String url = "http://www.juso.go.kr/addrlink/addrLinkApi.do";
        ObjectMapper mapper = new ObjectMapper();

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("confmKey", search.getConfmKey())
                .queryParam("resultType", search.getResultType())
                .queryParam("keyword", search.getKeyword())
                .queryParam("countPerPage", search.getCountPerPage())
                .queryParam("currentPage", search.getCurrentPage())
                .build(false); // 자동 Encoding 막기

        String response = restTemplate.getForObject(uri.toString(), String.class);
        if(!StringUtils.isEmpty(response)){
            Map<String, Object> data = mapper.readValue(response, new TypeReference<Map<String, Object>>() {});
            return mapper.readValue(mapper.writeValueAsString(data.get("results")),AddressList.class);
        } else {
            return new AddressList();
        }
    }
}