<#import "/lib.ftl" as lib>
<#if lib.copyright??>
${lib.copyright}
</#if>
<#if !lib.copyright??>
<#include "/copyright.ftl">
</#if>
<#if packageName??>
package ${packageName};
</#if>

<#list importNameSet as importName>
import ${importName};
</#list>
<#if staticImportNameSet?size gt 0>

  <#list staticImportNameSet as importName>
import static ${importName};
  </#list>
</#if>

/**
 * Summary of {@link ${shortEntityClassName}}'s properties
 * 
 */
public class ${shortClassName} {
<#list namesAttributeModelList as attr>

    /**
     * return ${attr.name}'s name
     * 
     */
    public static PropertyName<${attr.attributeClass.simpleName}> ${attr.name}() {
        return new PropertyName<${attr.attributeClass.simpleName}>("${attr.name}");
    }
</#list>
<#list namesAssociationModelList as asso>

    /**
     * return ${asso.name}'s property name
     * 
     */
    public static ${asso.shortClassName} ${asso.name}() {
        return new ${asso.shortClassName}("${asso.name}");
    }
</#list>

    /**
     * @author S2JDBC-Gen
     */
    public static class ${shortInnerClassName} extends PropertyName<${shortEntityClassName}> {

        /**
         * build instance
         */
        public ${shortInnerClassName}() {
        }

        /**
         * build instance
         * 
         * @param name
         *            name
         */
        public ${shortInnerClassName}(final String name) {
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
        public ${shortInnerClassName}(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }
<#list namesAttributeModelList as attr>

        /**
         * return ${attr.name}'s property name
         *
         */
        public PropertyName<${attr.attributeClass.simpleName}> ${attr.name}() {
            return new PropertyName<${attr.attributeClass.simpleName}>(this, "${attr.name}");
        }
</#list>
<#list namesAssociationModelList as asso>

        /**
         * return ${asso.name}'s property name
         * 
         */
        public ${asso.shortClassName} ${asso.name}() {
            return new ${asso.shortClassName}(this, "${asso.name}");
        }
</#list>
    }
}