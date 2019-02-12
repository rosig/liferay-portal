package ${configYAML.apiPackagePath}.internal.resource.${versionDirName};

<#compress>
	<#list openAPIYAML.components.schemas?keys as schemaName>
		import ${configYAML.apiPackagePath}.dto.${versionDirName}.${schemaName};
	</#list>
</#compress>

import ${configYAML.apiPackagePath}.resource.${versionDirName}.${schemaName}Resource;

import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.context.AcceptLanguage;
import com.liferay.portal.vulcan.context.Pagination;
import com.liferay.portal.vulcan.dto.Page;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * @author ${configYAML.author}
 * @generated
 */
@Generated("")
public abstract class Base${schemaName}ResourceImpl implements ${schemaName}Resource {

	public static final String ODATA_ENTITY_MODEL_NAME = "${stringUtil.replace("${configYAML.apiPackagePath}.dto.${versionDirName}.${schemaName}EntityModel", ".", "_")}";

	<#if openAPIYAML.pathItems??>
		<#list openAPIYAML.pathItems?keys as path>
			<#assign pathItem = openAPIYAML.pathItems[path] />

			<#list javaTool.getOperations(pathItem) as operation>
				<#assign javaSignature = javaTool.getJavaSignature(configYAML, openAPIYAML, operation, path, pathItem, schemaName) />

				<#if !stringUtil.equals(javaSignature.returnType, schemaName) && !stringUtil.equals(javaSignature.returnType, "Page<${schemaName}>") && !stringUtil.endsWith(javaSignature.methodName, schemaName)>
					<#continue>
				</#if>

				@Override
				<@compress single_line=true>
					public ${javaSignature.returnType} ${javaSignature.methodName}(
						<#list javaSignature.javaParameters as javaParameter>
							${javaParameter.parameterType} ${javaParameter.parameterName}

							<#if javaParameter_has_next>
								,
							</#if>
						</#list>
					) throws Exception {
				</@compress>

				<#assign methodBody>
					<#if stringUtil.equals(javaSignature.returnType, "Response")>
						Response.ResponseBuilder responseBuilder = Response.ok();

						return responseBuilder.build();
					<#elseif stringUtil.equals(javaSignature.returnType, "Page<" + schemaName + ">")>
						return Page.of(Collections.emptyList());
					<#else>
						return new ${javaSignature.returnType}();
					</#if>
				</#assign>

				<#list methodBody?split("\n") as line>
					${line?replace("^\t\t\t\t", "", "r")}<#lt>
				</#list>

				}
			</#list>
		</#list>
	</#if>

	protected Response buildNoContentResponse() {
		Response.ResponseBuilder responseBuilder = Response.noContent();

		return responseBuilder.build();
	}

	protected <T, R> List<R> transform(List<T> list, UnsafeFunction<T, R, Exception> unsafeFunction) {
		return TransformUtil.transform(list, unsafeFunction);
	}

	@Context
	protected AcceptLanguage acceptLanguage;

	@Context
	protected Company company;

}