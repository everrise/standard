package jp.co.everrisesample.minimum01.entity;

import java.sql.Date;
import java.sql.Timestamp;

import org.seasar.extension.jdbc.name.PropertyName;

/**
 * Summary of {@link User}'s properties
 *
 */
public class UserNames {

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
     * return loginId's name
     *
     */
    public static PropertyName<String> loginId() {
        return new PropertyName<String>("loginId");
    }

    /**
     * return password's name
     *
     */
    public static PropertyName<String> password() {
        return new PropertyName<String>("password");
    }

    /**
     * return departmentId's name
     *
     */
    public static PropertyName<Long> departmentId() {
        return new PropertyName<Long>("departmentId");
    }

    /**
     * return birthday's name
     *
     */
    public static PropertyName<Date> birthday() {
        return new PropertyName<Date>("birthday");
    }

    /**
     * return memo's name
     *
     */
    public static PropertyName<String> memo() {
        return new PropertyName<String>("memo");
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
    public static class _UserNames extends PropertyName<User> {

        /**
         * build instance
         */
        public _UserNames() {
        }

        /**
         * build instance
         *
         * @param name
         *            name
         */
        public _UserNames(final String name) {
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
        public _UserNames(final PropertyName<?> parent, final String name) {
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
         * return loginId's property name
         *
         */
        public PropertyName<String> loginId() {
            return new PropertyName<String>(this, "loginId");
        }

        /**
         * return password's property name
         *
         */
        public PropertyName<String> password() {
            return new PropertyName<String>(this, "password");
        }

        /**
         * return departmentId's property name
         *
         */
        public PropertyName<Long> departmentId() {
            return new PropertyName<Long>(this, "departmentId");
        }

        /**
         * return birthday's property name
         *
         */
        public PropertyName<Date> birthday() {
            return new PropertyName<Date>(this, "birthday");
        }

        /**
         * return memo's property name
         *
         */
        public PropertyName<String> memo() {
            return new PropertyName<String>(this, "memo");
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