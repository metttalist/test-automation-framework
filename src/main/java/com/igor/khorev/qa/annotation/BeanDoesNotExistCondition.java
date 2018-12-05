package com.igor.khorev.qa.annotation;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Created by metttalist on 9/5/18.
 */
public class BeanDoesNotExistCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(
                "TestComponent");

        String objectName = null;
        if (annotationAttributes != null) {
            objectName = (String) annotationAttributes.get("value");
        }

        return StringUtils.isBlank(objectName) || !context.getRegistry().containsBeanDefinition(objectName);
    }
}
