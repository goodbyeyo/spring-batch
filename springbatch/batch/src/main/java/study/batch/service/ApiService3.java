package study.batch.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import study.batch.batchService.domain.ApiInfo;
import study.batch.batchService.domain.ApiResponseVO;

@Service
public class ApiService3 extends AbstractApiService{
    @Override
    protected ApiResponseVO doApiService(RestTemplate restTemplate, ApiInfo apiInfo) {

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8083/api/product/1", apiInfo, String.class);
        int statusCode = responseEntity.getStatusCodeValue();
        return ApiResponseVO.builder()
                .status(statusCode)
                .msg(responseEntity.getBody())
                .build();
    }
}