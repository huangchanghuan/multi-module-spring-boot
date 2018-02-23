package com.yimi.product.sos.version;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Comparator;

public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    /**
     * 类级别的版本注解
     * @param handlerType
     * @return
     */
    @Override
    protected RequestCondition<ApiVesrsionCondition> getCustomTypeCondition(Class<?> handlerType) {
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
        return createCondition(apiVersion);
    }

    /**
     * 方法级别的版本注解
     * @param method
     * @return
     */
    @Override
    protected RequestCondition<ApiVesrsionCondition> getCustomMethodCondition(Method method) {
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
        return createCondition(apiVersion);
    }
    
    private RequestCondition<ApiVesrsionCondition> createCondition(ApiVersion apiVersion) {
        return apiVersion == null ? null : new ApiVesrsionCondition(apiVersion.value());
    }

    /**
     * Provide a Comparator to sort RequestMappingInfos matched to a request.
     * 排序:首先按版本排序,版本排序,再按默认排序
     */
    @Override
    protected Comparator<RequestMappingInfo> getMappingComparator(final HttpServletRequest request) {
        return new Comparator<RequestMappingInfo>() {
            @Override
            public int compare(RequestMappingInfo info1, RequestMappingInfo info2) {
                //先按版本进行排序
                int versionResult = compareVersion(info1, info2);
                if (versionResult!= 0) {
                    return versionResult;
                }
                //再按默认排序
                return info1.compareTo(info2, request);
            }
            //版本条件进行排序
            private int compareVersion(RequestMappingInfo info1, RequestMappingInfo info2){
                ApiVesrsionCondition version1= (ApiVesrsionCondition) info1.getCustomCondition();
                ApiVesrsionCondition version2= (ApiVesrsionCondition) info2.getCustomCondition();
                //优选按版本排序
                if (version1== null && version2== null) {
                    return 0;
                }
                else if (version1 == null) {
                    return 1;
                }
                else if (version2 == null) {
                    return -1;
                }
                else {
                    Class<?> clazz = version1.getClass();
                    Class<?> otherClazz = version2.getClass();
                    if (!clazz.equals(otherClazz)) {
                        throw new ClassCastException("Incompatible request conditions: " + clazz + " and " + otherClazz);
                    }
                    return version1.compareTo(version2, request);
                }
            }
        };
    }
}
