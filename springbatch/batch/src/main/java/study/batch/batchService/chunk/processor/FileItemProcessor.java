package study.batch.batchService.chunk.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;
import study.batch.batchService.domain.Product;
import study.batch.batchService.domain.ProductVO;

import java.io.DataInput;

public class FileItemProcessor implements ItemProcessor<ProductVO, Product> {

    @Override
    public Product process(ProductVO item) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(item, Product.class);

//        ObjectMapper mapper = new ObjectMapper();
//        Product product = mapper.readValue((DataInput) item, Product.class);
        return product;
    }
}
