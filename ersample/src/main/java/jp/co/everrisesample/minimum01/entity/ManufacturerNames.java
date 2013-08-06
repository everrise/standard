package jp.co.everrisesample.minimum01.entity;

import java.sql.Timestamp;

import jp.co.everrisesample.minimum01.entity.ProductNames._ProductNames;

import org.seasar.extension.jdbc.name.PropertyName;

/**
 * Summary of {@link Manufacturer}'s properties
 *
 */
public class ManufacturerNames {

    /**
     * return manufactureId's name
     *
     */
    public static PropertyName<Long> manufactureId() {
        return new PropertyName<Long>("manufactureId");
    }

    /**
     * return name's name
     *
     */
    public static PropertyName<String> name() {
        return new PropertyName<String>("name");
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
     * return product's property name
     *
     */
    public static _ProductNames product() {
        return new _ProductNames("product");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _ManufacturerNames extends PropertyName<Manufacturer> {

        /**
         * build instance
         */
        public _ManufacturerNames() {
        }

        /**
         * build instance
         *
         * @param name
         *            name
         */
        public _ManufacturerNames(final String name) {
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
        public _ManufacturerNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * return manufactureId's property name
         *
         */
        public PropertyName<Long> manufactureId() {
            return new PropertyName<Long>(this, "manufactureId");
        }

        /**
         * return name's property name
         *
         */
        public PropertyName<String> name() {
            return new PropertyName<String>(this, "name");
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
         * return product's property name
         *
         */
        public _ProductNames product() {
            return new _ProductNames(this, "product");
        }
    }
}