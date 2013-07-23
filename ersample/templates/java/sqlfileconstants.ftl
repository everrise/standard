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
 * SQL File const class
 * 
 */
public final class ${shortClassName} {
<#list sqlFileConstantFieldModelList as constant>

    /**
     * const of {@code ${constant.path}}
     */
    public static final String ${constant.name} = "${constant.path}";
</#list>
}