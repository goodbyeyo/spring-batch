package study.batch.batchService.chunk.writer;

import org.springframework.batch.item.ItemWriter;
import study.batch.batchService.domain.ApiRequestVO;

import java.util.List;

public class ApiItemWriter2 implements ItemWriter<ApiRequestVO> {

    @Override
    public void write(List<? extends ApiRequestVO> items) throws Exception {
    }
}
