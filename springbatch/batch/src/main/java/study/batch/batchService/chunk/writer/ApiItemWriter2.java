package study.batch.batchService.chunk.writer;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import study.batch.batchService.domain.ApiRequestVO;
import study.batch.batchService.domain.ApiResponseVO;
import study.batch.service.AbstractApiService;

import java.util.List;

@RequiredArgsConstructor
public class ApiItemWriter2 implements ItemWriter<ApiRequestVO> {

    private final AbstractApiService apiService;

    @Override
    public void write(List<? extends ApiRequestVO> items) throws Exception {
        ApiResponseVO responseVO = apiService.service(items);
        System.out.println("responseVO = " + responseVO);
    }
}
