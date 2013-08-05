package jp.co.everrisesample.minimum01.dao;

import static jp.co.everrisesample.minimum01.entity.Names.product;
import static org.seasar.extension.jdbc.operation.Operations.asc;
import static org.seasar.extension.jdbc.operation.Operations.contains;
import static org.seasar.extension.jdbc.operation.Operations.isNull;

import java.util.List;

import org.seasar.extension.jdbc.OrderByItem;

import jp.co.everrisesample.minimum01.entity.Product;

public class ProductDao extends AbstractDao<Product> {

    /**
     * @author TanTai
     * @return
     */
    public List<Product> findAllNamePageLimit(String name,
            OrderByItem orderByItem, int limit, int page) {
        return select()
                .where(contains(product().name(), name),
                        isNull(product().deletedAt()))
                .orderBy(orderByItem, asc(product().productId())).limit(limit)
                .offset(limit * (page - 1)).getResultList();
    }
}