package study.batch.batchService.chunk.processor;

import study.batch.batchService.domain.ApiRequestVO;
import study.batch.batchService.domain.ProductVO;
import org.springframework.batch.item.ItemProcessor;
public class ApiItemProcessor3 implements ItemProcessor<ProductVO, ApiRequestVO> {

    @Override
    public ApiRequestVO process(ProductVO item) throws Exception {
        return ApiRequestVO.builder()
                .id(item.getId())
                .productVO(item)
                .build();
    }
}