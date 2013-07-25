package jp.co.everrisesample.minimum01.entity;

import java.sql.Timestamp;

import org.seasar.extension.jdbc.name.PropertyName;

/**
 * Summary of {@link Chart}'s properties
 *
 */
public class ChartNames {

    /**
     * return id's name
     *
     */
    public static PropertyName<Integer> id() {
        return new PropertyName<Integer>("id");
    }

    /**
     * return chart's name
     *
     */
    public static PropertyName<String> chart() {
        return new PropertyName<String>("chart");
    }

    /**
     * return chartId's name
     *
     */
    public static PropertyName<Integer> chartId() {
        return new PropertyName<Integer>("chartId");
    }

    /**
     * return chartCountry's name
     *
     */
    public static PropertyName<String> chartCountry() {
        return new PropertyName<String>("chartCountry");
    }

    /**
     * return chartQuantity's name
     *
     */
    public static PropertyName<Integer> chartQuantity() {
        return new PropertyName<Integer>("chartQuantity");
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
     * @author S2JDBC-Gen
     */
    public static class _ChartNames extends PropertyName<Chart> {

        /**
         * build instance
         */
        public _ChartNames() {
        }

        /**
         * build instance
         *
         * @param name
         *            name
         */
        public _ChartNames(final String name) {
            super(name);
        }

        /**
         * build instance
         *
         * @param parent
         *            parent
         * @param name
         *            name
         */
        public _ChartNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * return id's property name
         *
         */
        public PropertyName<Integer> id() {
            return new PropertyName<Integer>(this, "id");
        }

        /**
         * return chart's property name
         *
         */
        public PropertyName<String> chart() {
            return new PropertyName<String>(this, "chart");
        }

        /**
         * return chartId's property name
         *
         */
        public PropertyName<Integer> chartId() {
            return new PropertyName<Integer>(this, "chartId");
        }

        /**
         * return chartCountry's property name
         *
         */
        public PropertyName<String> chartCountry() {
            return new PropertyName<String>(this, "chartCountry");
        }

        /**
         * return chartQuantity's property name
         *
         */
        public PropertyName<Integer> chartQuantity() {
            return new PropertyName<Integer>(this, "chartQuantity");
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
    }
}