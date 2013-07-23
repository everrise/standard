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
 * Summary of names class
 * 
 */
public class ${shortClassName} {
<#list namesModelList as namesModel>

    /**
     * return name class of {@link ${namesModel.shortEntityClassName}}
     * 
     */
    public static ${namesModel.shortInnerClassName} ${namesModel.shortEntityClassName?uncap_first}() {
        return new ${namesModel.shortInnerClassName}();
    }
</#list>
}