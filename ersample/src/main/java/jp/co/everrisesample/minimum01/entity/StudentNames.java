package jp.co.everrisesample.minimum01.entity;

import java.sql.Timestamp;

import org.seasar.extension.jdbc.name.PropertyName;

/**
 * Summary of {@link Student}'s properties
 *
 */
public class StudentNames {

    /**
     * return id's name
     *
     */
    public static PropertyName<Long> id() {
        return new PropertyName<Long>("id");
    }

    /**
     * return name's name
     *
     */
    public static PropertyName<String> name() {
        return new PropertyName<String>("name");
    }

    /**
     * return address's name
     *
     */
    public static PropertyName<String> address() {
        return new PropertyName<String>("address");
    }

    /**
     * return email's name
     *
     */
    public static PropertyName<String> email() {
        return new PropertyName<String>("email");
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
    public static class _StudentNames extends PropertyName<Student> {

        /**
         * build instance
         */
        public _StudentNames() {
        }

        /**
         * build instance
         *
         * @param name
         *            name
         */
        public _StudentNames(final String name) {
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
        public _StudentNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * return id's property name
         *
         */
        public PropertyName<Long> id() {
            return new PropertyName<Long>(this, "id");
        }

        /**
         * return name's property name
         *
         */
        public PropertyName<String> name() {
            return new PropertyName<String>(this, "name");
        }

        /**
         * return address's property name
         *
         */
        public PropertyName<String> address() {
            return new PropertyName<String>(this, "address");
        }

        /**
         * return email's property name
         *
         */
        public PropertyName<String> email() {
            return new PropertyName<String>(this, "email");
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