package study.batch.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import study.batch.batchService.domain.ApiInfo;
import study.batch.batchService.domain.ApiRequestVO;
import study.batch.batchService.domain.ApiResponseVO;

import java.io.IOException;
import java.util.List;

public abstract class AbstractApiService {

    public ApiResponseVO service(List<? extends ApiRequestVO> apiRequest) {

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.errorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {

            }
        }).build();

        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ApiInfo apiInfo = ApiInfo.builder().apiRequestList(apiRequest).build();
        HttpEntity<ApiInfo> reqEntity = new HttpEntity<>(apiInfo, headers);

        return doApiService(restTemplate, apiInfo);
    }

    protected abstract ApiResponseVO doApiService(RestTemplate restTemplate, ApiInfo apiInfo);
}
