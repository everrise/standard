package jp.co.everrisesample.minimum01.service;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.OrderByItem;

import jp.co.everrisesample.minimum01.dao.ProductDao;
import jp.co.everrisesample.minimum01.dto.ListForPageDto;
import jp.co.everrisesample.minimum01.entity.Product;

public class ProductService extends AbstractService {

    @Resource
    private ProductDao productDao;

    public ListForPageDto<Product> findAllNamePageLimit(String name,
            OrderByItem orderByItem, int limit, int page) {
        ListForPageDto<Product> pageData = new ListForPageDto<Product>();
        pageData.resultList = productDao.findAllNamePageLimit(name,
                orderByItem, limit, page);
        pageData.total = pageData.resultList.size();
        pageData.page = page;
        pageData.limit = limit;
        return pageData;
    }

}
