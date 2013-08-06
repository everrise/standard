package jp.co.everrisesample.minimum01.entity;

import java.sql.Timestamp;

import jp.co.everrisesample.minimum01.entity.ManufacturerNames._ManufacturerNames;

import org.seasar.extension.jdbc.name.PropertyName;

/**
 * Summary of {@link Product}'s properties
 *
 */
public class ProductNames {

    /**
     * return productId's name
     *
     */
    public static PropertyName<Long> productId() {
        return new PropertyName<Long>("productId");
    }

    /**
     * return name's name
     *
     */
    public static PropertyName<String> name() {
        return new PropertyName<String>("name");
    }

    /**
     * return manufacturerId's name
     *
     */
    public static PropertyName<Long> manufacturerId() {
        return new PropertyName<Long>("manufacturerId");
    }

    /**
     * return deletedAt's name
     *
     */
    public static PropertyName<Timestamp> deletedAt() {
        return new PropertyName<Timestamp>("deletedAt");
    }

    /**
     * return updatedAt's name
     *
     */
    public static PropertyName<Timestamp> updatedAt() {
        return new PropertyName<Timestamp>("updatedAt");
    }

    /**
     * return createdAt's name
     *
     */
    public static PropertyName<Timestamp> createdAt() {
        return new PropertyName<Timestamp>("createdAt");
    }

    /**
     * return manufacturer's property name
     *
     */
    public static _ManufacturerNames manufacturer() {
        return new _ManufacturerNames("manufacturer");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _ProductNames extends PropertyName<Product> {

        /**
         * build instance
         */
        public _ProductNames() {
        }

        /**
         * build instance
         *
         * @param name
         *            name
         */
        public _ProductNames(final String name) {
            super(name);
        }

        /**
         *  build instance
         *
         * @param parent
         *            parent
         * @param name
         *            name
         */
        public _ProductNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * return productId's property name
         *
         */
        public PropertyName<Long> productId() {
            return new PropertyName<Long>(this, "productId");
        }

        /**
         * return name's property name
         *
         */
        public PropertyName<String> name() {
            return new PropertyName<String>(this, "name");
        }

        /**
         * return manufacturerId's property name
         *
         */
        public PropertyName<Long> manufacturerId() {
            return new PropertyName<Long>(this, "manufacturerId");
        }

        /**
         * return deletedAt's property name
         *
         */
        public PropertyName<Timestamp> deletedAt() {
            return new PropertyName<Timestamp>(this, "deletedAt");
        }

        /**
         * return updatedAt's property name
         *
         */
        public PropertyName<Timestamp> updatedAt() {
            return new PropertyName<Timestamp>(this, "updatedAt");
        }

        /**
         * return createdAt's property name
         *
         */
        public PropertyName<Timestamp> createdAt() {
            return new PropertyName<Timestamp>(this, "createdAt");
        }

        /**
         * return manufacturer's property name
         *
         */
        public _ManufacturerNames manufacturer() {
            return new _ManufacturerNames(this, "manufacturer");
        }
    }
}