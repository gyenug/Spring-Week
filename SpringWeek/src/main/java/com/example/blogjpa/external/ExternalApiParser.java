package com.example.blogjpa.external;

import com.example.blogjpa.Service.BlogService;
import com.example.blogjpa.dto.AddArticleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@Component
public class ExternalApiParser {
    private final BlogService service;

    public ExternalApiParser(BlogService service){
        this.service = service;
    }

    public void parser(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";

        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);

        if(response.getStatusCode().is1xxInformational()){
            log.info("body{}", response.getBody());
            List<LinkedHashMap<String,Object>> list = response.getBody();
            //title, Body
            for(LinkedHashMap<String, Object> map:list){
                String title =(String) map.get("title");
                String content = (String) map.get("body");

                service.save(new AddArticleRequest(title,content));
            }
        }
    }

}
