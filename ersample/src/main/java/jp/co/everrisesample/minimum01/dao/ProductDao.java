package jp.co.everrisesample.minimum01.dao;

import static org.seasar.extension.jdbc.operation.Operations.asc;
import static org.seasar.extension.jdbc.operation.Operations.contains;
import static org.seasar.extension.jdbc.operation.Operations.isNull;
import static jp.co.everrisesample.minimum01.entity.Names.*;
import java.util.List;
import jp.co.everrisesample.minimum01.entity.Product;
import org.seasar.extension.jdbc.OrderByItem;
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
    public long countAllName(String name) {
        return select()
                .where(contains(product().name(), name),
                        isNull(product().deletedAt()))
                        .getCount();
    }

}