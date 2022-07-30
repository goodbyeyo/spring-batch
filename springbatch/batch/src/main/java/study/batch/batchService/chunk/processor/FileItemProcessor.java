package study.batch.batchService.chunk.processor;

import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;
import study.batch.batchService.domain.Product;
import study.batch.batchService.domain.ProductVO;

public class FileItemProcessor implements ItemProcessor<ProductVO, Product> {

    @Override
    public Product process(ProductVO item) throws Exception {
        return new ModelMapper().map(item, Product.class);
    }
}
