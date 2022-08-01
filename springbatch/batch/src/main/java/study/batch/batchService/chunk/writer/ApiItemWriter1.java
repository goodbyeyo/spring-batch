package study.batch.batchService.chunk.writer;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;
import study.batch.batchService.domain.ApiRequestVO;
import study.batch.batchService.domain.ApiResponseVO;
import study.batch.service.AbstractApiService;

import java.util.List;

@RequiredArgsConstructor
//public class ApiItemWriter1 implements ItemWriter<ApiRequestVO> {
public class ApiItemWriter1 extends FlatFileItemWriter<ApiRequestVO> {

    private final AbstractApiService apiService;

    @Override
    public void write(List<? extends ApiRequestVO> items) throws Exception {
        ApiResponseVO responseVO = apiService.service(items);
        System.out.println("responseVO = " + responseVO);

        items.forEach(item -> item.setApiResponseVO(responseVO));

        super.setResource(new FileSystemResource("/Users/wook/Study/spring-batch/springbatch/batch/src/main/resources/product1.txt"));  // 파일 쓸 경로
        super.open(new ExecutionContext());
        super.setLineAggregator(new DelimitedLineAggregator<>());   // 구분자 기호 방식
        super.setAppendAllowed(true);   //응답 값 계속 추가 여부
        super.write(items);
    }
}
